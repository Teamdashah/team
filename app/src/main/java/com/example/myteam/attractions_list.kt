package com.example.myteam

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myteam.model.attractionData
import com.google.firebase.database.*

class attractions_list : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var attRecyclerView: RecyclerView
    private lateinit var attractionList: ArrayList<attractionData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attractions_list)

        attRecyclerView = findViewById(R.id.attraction_recyclerview)
        attRecyclerView.layoutManager = LinearLayoutManager(this)
        attRecyclerView.setHasFixedSize(true)


        attractionList = arrayListOf<attractionData>()
        getAttractionData()


    }
    //拿資料庫資料
    private fun getAttractionData()
    {
        dbref = FirebaseDatabase.getInstance().getReference("attractions_new/Central")

        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    for (userSnapshot in snapshot.children)
                    {
                        val attraction = userSnapshot.getValue(attractionData::class.java)
                        attractionList.add(attraction!!)

                        Log.d(TAG,"test*****************")
                    }

                    attRecyclerView.adapter = AttractionsRecycleAdapter(attractionList,this@attractions_list)

                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}



