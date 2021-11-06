package com.example.myteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_click_attractions.*
import kotlinx.android.synthetic.main.activity_click_hotelchoose.*

class click_attractions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_attractions)

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        val intent =intent
        val att_Title = intent.getStringExtra("iTitle")
        val att_Description = intent.getStringExtra("iDescription")
        val att_ImageView = intent.getIntExtra("iImageView",0)

        actionBar.setTitle(att_Title)
        attrctions_title.text = att_Title
        attrctions_description.text = att_Description
        attrctions_imageView.setImageResource(att_ImageView)
    }
}


