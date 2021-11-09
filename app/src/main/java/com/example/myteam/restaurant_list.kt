package com.example.myteam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myteam.model.restaurantData
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_restaurant_list.*

class restaurant_list : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var restaurantList: ArrayList<restaurantData>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_list)

        userRecyclerView = findViewById(R.id.recyclerview)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)

        restaurantList = arrayListOf<restaurantData>()
        getRestaurantData()
    }

    private fun getRestaurantData(){
        dbref = FirebaseDatabase.getInstance().getReference("food").child("Taipei CIty")

        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot)
            {
                if(snapshot.exists()) {
                    for (userSnapshot in snapshot.children) {
                        val user = userSnapshot.getValue(restaurantData::class.java)
                        restaurantList.add(user!!)
                    }

                    userRecyclerView.adapter = MyAdapter(restaurantList)
                }
            }

            override fun onCancelled(error: DatabaseError)
            {}
        })
    }
}