package com.example.myteam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myteam.R
import kotlinx.android.synthetic.main.fragment_mylove.view.*



class Fragment_mylove : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mylove, container, false)
        view.recyclerview_mylove.layoutManager = LinearLayoutManager(activity)
        view.recyclerview_mylove.adapter = MyloveRecycleAdapter(arr(),this)
        return view
    }

    private fun arr(): ArrayList<Model_mylove> {
        val arrayList = ArrayList<Model_mylove>()

        arrayList.add(Model_mylove("1", "11", R.drawable.main_foot))
        arrayList.add(Model_mylove("2", "222", R.drawable.main_foot))
        arrayList.add(Model_mylove("3", "33", R.drawable.main_foot))
        arrayList.add(Model_mylove("4", "44", R.drawable.main_foot))
        arrayList.add(Model_mylove("5", "serfs", R.drawable.main_foot))
        arrayList.add(Model_mylove("6", "vgyrc", R.drawable.main_foot))
        arrayList.add(Model_mylove("7", "mkifv", R.drawable.main_foot))
        arrayList.add(Model_mylove("8", "wdfth", R.drawable.main_foot))
        arrayList.add(Model_mylove("9", "bte", R.drawable.main_foot))
        arrayList.add(Model_mylove("10", "njuy", R.drawable.main_foot))
        arrayList.add(Model_mylove("11", "xsrfv", R.drawable.main_foot))
        return arrayList
    }

}