package com.example.myteam

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myteam.model.restaurantData
import kotlinx.android.synthetic.main.row.view.*

class MyAdapter(val restaurantList: ArrayList<restaurantData>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = restaurantList[position]

        holder.coverUrl.text = currentitem.coverUrl
        holder.name.text = currentitem.name
        holder.avgPrice.text = currentitem.avgPrice
        holder.phone.text = currentitem.phone
        holder.address.text = currentitem.address

        holder.itemView.setOnClickListener {
            //點入餐廳，顯示詳細資訊
        }
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val coverUrl : TextView = itemView.findViewById()
        val name : TextView = itemView.findViewById()
        val avgPrice : TextView = itemView.findViewById()
        val phone : TextView = itemView.findViewById()
        val address : TextView = itemView.findViewById()
    }

}