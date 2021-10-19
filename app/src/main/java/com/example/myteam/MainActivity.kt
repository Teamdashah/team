package com.example.myteam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.android.gms.tasks.OnCompleteListener


class MainActivity : AppCompatActivity() {

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var firebaseAuth: FirebaseAuth

    //constants
    val TAG="GOOGLE_SIGN_IN_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //configure the Google SignIn
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        //init firebase auth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        //Google SignIn Button, Click to begin Google SignIn
        val gButton = findViewById<Button>(R.id.googleSignInBtn)
        gButton.setOnClickListener{
            Log.d(TAG,"onCreate: begin Google SignIn")
            val intern = googleSignInClient.signInIntent
            startActivityForResult(intent, RC_SIGN_IN)
        }

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

    }
    private fun checkUser(){

    }


}
