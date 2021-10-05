package com.example.myteam

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lButton = findViewById<Button>(R.id.login_btn)
        //handle onClick
        lButton.setOnClickListener {
            //intent to start NewActivity
            startActivity(Intent(this@MainActivity, login::class.java))
        }

        val rButton = findViewById<Button>(R.id.register_btn)
        //handle onClick
        rButton.setOnClickListener {
            //intent to start NewActivity
            startActivity(Intent(this@MainActivity, register::class.java))
        }


//        mAuth = FirebaseAuth.getInstance()
//        val user = mAuth.currentUser
//        if(user != null)
//        {
//            val inputIntent = Intent(this, input::class.java)
//            startActivity(inputIntent)
//        }
//        else
//        {
//            val signInIntent = Intent(this, googleSignIn::class.java)
//            startActivity(signInIntent)
//        }
//
//
    }


}
