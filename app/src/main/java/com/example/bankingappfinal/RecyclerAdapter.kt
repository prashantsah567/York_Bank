package com.example.bankingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bankingappfinal.R

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    //handling click event
    private lateinit var mListener: onItemClickListner

    interface onItemClickListner{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listner: onItemClickListner){
        mListener = listner
    }

    //creating arrays to store values of customers and their details
    private var title = arrayOf("Prashant Sah", "Mikhail Lukianov", "Sam Sah", "Bipin Yadav", "Bikram Sah", "Raj Sah", "Abijit Singh", "Mohan sah", "Pranish Shrestha", "Chong Lama")
   // private var details = arrayOf("User one details", "User two details", "User three details", "User four details", "User five details", "User six details", "User seven details", "User eight details", "User nine details", "User ten details")

    private var details = arrayOf("Ac No: 101  Blc: $", "Ac No: 102  Blc: $", "Ac No: 103  Blc: $", "Ac No: 104  Blc: $","Ac No: 105  Blc: $", "Ac No: 106  Blc: $", "Ac No: 107  Blc: $", "Ac No: 108  Blc: $", "Ac No: 109  Blc: $", "Ac No: 101  Blc: $")
    var blc = arrayOf("5000", "5000", "5000", "5000","5000", "6000", "6000", "6000", "6000", "6000")
    private var images = intArrayOf(R.drawable.img, R.drawable.img, R.drawable.img, R.drawable.img, R.drawable.img, R.drawable.img, R.drawable.img, R.drawable.img, R.drawable.img, R.drawable.img)

    //inflating our card layout and passing the view object to this constructor
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v, mListener)
    }
    //function to populate data to card view
    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = title[position]
        holder.itemDetail.text = details[position]
        holder.blc.text = blc[position]
        holder.itemImage.setImageResource(images[position])
    }
    //count the number of title views
    override fun getItemCount(): Int {
        return title.size
    }

    inner class ViewHolder(itemView: View, listner: onItemClickListner): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        var blc: TextView

        init{
            //initializing our variable with the views created in card layout file
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_tile)
            itemDetail = itemView.findViewById(R.id.item_detail)
            blc = itemView.findViewById(R.id.blc)

            //for handling click event
            itemView.setOnClickListener{
                listner.onItemClick(adapterPosition)
            }
        }
    }
}