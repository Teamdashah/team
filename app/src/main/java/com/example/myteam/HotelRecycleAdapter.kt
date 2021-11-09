package com.example.myteam

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.internal.ContextUtils.getActivity
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
        return ViewHolder(v)


    }

    @SuppressLint("RestrictedApi")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
        holder.itemView.setOnClickListener {
//            if (position==0){
//                Toast.makeText(
//                    context,
//                    "You click",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//            if (position==2){
//                Toast.makeText(
//                    context,
//                    "You click2",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
            val model = arrayList.get(position)
            var mhTitle : String = model.title
            var mhDescription : String = model.descriptor
            var mhImageView : Int = model.imageDrawable
            val intent = Intent(context, click_main_hotel::class.java)
            intent.putExtra("iTitle",mhTitle)
            intent.putExtra("iDescription", mhDescription)
            intent.putExtra("iImageView", mhImageView)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent)

        }

    }

//    private fun Intent(context: Fragment_hotel, java: Class<click_main_hotel>): Intent? {
//        return Intent(
//            context,
//            click_main_hotel::class.java
//        )
//
//    }

//    open fun onClick(v: View) {
//    when (v.id) {
//        R.id.my_button ->
//
//            requireActivity().supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.fragment_container, Fragment_hotel(), null)
//                .addToBackStack(null)
//                .commit()
//        R.id.my_return -> requireActivity().supportFragmentManager.popBackStack()
//        R.id.my_other -> {
//            val intent = Intent(activity, click_main_hotel::class.java)
//            startActivity(intent)
//        }
//    }
//}

    override fun getItemCount(): Int {
        return arrayList.size
    }

}
