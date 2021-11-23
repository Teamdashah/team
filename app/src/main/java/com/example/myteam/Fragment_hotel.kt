package com.example.myteam

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_hotel.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.myteam.model.hotelFirstData
import com.example.myteam.model.restaurantData
import com.google.firebase.database.*


class Fragment_hotel() : Fragment() {

    private lateinit var dbref : DatabaseReference
    private lateinit var hotelFirstList: ArrayList<hotelFirstData>


    @SuppressLint("UseRequireInsteadOfGet", "RestrictedApi")
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





//    fun onListItemClick(list: ListView, v: View?, position: Int, id: Long) {
//        val mediaStreamIntent = Intent(activity, MediaStreamPlayer::class.java)
//        mediaStreamIntent.putExtra("sermon_details", list.getItemAtPosition(position) as Parcelable)
//        startActivity(mediaStreamIntent)
//    }
//open fun onClick(v: View) {
//    when (v.id) {
//        R.id.my_button ->
//
//            requireActivity().supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.fragment_container, Fragment_hotel(), null)
//                .addToBackStack(null)
//                .commit()
//        R.id.my_return -> requireActivity().supportFragmentManager.popBackStack()
//        R.id.my_other -> {
//            val intent = Intent(activity, click_main_hotel::class.java)
//            startActivity(intent)
//        }
//    }
//}

//    view.recyclerview_hotel.adapter = HotelRecycleAdapter(arr(),context)
//    fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
//        super.onViewCreated(requireView(), savedInstanceState)
//        recyclerview_hotel.setAdapter(HotelRecycleAdapter)
//        recyclerview_hotel.setHasFixedSize(true)
//        recyclerview_hotel.setLayoutManager(LinearLayoutManager(activity))
//        recyclerview_hotel.setItemAnimator(DefaultItemAnimator())
//
//        //Cannot resolve method
//        HotelRecycleAdapter.SetItemClickListener(object : OnItemClickListener() {
//            fun onItemClick(v: View, position: Int) {
//                val detailIntent = Intent(v.context, DetailActivity::class.java)
//                //Cannot resolve method
//                StartActivity(detailIntent)
//            }
//        })
//    }
    private fun getFitstHotelData(){
    dbref = FirebaseDatabase.getInstance().getReference("room/Kaohsiung")

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

}

private fun View.setHasFixedSize(b: Boolean) {

}







