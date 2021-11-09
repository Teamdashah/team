package com.example.myteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_click_hotelchoose.*

class click_hotelchoose : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_hotelchoose)

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        val intent = intent
        val hotelc_Title = intent.getStringExtra("iTitle")
        val hotelc_Description = intent.getStringExtra("iDescription")
        val hotelc_ImageView = intent.getIntExtra("iImageView",0)

        actionBar.setTitle(hotelc_Title)
        hotelchoose_title.text = hotelc_Title
        hotelchoose_description.text = hotelc_Description
        hotelchoose_imageView.setImageResource(hotelc_ImageView)


        val ToresButton = findViewById<Button>(R.id.to_res_btn)
        //handle onClick
        ToresButton.setOnClickListener {
            //intent to start NewActivity
            startActivity(Intent(this@click_hotelchoose, restaurant_list::class.java))
        }


        val ToattButton = findViewById<Button>(R.id.to_attractions_btn)
        //handle onClick
        ToattButton.setOnClickListener {
            //intent to start NewActivity
            startActivity(Intent(this@click_hotelchoose, attractions_list::class.java))
        }
    }


}

