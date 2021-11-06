package com.example.myteam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_attractions_list.*

class attractions_list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attractions_list)

        val arrayList = ArrayList<Model_attractions>()

        arrayList.add(Model_attractions("1", "attraction_list", R.drawable.main_foot))
        arrayList.add(Model_attractions("2", "222", R.drawable.main_foot))
        arrayList.add(Model_attractions("3", "33", R.drawable.main_foot))
        arrayList.add(Model_attractions("4", "44", R.drawable.main_foot))
        arrayList.add(Model_attractions("5", "serfs", R.drawable.main_foot))
        arrayList.add(Model_attractions("6", "vgyrc", R.drawable.main_foot))
        arrayList.add(Model_attractions("7", "mkifv", R.drawable.main_foot))
        arrayList.add(Model_attractions("8", "wdfth", R.drawable.main_foot))
        arrayList.add(Model_attractions("9", "bte", R.drawable.main_foot))
        arrayList.add(Model_attractions("10", "njuy", R.drawable.main_foot))
        arrayList.add(Model_attractions("11", "xsrfv", R.drawable.main_foot))

        val myAdapter = AttractionsRecycleAdapter(arrayList, this)

        attractions_recyclerview.layoutManager = LinearLayoutManager(this)
        attractions_recyclerview.adapter = myAdapter
    }
}