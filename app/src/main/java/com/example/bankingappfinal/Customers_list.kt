package com.example.bankingappfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bankingapp.RecyclerAdapter
import com.example.bankingappfinal.databinding.ActivityCustomersListBinding
import java.text.FieldPosition

class Customers_list : AppCompatActivity() {

    //implementing our recycler view
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    //implementing view binding
    private lateinit var binding: ActivityCustomersListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomersListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //creating arrays to store values of customers and their details
        var title = arrayOf("Prashant Sah", "Mikhail Lukianov", "Sam Sah", "Bipin Yadav", "Bikram Sah", "Raj Sah", "Abijit Singh", "Mohan sah", "Pranish Shrestha", "Chong Lama")
        //var details = arrayOf("User one details", "User two details", "User three details", "User four details", "User five details", "User six details", "User seven details", "User eight details", "User nine details", "User ten details")
        //var details = mapOf<Int, Double>(101 to 5000.00, 102 to 5000.00, 103 to 5000.00, 104 to 5000.00, 105 to 5000.00, 106 to 5000.00, 107 to 5000.00, 108 to 5000.00, 109 to 5000.00, 110 to 5000.00)
       //var details = arrayOf("Ac No: 101 Blc: $5000", "Ac No: 102 Blc: $5000", "Ac No: 103 Blc: $6000", "Ac No: 104 Blc: $5000","Ac No: 105 Blc: $5200", "Ac No: 106 Blc: $9800", "Ac No: 107 Blc: $10000", "Ac No: 108 Blc: $7500", "Ac No: 109 Blc: $5500", "Ac No: 101 Blc: $6200")
        var blc = arrayOf("5000", "5000", "5000", "5000","5000", "6000", "6000", "6000", "6000", "6000")
        var images = intArrayOf(R.drawable.img, R.drawable.img, R.drawable.img, R.drawable.img, R.drawable.img, R.drawable.img, R.drawable.img, R.drawable.img, R.drawable.img, R.drawable.img)


        //initializing layout manager object
        layoutManager = LinearLayoutManager(this)
        //accessing the id from activity_main.xml file
        binding.recyclerView.layoutManager = layoutManager
        var adapter = RecyclerAdapter()
        binding.recyclerView.adapter = adapter

        //setting onclick event
        adapter.setOnItemClickListener(object : RecyclerAdapter.onItemClickListner{
            override fun onItemClick(position: Int) {
                //Toast.makeText(this@Customers_list, "You clicked on item no. $position", Toast.LENGTH_SHORT).show()

                //using intent to send data to User Info activity
                val i = Intent(this@Customers_list, UserInfo::class.java)
                i.putExtra("Name", title[position])
                i.putExtra("blc", blc[position])
                i.putExtra("images", images[position])
                startActivity(i)
            }

        })

    }
}