package mirzhana.com.afinal

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher

import kotlinx.android.synthetic.main.activity_main.*

import mirzhana.com.afinal.model.Contact
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    var dataset: ArrayList<Contact> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val myDB = ContactDatabase.getInstance(this)

        loadContacts(myDB!!)

        fab.setOnClickListener {
            startActivityForResult(Intent(this, AddContactActivity::class.java), 1)

        }

        search.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(editable: Editable?) {
                filter(editable.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })


    }
    fun filter(text: String){
        val filteredContacts: ArrayList<Contact> = ArrayList()

        for ( c in dataset) {
            if(c.name.toLowerCase().contains(text.toLowerCase())){
                filteredContacts.add(c)
            }
        }
        dataset = filteredContacts



    }

     fun loadContacts(myDB: ContactDatabase) {
         thread {
             val list = myDB.contactDao().getAll()
             for (i in 0..(list.size - 1)) {
                 dataset.add(list[i])
             }

             onDataLoaded(dataset)
         }
    }

    fun onDataLoaded(dataset: ArrayList<Contact>) {
        runOnUiThread {
            newsRecyclerView.layoutManager = LinearLayoutManager(this)
            newsRecyclerView.adapter = ContactAdapter(this, dataset)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getParcelableExtra<Contact>("contacts")
                val myDB = ContactDatabase.getInstance(this)
                thread {
                    val list = myDB?.contactDao()?.getAll()
                    result?.id =  list!!.size + 1
                    myDB.contactDao().insert(result!!)

                    loadContacts(myDB)
                }
            }
        }
    }

}
