package mirzhana.com.afinal

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import mirzhana.com.afinal.model.Contact

@Database(entities = arrayOf(Contact::class), version = 1)
abstract class ContactDatabase: RoomDatabase(){

    abstract fun contactDao(): ContactDAO

    companion object {
        private var INSTANCE: ContactDatabase? = null

        fun getInstance(context: Context): ContactDatabase? {
            if (INSTANCE == null) {
                synchronized(ContactDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, ContactDatabase::class.java, "contacts.db").build()
                }
            }

            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}