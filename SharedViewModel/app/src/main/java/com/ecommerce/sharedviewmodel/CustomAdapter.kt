package com.ecommerce.sharedviewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mList: MutableList<PhoneModel>,private val clickListener: ClickListener) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.phone_number.text = ItemsViewModel.phone.toString()
        holder.first_name.text = ItemsViewModel.firstname
        holder.last_name.text = ItemsViewModel.lastname
        holder.email.text = ItemsViewModel.email
        holder.delete.setOnClickListener {
            mList.removeAt(position)
            notifyDataSetChanged()
        }
        holder.update.setOnClickListener {
            clickListener.onClickItem(position, true)
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val phone_number: TextView = itemView.findViewById(R.id.phone_number)
        val last_name: TextView = itemView.findViewById(R.id.last_name)
        val first_name: TextView = itemView.findViewById(R.id.first_name)
        val email: TextView = itemView.findViewById(R.id.email)
        val update: Button = itemView.findViewById(R.id.update);
        val delete: Button = itemView.findViewById(R.id.delete);
    }
}