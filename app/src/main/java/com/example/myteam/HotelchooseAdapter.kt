package com.example.myteam

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.hotelchoose_cardview.view.*


class HotelchooseAdapter (val arrayList: ArrayList<Model_Hotelchoose>, val context: Context):
    RecyclerView.Adapter<HotelchooseAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(model: Model_Hotelchoose) {
            itemView.title_hotelchoose.text = model.title
            itemView.description_hotelchoose.text = model.descriptor
            itemView.image_hotelchoose.setImageResource(model.imageDrawable)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.hotelchoose_cardview, parent, false)
        return HotelchooseAdapter.ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
        holder.itemView.setOnClickListener {

            val model = arrayList.get(position)
            var hcTitle : String = model.title
            var hcDescription : String = model.descriptor
            var hcImageView : Int = model.imageDrawable

            val intent = Intent(context,click_hotelchoose::class.java)
            intent.putExtra("iTitle",hcTitle)
            intent.putExtra("iDescription", hcDescription)
            intent.putExtra("iImageView", hcImageView)
            context.startActivity(intent)



        }

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }


}










