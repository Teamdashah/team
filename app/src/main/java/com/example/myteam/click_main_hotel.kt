package com.example.myteam

import android.content.Intent
import android.os.Bundle
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
        val main_hotelAddress = intent.getStringExtra("room_address")
        val gethotelurl = intent.getStringExtra("room_photo")
        val gethotelurl_new = gethotelurl?.replaceFirst("/","https:/")
//        val main_hotelImageView = intent.getIntExtra("iImageView",0)

        //標題傳過去//
//        actionBar.setTitle(main_hotelTitle)
        hotel_title.text = main_hotelName
        hotel_address.text = main_hotelAddress
        Picasso.get().load(gethotelurl_new).into(hotel_Images)
//        hotel_imageView.setImageResource(main_hotelImageView)



    }




}

