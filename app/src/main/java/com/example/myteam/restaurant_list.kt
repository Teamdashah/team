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

        arrayList.add(Model("測試早午餐", "平均價格 : 101111","電話 : 07-123456799","地址 : 高雄市楠梓區高雄大學路700號" , R.drawable.main_foot))
        arrayList.add(Model("小蘇早午餐", "平均價格 : 300","電話 : 07-1234567","地址 : 我家" , R.drawable.main_foot))
        arrayList.add(Model("4", "平均價格 : 100","電話 : 07-1234567","地址 : 高雄市楠梓區高雄大學路700號" , R.drawable.main_foot))
        arrayList.add(Model("5", "平均價格 : 100","電話 : 07-1234567","地址 : 高雄市楠梓區高雄大學路700號" , R.drawable.main_foot))
        arrayList.add(Model("6", "平均價格 : 100","電話 : 07-1234567","地址 : 高雄市楠梓區高雄大學路700號" , R.drawable.main_foot))
        arrayList.add(Model("7", "平均價格 : 100","電話 : 07-1234567","地址 : 高雄市楠梓區高雄大學路700號" , R.drawable.main_foot))
        arrayList.add(Model("8", "平均價格 : 100","電話 : 07-1234567","地址 : 高雄市楠梓區高雄大學路700號" , R.drawable.main_foot))
        arrayList.add(Model("9", "平均價格 : 100","電話 : 07-1234567","地址 : 高雄市楠梓區高雄大學路700號" , R.drawable.main_foot))
        arrayList.add(Model("10", "平均價格 : 100","電話 : 07-1234567","地址 : 高雄市楠梓區高雄大學路700號" , R.drawable.main_foot))
        arrayList.add(Model("11", "平均價格 : 100","電話 : 07-1234567","地址 : 高雄市楠梓區高雄大學路700號" , R.drawable.main_foot))

        val myAdapter = MyAdapter(arrayList, this)

        restaurant_recyclerview.layoutManager = LinearLayoutManager(this)
        restaurant_recyclerview.adapter = myAdapter
    }
}