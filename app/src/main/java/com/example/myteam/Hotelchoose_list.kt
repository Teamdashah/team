package com.example.myteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_hotelchoose_list.*


class Hotelchoose_list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotelchoose_list)


        var getstring = intent.getBundleExtra("bundle")?.getString("four_star")

        val arrayList = ArrayList<Model_Hotelchoose>()
        arrayList.add(Model_Hotelchoose("1"+getstring, "hotelchoose_list", R.drawable.main_foot))
        arrayList.add(Model_Hotelchoose("2", "222", R.drawable.main_foot))
        arrayList.add(Model_Hotelchoose("3", "33", R.drawable.main_foot))
        arrayList.add(Model_Hotelchoose("4", "44", R.drawable.main_foot))
        arrayList.add(Model_Hotelchoose("5", "se rfs", R.drawable.main_foot))
        arrayList.add(Model_Hotelchoose("6", "vgyrc", R.drawable.main_foot))
        arrayList.add(Model_Hotelchoose("7", "mkifv", R.drawable.main_foot))
        arrayList.add(Model_Hotelchoose("8", "wdfth", R.drawable.main_foot))
        arrayList.add(Model_Hotelchoose("9", "bte", R.drawable.main_foot))
        arrayList.add(Model_Hotelchoose("10", "njuy", R.drawable.main_foot))
        arrayList.add(Model_Hotelchoose("11", "xsrfv", R.drawable.main_foot))

        val hotelchooseadapter = HotelchooseAdapter(arrayList, this)
        hotelchoose_recycleview.layoutManager = LinearLayoutManager(this)
        hotelchoose_recycleview.adapter = hotelchooseadapter
    }
}


