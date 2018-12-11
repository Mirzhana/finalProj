package mirzhana.com.afinal.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable

@Entity(tableName = "contactGroup")

data class ContactGroup(
        @PrimaryKey var id: String,
        var groupname: String,
        var priority: String) : Parcelable {

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(groupname)
        parcel.writeString(priority)

    }


    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString())



    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ContactGroup> {
        override fun createFromParcel(parcel: Parcel): ContactGroup {
            return ContactGroup(parcel)
        }

        override fun newArray(size: Int): Array<ContactGroup?> {
            return arrayOfNulls(size)
        }
    }
}