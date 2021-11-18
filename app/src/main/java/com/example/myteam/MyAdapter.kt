package com.example.myteam

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myteam.model.restaurantData
import com.squareup.picasso.Picasso

class MyAdapter(val restaurantList: ArrayList<restaurantData>, val context:Context) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = restaurantList[position]

        val url = currentitem.coverUrl

        Picasso.get().load(url).into(holder.imageView)

        holder.name.text = currentitem.name
        holder.avgPrice.text = currentitem.avgPrice.toString()
        holder.phone.text = currentitem.phone
        holder.address.text = currentitem.address

        holder.itemView.setOnClickListener {
            //點開餐廳，看詳細資訊
            val pushresitem = restaurantList.get(position)
            val resName : String? = pushresitem.name
            val resavgPrice : String? = pushresitem.avgPrice.toString()
            val resAddress : String? = pushresitem.address
            val resPhone : String? = pushresitem.phone
            var rescoverUrl : String? = pushresitem.coverUrl
            val intent = Intent(context,click_res::class.java)
            intent.putExtra("name",resName)
            intent.putExtra("avgPrice",resavgPrice)
            intent.putExtra("address",resAddress)
            intent.putExtra("phone",resPhone)
            intent.putExtra("coverUrl",rescoverUrl)
            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val imageView : ImageView = itemView.findViewById(R.id.resImage)
        val name : TextView = itemView.findViewById(R.id.title_restaurant)
        val avgPrice : TextView = itemView.findViewById(R.id.description_restaurant01)
        val phone : TextView = itemView.findViewById(R.id.description_restaurant02)
        val address : TextView = itemView.findViewById(R.id.description_restaurant03)
    }
}