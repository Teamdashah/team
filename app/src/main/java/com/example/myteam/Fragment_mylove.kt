package com.example.myteam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myteam.model.journeyData
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_hotel.view.*
import kotlinx.android.synthetic.main.fragment_mylove.view.*



class Fragment_mylove : Fragment() {

    private lateinit var dbref : DatabaseReference
    private lateinit var journeyList: ArrayList<journeyData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mylove, container, false)
        view.recyclerview_mylove.layoutManager = LinearLayoutManager(activity)
        view.setHasFixedSize(true)
        getjourneyData()
        journeyList = arrayListOf()
        return view
    }
    private fun getjourneyData(){
        dbref = FirebaseDatabase.getInstance().getReference("journey")
        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    for (userSnapshot in snapshot.children)
                    {
                        val journey = userSnapshot.getValue(journeyData::class.java)
                        journeyList.add(journey!!)

                    }

                    view?.recyclerview_mylove?.adapter = MyloveRecycleAdapter(journeyList,activity!!)

                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }



}