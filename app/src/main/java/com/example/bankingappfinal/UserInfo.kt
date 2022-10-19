package com.example.bankingappfinal

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.bankingappfinal.databinding.ActivityUserInfoBinding

class UserInfo : AppCompatActivity() {
    private lateinit var binding: ActivityUserInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setting UI component to variable
        val userName : TextView = binding.userName
        val imageView : ImageView = binding.imageView2
        val userBlc : TextView = binding.currentAmt

        //getting the data from customer list view using extra
        val bundle : Bundle? = intent.extras
        val name = bundle!!.getString("Name")
        val image = bundle.getInt("images")
        val blc = bundle.getString("blc")

        //assigning value from extras to out declared variable
        userName.text = name
        imageView.setImageResource(image)
        userBlc.text = blc

    }
    //when transfer button is clicked from User Info
    @SuppressLint("SetTextI18n")
    fun showAlert(view: View) {
        //inflating the dialog with custom view
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.transfer_dialog, null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("Receiver Info")
        //to show dialog
        val mAlertDialog = mBuilder.show()

        //accessing the view elements of dialog box
        val send = mDialogView.findViewById<Button>(R.id.btnSend)
        val cancel = mDialogView.findViewById<Button>(R.id.btnCancel)
        val name = mDialogView.findViewById<TextView>(R.id.receiverName).text.toString()
        val ac = mDialogView.findViewById<TextView>(R.id.receiverAcNo).text.toString()
        val amt = mDialogView.findViewById<TextView>(R.id.amtSending).text

        //when send btn is clicked
        send.setOnClickListener{
            mAlertDialog.dismiss()
            //showing the transfered amt
            binding.amtTransfer.text = "New balance transfer $amt"
            //reducing the transfer amount from current balance
            val enteredAmt = amt.toString().toDouble()
            val oldAmt = binding.currentAmt.text.toString().toDouble()
            val newAmt = (oldAmt-enteredAmt)
            val newAmtValue = newAmt.toString()
            binding.currentAmt.text = newAmtValue
        }
        //when cancel btn is clicked
        cancel.setOnClickListener{
            mAlertDialog.dismiss()
        }

    }
}
