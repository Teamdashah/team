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
            val destination : String? = pushitem.destination
            val begin_date : String? = pushitem.begin_date
            val end_date : String? = pushitem.end_date
            val intent = Intent(context,hotel_main::class.java)
            intent.putExtra("destination",destination)
            intent.putExtra("begin_date",begin_date)
            intent.putExtra("end_date",end_date)
            context.startActivity(intent)


        }

    }

    override fun getItemCount(): Int {
        return myscheduleList.size
    }



        fun deleteItem (index: Int) {
            myscheduleList.removeAt(index)
            notifyDataSetChanged()
        }

}



