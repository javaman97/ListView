package com.example.listview.activity

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.listview.data.IceCream
import com.example.listview.R
import com.example.listview.adapter.MyAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var iceCreamArrayList: ArrayList<IceCream>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title="ICECREAM"
        supportActionBar?.show()
        val iceCreamFlavour = arrayOf("Chocolate","Vanilla","Mango","ButterScotch","Strawberry")
        val  iceCreamPrice= arrayOf("$8","$5","$7","$8","$6")
        val iceCreamRating = arrayOf("5.0","4.8","4.9","4.6","4.7")
        val imgId = intArrayOf(
            R.drawable.chocolate, R.drawable.vanilla, R.drawable.mango, R.drawable.butterscotch,
            R.drawable.strawberry
        )
        iceCreamArrayList=ArrayList()
        for(eachIndex in iceCreamFlavour.indices){
            val iceCream=
                IceCream(iceCreamFlavour[eachIndex],iceCreamPrice[eachIndex],iceCreamRating[eachIndex],
                imgId[eachIndex])

            iceCreamArrayList.add(iceCream)
        }
        val listView=findViewById<ListView>(R.id.listView)
        listView.isClickable=true
        listView.adapter= MyAdapter(this,iceCreamArrayList)

      listView.setOnItemClickListener { parent, view, position, id ->

       val Flavour=iceCreamFlavour[position]
          val Rating=iceCreamRating[position]
          val Price=iceCreamPrice[position]
          val ImgId=imgId[position]

          val i= Intent(this, IceCreamInfoActivity::class.java)
           i.putExtra("flavour",Flavour)
          i.putExtra("price",Price)
          i.putExtra("rating",Rating)
          i.putExtra("imgId",ImgId)
          startActivity(i)
      }
    }
}