package com.example.myteam

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myteam.model.myscheduleData


class myscheduleAdapter(val myscheduleList: ArrayList<myscheduleData>, val context: Context) :
RecyclerView.Adapter<myscheduleAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val destination : TextView = itemView.findViewById(R.id.tripname)
        val begin_date : TextView = itemView.findViewById(R.id.my_begindate)
        val end_date : TextView = itemView.findViewById(R.id.my_enddate)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.myschedule_cardview, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentitem = myscheduleList[position]
        holder.destination.text = currentitem.destination
        holder.begin_date.text = currentitem.begin_date
        holder.end_date.text = currentitem.end_date

        holder.itemView.setOnClickListener {
            val pushitem = myscheduleList.get(position)
            val intent = Intent(context,hotel_main::class.java)
            context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return myscheduleList.size
    }




}

