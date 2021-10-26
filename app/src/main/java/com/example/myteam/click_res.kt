package com.example.myteam

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class click_res : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_res)

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        var intent = intent
        val aTitle = intent.getStringExtra("iTitle")
        val aDescription = intent.getStringExtra("iDescription")
        val aImageView = intent.getStringExtra("iImageView")

        actionBar.setTitle(aTitle)
//        a_title.text = aTitle
//        a_description.text = aDescription
//        imageView.setImageResource(aImageView)

        //返回到restaurant_list
        supportActionBar!!.title="BehKhiSng"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }
}