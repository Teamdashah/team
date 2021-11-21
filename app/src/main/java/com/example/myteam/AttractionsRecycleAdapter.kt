package com.example.myteam

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myteam.model.attractionData
import com.squareup.picasso.Picasso


class AttractionsRecycleAdapter (val attractionList: ArrayList<attractionData>,val context:Context):
    RecyclerView.Adapter<AttractionsRecycleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.findViewById(R.id.attraction_title)
        val address : TextView = itemView.findViewById(R.id.attraction_address)
        val phone : TextView = itemView.findViewById(R.id.attraction_phone)
        val introduction : TextView = itemView.findViewById(R.id.attraction_introduction)
        val imageView : ImageView = itemView.findViewById(R.id.image_attraction)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val k = LayoutInflater.from(parent.context).inflate(R.layout.attractions_cardview, parent, false)

        return ViewHolder(k)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentAttitem = attractionList[position]
        val attpicurl = currentAttitem.pictureUrl
        Picasso.get().load(attpicurl).into(holder.imageView)

        holder.name.text = currentAttitem.name
        holder.address.text = currentAttitem.address
        holder.phone.text = currentAttitem.phone
//        下面那行馬掉後，在attraction_list中不顯示簡介
//        holder.introduction.text = currentAttitem.introduction

        holder.itemView.setOnClickListener {
            //點開景點看詳細資訊

            val pushitem = attractionList.get(position)
            val attName : String? = pushitem.name
            val attAddress : String? = pushitem.address
            val attPhone : String? = pushitem.phone
            val attIntroduction : String? = pushitem.introduction
            val attpictureUrl : String? = pushitem.pictureUrl
            val intent = Intent(context,click_attractions::class.java)
            intent.putExtra("name",attName)
            intent.putExtra("address",attAddress)
            intent.putExtra("phone",attPhone)
            intent.putExtra("introduction",attIntroduction)
            intent.putExtra("pictureUrl",attpictureUrl)
            context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return attractionList.size
    }
}

