package com.example.myteam

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myteam.model.myscheduleData
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import okhttp3.internal.notify
import okhttp3.internal.notifyAll


class myscheduleAdapter(val myscheduleList: ArrayList<myscheduleData>, val context: Context) :
RecyclerView.Adapter<myscheduleAdapter.ViewHolder>(){

    private lateinit var dbref : DatabaseReference

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val destination : TextView = itemView.findViewById(R.id.tripname)
        val begin_date : TextView = itemView.findViewById(R.id.my_begindate)
        val end_date : TextView = itemView.findViewById(R.id.my_enddate)

        val trashCan : ImageButton = itemView.findViewById(R.id.delete_mylove)
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

        holder.trashCan.setOnClickListener{
            deleteItem(position)
        }
    }

    override fun getItemCount(): Int {
        return myscheduleList.size
    }

    fun deleteItem(index: Int){


        //val leaf:String= myscheduleList[index].begin_date.toString()+myscheduleList[index].destination
        //dbref = FirebaseDatabase.getInstance().getReference("journey").child(leaf)
        //dbref.removeValue()

        myscheduleList.removeAt(index)

        notifyDataSetChanged()
    }
}

