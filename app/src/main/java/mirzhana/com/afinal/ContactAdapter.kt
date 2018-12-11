package mirzhana.com.afinal

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*
import java.util.ArrayList
import mirzhana.com.afinal.model.Contact

class ContactAdapter(var context: Context, var dataset: ArrayList<Contact>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return ContactViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))

    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var contact = dataset[position]
        holder.itemView.nameText.text = contact.name
        holder.itemView.mobileText.text = contact.mobile


    }
    inner class ContactViewHolder(view: View): RecyclerView.ViewHolder(view){
        init {

            view.card.setOnClickListener{
                context.startActivity(Intent(context, ContactActivity::class.java).putExtra("contact",dataset[adapterPosition]))
            }
        }

    }

     public fun filterList(filteredNames: ArrayList<Contact>){
        this.dataset = filteredNames
        notifyDataSetChanged()

    }
}