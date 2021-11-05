package com.example.myteam

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_click_attractions.*

class click_attractions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_attractions)

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        var intent = intent
        val bTitle = intent.getStringExtra("iTitle")
        val bDescription = intent.getStringExtra("iDescription")
        val bImageView = intent.getIntExtra("iImageView",0)

        actionBar.setTitle(bTitle)
        click_attractions_title.text = bTitle
        click_attractions_description.text = bDescription
        click_attractions_imageView.setImageResource(bImageView)
    }
}