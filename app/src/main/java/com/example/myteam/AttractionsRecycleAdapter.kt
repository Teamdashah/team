package com.example.myteam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myteam.model.attractionData
import kotlinx.android.synthetic.main.attractions_cardview.view.*


class AttractionsRecycleAdapter (val attractionList: ArrayList<attractionData>):
    RecyclerView.Adapter<AttractionsRecycleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.findViewById(R.id.attraction_title)
        val address : TextView = itemView.findViewById(R.id.attraction_address)
        val phone : TextView = itemView.findViewById(R.id.attraction_phone)
        val introduction : TextView = itemView.findViewById(R.id.attraction_introduction)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val k = LayoutInflater.from(parent.context).inflate(R.layout.attractions_cardview, parent, false)

        return ViewHolder(k)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentAttitem = attractionList[position]
        holder.name.text = currentAttitem.name
        holder.address.text = currentAttitem.address
        holder.phone.text = currentAttitem.phone
        holder.introduction.text = currentAttitem.introduction
        holder.itemView.setOnClickListener {
//            val modelAttractions = arrayList.get(position)
//            val attTitle : String = modelAttractions.name
//            val attDescription: String = modelAttractions.address
//           /* var attImageView : Int = modelAttractions.imageDrawable*/
//
//            val intent = Intent(context,click_attractions::class.java)
//            intent.putExtra("iTitle",attTitle)
//            intent.putExtra("iDescription", attDescription)
//            /*intent.putExtra("iImageView", attImageView)*/
//            context.startActivity(intent)


        }

    }

    override fun getItemCount(): Int {
        return attractionList.size
    }
}

