package mirzhana.com.afinal

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_contact.*
import mirzhana.com.afinal.model.Contact

class AddContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        addBtn.setOnClickListener{
            val name = nameEditText.text.toString()
            val mobile = mobileEditText.text.toString()
            val home = homeEditText.text.toString()
            val work = workEditText.text.toString()
            val group = groupEditText.text.toString()
            val contact = Contact(0, name, mobile, home,work, group)

            setResult(Activity.RESULT_OK, Intent().
                    putExtra("contacts", contact))
           // startActivityForResult(Intent(this, MainActivity::class.java), 1)
            finish()
        }


    }
}
