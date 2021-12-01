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

import android.app.Activity
import android.content.Intent
import android.content.Intent.getIntent
import androidx.navigation.fragment.FragmentNavigator
import kotlinx.android.synthetic.main.fragment_hotel.*
import org.jetbrains.anko.support.v4.intentFor
import android.content.Intent.getIntent





class Fragment_hotel() : Fragment() {

    private lateinit var dbref : DatabaseReference
    private lateinit var hotelFirstList: ArrayList<hotelFirstData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?



    ): View? {

        val view = inflater.inflate(R.layout.fragment_hotel, container, false)
        view.recyclerview_hotel.layoutManager = LinearLayoutManager(activity)
        view.setHasFixedSize(true)
//        val bundle = arguments
//        if(bundle != null){
//            val dest = bundle.getString("destination")
//            if (dest != null) {
//
//            }
//        }
        getFitstHotelData()
        hotelFirstList = arrayListOf<hotelFirstData>()
//        view.recyclerview_hotel.adapter = HotelRecycleAdapter(getFitstHotelData(), activity!!)
        return view



    }


    private fun getFitstHotelData(){
        //有改
        val intent = activity?.getIntent()
        val sss= intent?.getStringExtra("begin_date")
        val eee= intent?.getStringExtra("end_date")
        val ddd= intent?.getStringExtra("destination")
        val nnn= intent?.getStringExtra("number_of_people")

        val begin_date = sss
        val end_date = eee
        val destination =ddd
        val number_of_people =nnn
        //有改
        when(destination) {
            "台北市" -> dbref = FirebaseDatabase.getInstance().getReference("room/Taipei")
            "新北市" -> dbref = FirebaseDatabase.getInstance().getReference("room/New Taipei")
            "基隆市" -> dbref = FirebaseDatabase.getInstance().getReference("room/Keelung")
            "宜蘭市" -> dbref = FirebaseDatabase.getInstance().getReference("room/Yilan")
            "桃園市" -> dbref = FirebaseDatabase.getInstance().getReference("room/Taoyuan")
            "新竹縣" -> dbref = FirebaseDatabase.getInstance().getReference("room/Hsinchu")
            "新竹市" -> dbref = FirebaseDatabase.getInstance().getReference("room/Hsinchu")
            "苗栗縣" -> dbref = FirebaseDatabase.getInstance().getReference("room/Miaoli")
            "台中市" -> dbref = FirebaseDatabase.getInstance().getReference("room/Taichung")
            "彰化縣" -> dbref = FirebaseDatabase.getInstance().getReference("room/Changhua")
            "南投縣" -> dbref = FirebaseDatabase.getInstance().getReference("room/Nantou")
            "雲林縣" -> dbref = FirebaseDatabase.getInstance().getReference("room/Yunlin")
            "嘉義市" -> dbref = FirebaseDatabase.getInstance().getReference("room/Chiayi")
            "嘉義縣" -> dbref = FirebaseDatabase.getInstance().getReference("room/Chiayi")
            "台南市" -> dbref = FirebaseDatabase.getInstance().getReference("room/Tainan")
            "高雄市" -> dbref = FirebaseDatabase.getInstance().getReference("room/Kaohsiung")
            "屏東市" -> dbref = FirebaseDatabase.getInstance().getReference("room/Pingtung")
            "花蓮縣" -> dbref = FirebaseDatabase.getInstance().getReference("room/Hualien")
            "台東縣" -> dbref = FirebaseDatabase.getInstance().getReference("room/Taitung")
            "澎湖縣" -> dbref = FirebaseDatabase.getInstance().getReference("room/Penghu")
            "金門縣" -> dbref = FirebaseDatabase.getInstance().getReference("room/Kinmen")
            "小琉球" -> dbref = FirebaseDatabase.getInstance().getReference("room/Liuqiu")
            "綠島" -> dbref = FirebaseDatabase.getInstance().getReference("room/Lyudao")
            "連江縣(馬祖)" -> dbref = FirebaseDatabase.getInstance().getReference("room/Mazu")


            else -> dbref = FirebaseDatabase.getInstance().getReference("room/Chiayi")
        }
//        if(destination == "台北市"){
//            dbref = FirebaseDatabase.getInstance().getReference("room/Taipei")
//        }
//        else{
//            dbref = FirebaseDatabase.getInstance().getReference("room/Chiayi")
//        }


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








