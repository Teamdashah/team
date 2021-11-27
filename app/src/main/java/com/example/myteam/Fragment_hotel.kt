package com.example.myteam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_hotel.view.*
import com.example.myteam.model.hotelFirstData
import com.google.firebase.database.*


class Fragment_hotel() : Fragment() {

    private lateinit var dbref : DatabaseReference
    private lateinit var hotelFirstList: ArrayList<hotelFirstData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_hotel, container, false)
        view.recyclerview_hotel.layoutManager = LinearLayoutManager(activity)
        view.setHasFixedSize(true)
        getFitstHotelData()
        hotelFirstList = arrayListOf<hotelFirstData>()
//        view.recyclerview_hotel.adapter = HotelRecycleAdapter(getFitstHotelData(), activity!!)
        return view



    }


    private fun getFitstHotelData(){
        dbref = FirebaseDatabase.getInstance().getReference("room/Chiayi")

        dbref.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            if(snapshot.exists())
            {
                for (userSnapshot in snapshot.children)
                {
                    val hotelFirst = userSnapshot.getValue(hotelFirstData::class.java)
                    hotelFirstList.add(hotelFirst!!)

                }

                    view?.recyclerview_hotel?.adapter = HotelRecycleAdapter(hotelFirstList,activity!!)

            }
        }

        override fun onCancelled(error: DatabaseError) {

        }
    })

    }


//    private fun getbegindate(){
//        dbref = FirebaseDatabase.getInstance().getReference("journey")
//
//        dbref.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                if(snapshot.exists())
//                {
//                    for (userSnapshot in snapshot.children)
//                    {
//                        val tripList = userSnapshot.getValue(getscheduleData::class.java)
//                        tripDetailList.add(tripList!!)
//
//                    }
//
//
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//
//            }
//        })
//
//    }

}








