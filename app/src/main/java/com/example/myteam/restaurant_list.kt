package com.example.myteam

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myteam.model.restaurantData
import com.google.firebase.database.*

const val TAG = "restaurant_list"

class restaurant_list : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var restaurantList: ArrayList<restaurantData>
    private lateinit var place:String
    private lateinit var node:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_list)

        place = intent.getStringExtra("place").toString()
        node = intent.getStringExtra("node").toString()

        userRecyclerView = findViewById(R.id.recyclerview)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)


        restaurantList = arrayListOf<restaurantData>()
        getRestaurantData()

    }

    private fun getRestaurantData()
    {
        dbref = FirebaseDatabase.getInstance().getReference("food").child(place)


        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    for (userSnapshot in snapshot.children)
                    {
                        val restaurant = userSnapshot.getValue(restaurantData::class.java)
                        restaurantList.add(restaurant!!)

                    }

                    userRecyclerView.adapter = MyAdapter(restaurantList,this@restaurant_list,node)

                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}