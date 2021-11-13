package com.example.myteam

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.click_hotel.*

class click_main_hotel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_click_main_hotel)
        super.onCreate(savedInstanceState)

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)
        val intent: Intent = intent
        val main_hotelTitle = intent.getStringExtra("iTitle")
        val main_hotelDescription = intent.getStringExtra("iDescription")
        val main_hotelImageView = intent.getIntExtra("iImageView",0)

        //標題傳過去//
        actionBar.setTitle(main_hotelTitle)
        hotel_title.text = main_hotelTitle
        hotel_description.text = main_hotelDescription
        hotel_imageView.setImageResource(main_hotelImageView)



    }




}

