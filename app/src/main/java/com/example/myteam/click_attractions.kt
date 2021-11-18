package com.example.myteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_click_attractions.*



class click_attractions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_attractions)

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        val intent =intent
        val att_Name = intent.getStringExtra("name")
        val att_Address = intent.getStringExtra("address")
        val att_Phone = intent.getStringExtra("phone")
        val att_Introduction = intent.getStringExtra("introduction")


//        actionBar.setTitle(att_Title)
        attrction_detail_name.text = att_Name
        attrction_detail_address.text = att_Address
        attrction_detail_phone.text = att_Phone
        attrction_detail_introducton.text= att_Introduction
    }
}


