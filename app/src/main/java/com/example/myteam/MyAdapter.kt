package com.example.myteam

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*

class MyAdapter(val arrayList: ArrayList<Model>, val context: Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(model: Model) {
            itemView.title_restaurant.text = model.title
            itemView.description_restaurant01.text = model.des01
            itemView.description_restaurant02.text = model.des02
            itemView.description_restaurant03.text = model.des03
            itemView.image_restaurant.setImageResource(model.imageDrawable)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

        holder.itemView.setOnClickListener {

            val model = arrayList.get(position)
            var gTitle : String = model.title
            var gDescription01 :String = model.des01
            var gDescription02 :String = model.des02
            var gDescription03 :String = model.des03
            var gImageView : Int = model.imageDrawable

            val intent = Intent(context, click_res::class.java)

            intent.putExtra("iTitle", gTitle)
            intent.putExtra("iDescription01", gDescription01)
            intent.putExtra("iDescription02", gDescription02)
            intent.putExtra("iDescription03", gDescription03)
            intent.putExtra("iImageView", gImageView)

            context.startActivity(intent)
        }
    }



    override fun getItemCount(): Int {
        return arrayList.size
    }

}