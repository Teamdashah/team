package com.example.myteam

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.hotel_cardview.view.*


class HotelRecycleAdapter(val arrayList: ArrayList<Model_hotel>, val context: Context) :
    RecyclerView.Adapter<HotelRecycleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(model: Model_hotel) {
            itemView.title_hotel.text = model.title
            itemView.description_hotel.text = model.descriptor
            itemView.image_hotel.setImageResource(model.imageDrawable)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.hotel_cardview, parent, false)
        return HotelRecycleAdapter.ViewHolder(v)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
        holder.itemView.setOnClickListener {

            val Model_hotel = arrayList.get(position)
            var gTitle : String = Model_hotel.title
            var gDescription :String = Model_hotel.descriptor
            var gImageView : Int = Model_hotel.imageDrawable

            val intent = Intent(context,click_main_hotel::class.java)
            intent.putExtra("iTitle",gTitle)
            intent.putExtra("iDescription",gDescription)
            intent.putExtra("iImageView",gImageView)
            context.startActivity(intent)
        }

    }

//    private fun Intent(context: Fragment_hotel, java: Class<click_main_hotel>): Intent? {
//        return Intent(context, click_main_hotel::class.java)
//    }


    override fun getItemCount(): Int {
        return arrayList.size
    }

}

//private fun Intent?.putExtra(name: String) {
//
//}
