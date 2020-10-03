package mirzhana.com.afinal

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_contact.*
import mirzhana.com.afinal.model.Contact

class AddContactActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        addBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.addBtn -> onAddButtonClicked()
        }
    }

    private fun onAddButtonClicked() {
        val name = nameEditText.text.toString()
        val mobile = mobileEditText.text.toString()
        val home = homeEditText.text.toString()
        val work = workEditText.text.toString()
        val group = groupEditText.text.toString()
        val contact = Contact(0, name, mobile, home,work, group)

        setResult(
                Activity.RESULT_OK,
                Intent().putExtra("contacts", contact)
        )
        finish()
    }
}
