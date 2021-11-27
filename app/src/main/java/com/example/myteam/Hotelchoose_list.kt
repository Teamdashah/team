package com.example.myteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myteam.model.attractionData
import com.example.myteam.model.hotelchooseData
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_hotelchoose_list.*


class Hotelchoose_list : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var hcRecyclerView: RecyclerView
    private lateinit var hotelchoose_list: ArrayList<hotelchooseData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotelchoose_list)

        hcRecyclerView = findViewById(R.id.hotelchoose_recycleview)
        hcRecyclerView.layoutManager = LinearLayoutManager(this)
        hcRecyclerView.setHasFixedSize(true)


        hotelchoose_list = arrayListOf<hotelchooseData>()
        val getfour_star = intent.getBundleExtra("bundle")?.getString("four_star").toString()
        getchooseData(getfour_star)



//
//        val arrayList = ArrayList<Model_Hotelchoose>()
//        arrayList.add(Model_Hotelchoose("1"+getstring, "hotelchoose_list", R.drawable.main_foot))
//        arrayList.add(Model_Hotelchoose("2", "222", R.drawable.main_foot))
//        arrayList.add(Model_Hotelchoose("3", "33", R.drawable.main_foot))
//        arrayList.add(Model_Hotelchoose("4", "44", R.drawable.main_foot))
//        arrayList.add(Model_Hotelchoose("5", "se rfs", R.drawable.main_foot))
//        arrayList.add(Model_Hotelchoose("6", "vgyrc", R.drawable.main_foot))
//        arrayList.add(Model_Hotelchoose("7", "mkifv", R.drawable.main_foot))
//        arrayList.add(Model_Hotelchoose("8", "wdfth", R.drawable.main_foot))
//        arrayList.add(Model_Hotelchoose("9", "bte", R.drawable.main_foot))
//        arrayList.add(Model_Hotelchoose("10", "njuy", R.drawable.main_foot))
//        arrayList.add(Model_Hotelchoose("11", "xsrfv", R.drawable.main_foot))
//
//        val hotelchooseadapter = HotelchooseAdapter(arrayList, this)
//        hotelchoose_recycleview.layoutManager = LinearLayoutManager(this)
//        hotelchoose_recycleview.adapter = hotelchooseadapter
    }

    private fun getchooseData(getfour_star:String)
    {
        if(getfour_star == "true"){
            dbref = FirebaseDatabase.getInstance().getReference("room/Taipei")
        }
        else
            dbref = FirebaseDatabase.getInstance().getReference("room/Kaohsiung")

        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    for (userSnapshot in snapshot.children)
                    {
                        val hotelchoose = userSnapshot.getValue(hotelchooseData::class.java)
                        hotelchoose_list.add(hotelchoose!!)

                        Log.d(TAG,"test*****************")
                    }

                    hcRecyclerView.adapter = HotelchooseAdapter(hotelchoose_list,this@Hotelchoose_list)

                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }



}




