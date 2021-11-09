package com.example.myteam

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.auth.AuthUI.getApplicationContext
import kotlinx.android.synthetic.main.fragment_hotel.view.*
import android.content.Intent
import android.os.Parcelable
import androidx.recyclerview.widget.RecyclerView


class Fragment_hotel() : Fragment() {


    @SuppressLint("UseRequireInsteadOfGet", "RestrictedApi")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_hotel, container, false)

        view.recyclerview_hotel.layoutManager = LinearLayoutManager(activity)
        view.recyclerview_hotel.adapter = HotelRecycleAdapter(arr(), activity!!)
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

    private fun arr(): ArrayList<Model_hotel> {
        val arrayList = ArrayList<Model_hotel>()

        arrayList.add(Model_hotel("1", "mainhotel", R.drawable.main_foot))
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







