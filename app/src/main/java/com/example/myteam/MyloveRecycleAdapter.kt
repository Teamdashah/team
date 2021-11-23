package com.example.myteam

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myteam.model.journeyData
import com.example.myteam.model.restaurantData
import com.squareup.picasso.Picasso

class MyloveRecycleAdapter(val journeyList: ArrayList<journeyData>, val context:Context) :
    RecyclerView.Adapter<MyloveRecycleAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = journeyList[position]

        holder.begin_date.text = currentitem.begin_date
        holder.end_date.text = currentitem.end_date
        holder.destination.text = currentitem.destiantion


        holder.itemView.setOnClickListener {
            //點開行程，看詳細資訊

        }
    }

    override fun getItemCount(): Int {
        return journeyList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val begin_date : TextView = itemView.findViewById(R.id.journey_go)
        val end_date : TextView = itemView.findViewById(R.id.journey_end)
        val destination : TextView = itemView.findViewById(R.id.journey_place)
    }
}