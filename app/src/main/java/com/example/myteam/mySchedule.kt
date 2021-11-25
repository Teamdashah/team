package com.example.myteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toolbar
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myteam.model.attractionData
import com.example.myteam.model.myscheduleData
import com.getbase.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.*
import android.content.Intent
import android.view.View


class mySchedule : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var myList: ArrayList<myscheduleData>
    private lateinit var floatingbtn : com.google.android.material.floatingactionbutton.FloatingActionButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_schedule)

        myRecyclerView = findViewById(R.id.recyclerview_myschedule)
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myRecyclerView.setHasFixedSize(true)
        myList = arrayListOf<myscheduleData>()
        getmyscheduleData()
        floatingbtn = findViewById(R.id.floatingActionButton)
        floatingbtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                //here
                startActivity(Intent(this@mySchedule, input_schedule::class.java))
            }
        })
        ///隱藏floating_btn
        /*myRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                // if the recycler view is scrolled
                // above hide the FAB
                if (dy > myRecyclerView.size && floatingbtn.isShown) {
                    floatingbtn.hide()
                }

                // if the recycler view is
                // scrolled above show the FAB
                if (dy < myRecyclerView.size && !floatingbtn.isShown) {
                    floatingbtn.show()
                }

            }
        })*/
        ///
    }


    private fun getmyscheduleData()
    {
        dbref = FirebaseDatabase.getInstance().getReference("journey")

        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    for (userSnapshot in snapshot.children)
                    {
                        val myschedule = userSnapshot.getValue(myscheduleData::class.java)
                        myList.add(myschedule!!)

                        Log.d(TAG,"test*****************")
                    }

                    myRecyclerView.adapter = myscheduleAdapter(myList,this@mySchedule)

                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}