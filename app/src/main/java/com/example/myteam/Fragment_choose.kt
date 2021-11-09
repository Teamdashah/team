package com.example.myteam

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.database.annotations.Nullable


class Fragment_choose : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose, container, false)
    }


    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val sweepButton: Button = requireActivity().findViewById<View>(R.id.hotel_result_btn) as Button
        sweepButton.setOnClickListener(View.OnClickListener {
            Toast.makeText(activity, "您的篩選結果", Toast.LENGTH_SHORT).show()
            //從fragment跳轉到activity中
            startActivity(Intent(activity, Hotelchoose_list::class.java))
        })
    }
}