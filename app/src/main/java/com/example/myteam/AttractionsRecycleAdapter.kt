package com.example.myteam

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.attractions_cardview.view.*

class AttractionsRecycleAdapter (val arrayList: ArrayList<Model_attractions>, val context: Context):
    RecyclerView.Adapter<AttractionsRecycleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(modelAttractions: Model_attractions){
            itemView.title_attractions.text = modelAttractions.title
            itemView.description_attractions.text = modelAttractions.descriptor
            itemView.image_attractions.setImageResource(modelAttractions.imageDrawable)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val k = LayoutInflater.from(parent.context).inflate(R.layout.attractions_cardview, parent, false)

        return AttractionsRecycleAdapter.ViewHolder(k)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
        holder.itemView.setOnClickListener {
            val modelAttractions = arrayList.get(position)
            val attTitle : String = modelAttractions.title
            val attDescription: String = modelAttractions.descriptor
            var attImageView : Int = modelAttractions.imageDrawable

            val intent = Intent(context,click_attractions::class.java)
            intent.putExtra("iTitle",attTitle)
            intent.putExtra("iDescription", attDescription)
            intent.putExtra("iImageView", attImageView)
            context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}

