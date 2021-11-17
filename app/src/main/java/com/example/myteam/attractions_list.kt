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



        /* val arrayList = ArrayList<Model_attractions>()
         arrayList.add(Model_attractions("1", "11", R.drawable.main_foot))
         arrayList.add(Model_attractions("2", "222", R.drawable.main_foot))
         arrayList.add(Model_attractions("3", "33", R.drawable.main_foot))
         arrayList.add(Model_attractions("4", "44", R.drawable.main_foot))
         arrayList.add(Model_attractions("5", "serfs", R.drawable.main_foot))
         arrayList.add(Model_attractions("6", "vgyrc", R.drawable.main_foot))
         arrayList.add(Model_attractions("7", "mkifv", R.drawable.main_foot))
         arrayList.add(Model_attractions("8", "wdfth", R.drawable.main_foot))
         arrayList.add(Model_attractions("9", "bte", R.drawable.main_foot))
         arrayList.add(Model_attractions("10", "njuy", R.drawable.main_foot))
         arrayList.add(Model_attractions("11", "xsrfv", R.drawable.main_foot))
         val attractionsrecycleAdapter = AttractionsRecycleAdapter(arrayList, this)
         attraction_recyclerview.layoutManager = LinearLayoutManager(this)
         attraction_recyclerview.adapter = attractionsrecycleAdapter*/
    }
    private fun getAttractionData()
    {
        dbref = FirebaseDatabase.getInstance().getReference("attractions/Central")

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



