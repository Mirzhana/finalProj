package mirzhana.com.afinal

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import mirzhana.com.afinal.model.Contact

@Dao

interface ContactDAO{
    @Query("Select * FROM contacts")
    fun getAll():List<Contact>
    @Insert
    fun insert(news:Contact)

}
