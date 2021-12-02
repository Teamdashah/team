package com.example.myteam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_click_main_hotel.*
import kotlinx.android.synthetic.main.activity_click_main_hotel.hotel_address
import kotlinx.android.synthetic.main.activity_click_res.*
import kotlinx.android.synthetic.main.click_hotel.*
import kotlinx.android.synthetic.main.click_hotel.hotel_title
import kotlinx.android.synthetic.main.hotel_cardview.*

class click_main_hotel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_click_main_hotel)
        super.onCreate(savedInstanceState)

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)
        val intent: Intent = intent
        val main_hotelName = intent.getStringExtra("room_name")
        val main_hotelAddress = intent.getStringExtra("room_address")?.replace("住址：","")
        val main_hoteldetail = intent.getStringExtra("room_detail")
        val gethotelurl = intent.getStringExtra("room_photo")
        val gethotelurl_new = gethotelurl?.replaceFirst("/","https:/")
        val place = intent.getStringExtra("place")

        //標題傳過去//
//        actionBar.setTitle(main_hotelTitle)
        hotel_title.text = main_hotelName
        hotel_address.text = main_hotelAddress
        hotel_introduction.text = main_hoteldetail
        Picasso.get().load(gethotelurl_new).into(hotel_Images)

        //button
        val grbButton = findViewById<Button>(R.id.goto_res_btn)
        //handle onClick
        grbButton.setOnClickListener {
            //intent to start NewActivity
            val intent = Intent(this@click_main_hotel,restaurant_list::class.java)
            intent.putExtra("place",place)
            startActivity(intent)
        }

        val gabButton = findViewById<Button>(R.id.goto_att_btn)
        //handle onClick
        gabButton.setOnClickListener {
            //intent to start NewActivity
            val intent = Intent(this@click_main_hotel,attractions_list::class.java)
            intent.putExtra("place",place)
            startActivity(intent)
        }

    }




}

