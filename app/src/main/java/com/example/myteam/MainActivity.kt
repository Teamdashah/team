package com.example.myteam

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize
        val mButton = findViewById<Button>(R.id.login_btn)
        //handle onClick
        mButton.setOnClickListener {
            //intent to start NewActivity
            startActivity(Intent(this@MainActivity, login::class.java))
        }
        val rButton = findViewById<Button>(R.id.register_btn)
        //handle onClick
        rButton.setOnClickListener {
            //intent to start NewActivity
            startActivity(Intent(this@MainActivity, register::class.java))
        }

    }


}
