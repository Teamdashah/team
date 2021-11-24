package com.example.myteam


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myteam.model.journeyData
import com.google.android.material.internal.ContextUtils
import com.google.android.material.internal.ContextUtils.getActivity


class MyloveRecycleAdapter(val journeyarrayList: ArrayList<journeyData>, val context: Context) :
    RecyclerView.Adapter<MyloveRecycleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val destination : TextView = itemView.findViewById(R.id.title_mylove)
        val begin_date : TextView = itemView.findViewById(R.id.begindate_mylove)
        val end_date : TextView = itemView.findViewById(R.id.enddate_mylove)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.mylove_cardview, parent, false)

        return ViewHolder(v)
    }

    @SuppressLint("RestrictedApi")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pushitem = journeyarrayList[position]
        holder.destination.text = pushitem.destination
        holder.begin_date.text = pushitem.begin_date
        holder.end_date.text = pushitem.end_date


        holder.itemView.setOnClickListener {
            val intent = Intent(getActivity(context), click_mylove::class.java)
            context.startActivity(intent)
        }

    }



    override fun getItemCount(): Int {
        return journeyarrayList.size
    }

}

