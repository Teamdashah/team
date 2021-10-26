package com.example.myteam


import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.*

class input_schedule : AppCompatActivity() {

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var firebaseAuth: FirebaseAuth

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_schedule)

        //init firebase auth
        firebaseAuth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)


        //handle click, logout user, go back to login page
        val logoutButton = findViewById<Button>(R.id.logoutBtn)
        logoutButton.setOnClickListener{
            firebaseAuth.signOut()
            googleSignInClient.signOut()
            startActivity(Intent(this@input_schedule, MainActivity::class.java))
        }

        //input month and day
        val c =Calendar.getInstance()
        val year =c.get(Calendar.YEAR)
        val month =c.get(Calendar.MONTH)
        val day =c.get(Calendar.DAY_OF_MONTH)

        val Pickbegin_Button = findViewById<Button>(R.id.pickBeginDateBtn)
        //handle onClick
        Pickbegin_Button.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view: DatePicker?, mYear: Int, mMonth: Int, mDay: Int ->
                val textView = findViewById<TextView>(R.id.showBeginDate)
                textView.setText("" + mDay + "/" + mMonth + "/" + mYear)
            },year,month,day)

            dpd.show()
        }

        val Pickend_Button = findViewById<Button>(R.id.pickEndDateBtn)
        Pickend_Button.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view: DatePicker?, mYear: Int, mMonth: Int, mDay: Int ->
                val textView = findViewById<TextView>(R.id.showEndDate)
                textView.setText("" + mDay + "/" + mMonth + "/" + mYear)
            },year,month,day)

            dpd.show()
        }
        val SButton = findViewById<Button>(R.id.submitmytrip)
        //handle onClick
        SButton.setOnClickListener {
            //intent to start NewActivity
            startActivity(Intent(this@input_schedule, hotel_list::class.java))
        }
    }


}
