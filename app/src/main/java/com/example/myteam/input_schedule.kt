package com.example.myteam


import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class input_schedule : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_schedule)

        val c =Calendar.getInstance()
        val year =c.get(Calendar.YEAR)
        val month =c.get(Calendar.MONTH)
        val day =c.get(Calendar.DAY_OF_MONTH)

        val Pick_Button = findViewById<Button>(R.id.pickDateBtn)
        //handle onClick
        Pick_Button.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view: DatePicker?, mYear: Int, mMonth: Int, mDay: Int ->
                val textView = findViewById<TextView>(R.id.showdate)
                textView.setText("" + mDay + "/" + mMonth + "/" + mYear)
            },year,month,day)

            dpd.show()
        }

    }
}
