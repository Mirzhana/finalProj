package mirzhana.com.afinal

import android.app.LauncherActivity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import mirzhana.com.afinal.model.Contact
import kotlinx.android.synthetic.main.activity_contact.*

class ContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        val item = intent.getParcelableExtra<Contact>("contact")
        nameText.text= item.name
        mobileText.text = item.mobile
        homeText.text = item.home
        workText.text = item.work

    }
}
