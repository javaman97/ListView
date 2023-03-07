package com.example.listview.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.listview.data.IceCream
import com.example.listview.R
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter (val context:Activity,val arrayList:ArrayList<IceCream>):ArrayAdapter<IceCream>(context,
    R.layout.eachitem,arrayList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater=LayoutInflater.from(context)
        val view=inflater.inflate(R.layout.eachitem,null)

        val image= view.findViewById<CircleImageView>(R.id.img_iceCream)
        val iceCreamFlavour= view.findViewById<TextView>(R.id.txt_iceCream_flavour)
        val iceCreamRating= view.findViewById<TextView>(R.id.txt_rating)
        val iceCreamPrice= view.findViewById<TextView>(R.id.txt_price)

        iceCreamFlavour?.text=arrayList[position].icecreamFlavour
        iceCreamRating?.text=arrayList[position].icecreamRating
        iceCreamPrice?.text=arrayList[position].icecreamPrice
        image.setImageResource(arrayList[position].iceCreamImageId)
        return view
    }
}