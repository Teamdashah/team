package com.example.myteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.ActionBar
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_click_hotelchoose.*
import kotlinx.android.synthetic.main.activity_click_main_hotel.*
import kotlinx.android.synthetic.main.click_hotel.*
import kotlinx.android.synthetic.main.click_hotel.hotel_title

class click_hotelchoose : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_hotelchoose)

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        val intent: Intent = intent
        val c_hotelName = intent.getStringExtra("room_name")
        val c_hotelAddress = intent.getStringExtra("room_address")?.replace("住址：","")
        val c_hoteldetail = intent.getStringExtra("room_detail")
        val gethotelurl = intent.getStringExtra("room_photo")
        val gethotelurl_new = gethotelurl?.replaceFirst("/","https:/")

        choose_name.text = c_hotelName
        choose_address.text = c_hotelAddress
        choose_introduction.text = c_hoteldetail
        Picasso.get().load(gethotelurl_new).into(choose_image)



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

