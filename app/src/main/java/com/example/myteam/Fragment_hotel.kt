package com.example.myteam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_hotel.view.*


class Fragment_hotel() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_hotel, container, false)
        view.recyclerview_hotel.layoutManager = LinearLayoutManager(activity)
        view.recyclerview_hotel.adapter = HotelRecycleAdapter(arr(),this)
        return view

    }


    private fun arr(): ArrayList<Model_hotel> {
        val arrayList = ArrayList<Model_hotel>()

        arrayList.add(Model_hotel("1", "11", R.drawable.main_foot))
        arrayList.add(Model_hotel("2", "222", R.drawable.main_foot))
        arrayList.add(Model_hotel("3", "33", R.drawable.main_foot))
        arrayList.add(Model_hotel("4", "44", R.drawable.main_foot))
        arrayList.add(Model_hotel("5", "serfs", R.drawable.main_foot))
        arrayList.add(Model_hotel("6", "vgyrc", R.drawable.main_foot))
        arrayList.add(Model_hotel("7", "mkifv", R.drawable.main_foot))
        arrayList.add(Model_hotel("8", "wdfth", R.drawable.main_foot))
        arrayList.add(Model_hotel("9", "bte", R.drawable.main_foot))
        arrayList.add(Model_hotel("10", "njuy", R.drawable.main_foot))
        arrayList.add(Model_hotel("11", "xsrfv", R.drawable.main_foot))
        return arrayList
    }
}







