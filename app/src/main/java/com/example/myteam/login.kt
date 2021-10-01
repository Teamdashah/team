package com.example.myteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class login : AppCompatActivity() {

    private lateinit var accountEditText: EditText
    private lateinit var passwordEditText: EditText
    private  lateinit var loginButton: Button
    private  lateinit var forgetPasswordButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        accountEditText = findViewById<EditText>(R.id.editTextTextEmailAddress)
        passwordEditText = findViewById<EditText>(R.id.editTextTextPassword)
        loginButton = findViewById(R.id.button)
        forgetPasswordButton = findViewById(R.id.button2)
    }
}



