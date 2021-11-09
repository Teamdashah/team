package com.example.myteam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_restaurant_list.*

class restaurant_list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_list)

        val arrayList = ArrayList<Model>()

        arrayList.add(Model("1", "11", R.drawable.main_foot))
        arrayList.add(Model("2", "222", R.drawable.main_foot))
        arrayList.add(Model("3", "33", R.drawable.main_foot))
        arrayList.add(Model("4", "44", R.drawable.main_foot))
        arrayList.add(Model("5", "se rfs", R.drawable.main_foot))
        arrayList.add(Model("6", "vgyrc", R.drawable.main_foot))
        arrayList.add(Model("7", "mkifv", R.drawable.main_foot))
        arrayList.add(Model("8", "wdfth", R.drawable.main_foot))
        arrayList.add(Model("9", "bte", R.drawable.main_foot))
        arrayList.add(Model("10", "njuy", R.drawable.main_foot))
        arrayList.add(Model("11", "xsrfv", R.drawable.main_foot))

        val myAdapter = MyAdapter(arrayList, this)

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = myAdapter
    }
}