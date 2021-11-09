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

        //holder.coverUrl.text = currentitem.coverUrl
        /*holder.name.text = currentitem.name
        holder.avgPrice.text = currentitem.avgPrice
        holder.phone.text = currentitem.phone
        holder.address.text = currentitem.address*/

        holder.itemView.setOnClickListener {

            //點開餐廳，看詳細資訊
        }
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        //val coverUrl : TextView = itemView.findViewById(R.id.image_restaurant)
        val name : TextView = itemView.findViewById(R.id.title_restaurant)
        val avgPrice : TextView = itemView.findViewById(R.id.description_restaurant01)
        val phone : TextView = itemView.findViewById(R.id.description_restaurant02)
        val address : TextView = itemView.findViewById(R.id.description_restaurant03)
    }
}