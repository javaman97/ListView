package com.example.listview.activity

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.listview.R

class IceCreamInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ice_cream_info)
        val flavour=intent.getStringExtra("flavour")
        val price=intent.getStringExtra("price")
        val imgId=intent.getIntExtra("imgId",R.drawable.chocolate)
        val rating=intent.getStringExtra("rating")

        val orderButton=findViewById<Button>(R.id.btn_orderNow)
        val imageView=findViewById<ImageView>(R.id.imageView)
        val iceCreamPrice=findViewById<TextView>(R.id.txt_price)
        val iceCreamRating=findViewById<TextView>(R.id.txt_rating)
        val iceCreamFlavour=findViewById<TextView>(R.id.txt_flavour)
        iceCreamFlavour?.text=flavour
        imageView.setImageResource(imgId)
        iceCreamPrice?.text=price
        iceCreamRating?.text=rating
        orderButton.setOnClickListener {
            val dialog=Dialog(this)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.dialogbox)
            dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_dialog_box))
            val buttonCancel:Button=dialog.findViewById(R.id.btn_okay)
            buttonCancel.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }
    }
}