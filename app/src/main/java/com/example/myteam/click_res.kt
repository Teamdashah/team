package com.example.myteam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_click_res.*

class click_res : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_res)

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        var intent = intent
        val aTitle = intent.getStringExtra("resName")
        val rDescription01 = intent.getStringExtra("resPrice")
        val rDescription02 = intent.getStringExtra("resAddress")
        val rDescription03 = intent.getStringExtra("resPhone")
//        val aImageView = intent.getIntExtra("iImageView",0)



        actionBar.setTitle(aTitle)
        restaurant_title.text = aTitle
        restaurant_description01.text = rDescription01
        restaurant_description02.text = rDescription02
        restaurant_description03.text = rDescription03
//        restaurant_imageView.setImageResource(aImageView)


    }
}