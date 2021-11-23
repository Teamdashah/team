package com.example.myteam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myteam.model.journeyData


class MyloveRecycleAdapter(val journeyarrayList: ArrayList<journeyData>, val context: Context) :
    RecyclerView.Adapter<MyloveRecycleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val myjourney : TextView = itemView.findViewById(R.id.title_mylove)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.mylove_cardview, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pushitem = journeyarrayList[position]
        holder.myjourney.text = pushitem.journey

        holder.itemView.setOnClickListener {

        }

    }


    override fun getItemCount(): Int {
        return journeyarrayList.size
    }

}

