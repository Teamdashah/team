package com.example.myteam

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myteam.model.hotelchooseData
import com.google.android.material.internal.ContextUtils
import com.google.android.material.internal.ContextUtils.getActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.hotelchoose_cardview.view.*


class HotelchooseAdapter (val hotelchoose_arrayList: ArrayList<hotelchooseData>, val context: Context):
    RecyclerView.Adapter<HotelchooseAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val room_name : TextView = itemView.findViewById(R.id.hotelchoose_name)
        val room_address : TextView = itemView.findViewById(R.id.hotelchoose_address)
        val room_photo : ImageView = itemView.findViewById(R.id.hotelchoose_Image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.hotelchoose_cardview, parent, false)
        return ViewHolder(v)
    }

    @SuppressLint("RestrictedApi")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentitem = hotelchoose_arrayList[position]
        val pictureurl = currentitem.room_photo
        val pictureurl_new = pictureurl?.replaceFirst("/","https:/")

        Picasso.get().load(pictureurl_new).into(holder.room_photo)
        holder.room_name.text = currentitem.room_name
        holder.room_address.text = currentitem.room_address?.replace("住址：","")


        holder.itemView.setOnClickListener {
            val pushitem = hotelchoose_arrayList.get(position)
            val chooseName : String? = pushitem.room_name
            val chooseAddress : String? = pushitem.room_address
            val choosePictureUrl : String? = pushitem.room_photo
            val chooseIntroduction : String? = pushitem.room_detail
            val intent = Intent(getActivity(context), click_hotelchoose::class.java)
            intent.putExtra("room_name",chooseName)
            intent.putExtra("room_address",chooseAddress)
            intent.putExtra("room_photo",choosePictureUrl)
            intent.putExtra("room_detail",chooseIntroduction)

            context.startActivity(intent)


        }

    }

    override fun getItemCount(): Int {
        return hotelchoose_arrayList.size
    }


}










