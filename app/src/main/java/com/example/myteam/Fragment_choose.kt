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
import kotlinx.android.synthetic.main.fragment_choose.*


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
            var bundle = Bundle()
            if(four_star.isChecked)
                bundle.putString("four_star","four_star")
            val  four_star = four_star.isChecked
            val  traffic = traffic.isChecked
            val  five_star = five_star.isChecked
            val  hotspring = hotspring.isChecked
            val  child = child.isChecked
            val  smart = smart.isChecked
            val  environment = environment.isChecked
            val  bussiness = bussiness.isChecked
            val  camp = camp.isChecked
            val  three_star = three_star.isChecked
            val  young_people = young_people.isChecked
            val  sky = sky.isChecked


            val  onethousand_twothousand = onethousand_twothousand.isChecked
            val  twothousand_threethousand = twothousand_threethousand.isChecked
            val  threethousand_fourthousand = threethousand_fourthousand.isChecked
            val  fourthousand_fivethousand = fourthousand_fivethousand.isChecked

            var intent = Intent(activity, Hotelchoose_list::class.java)
            intent.putExtra("bundle",bundle)
            startActivity(intent)

            Toast.makeText(activity, "您的篩選結果"
                    + (if(three_star) "\n三星級" else "")
                    +(if(four_star) "\n四星級" else "")
                    + (if(five_star) "\n五星級" else "")
                    + (if(smart) "\n智能" else "")
                    + (if(environment) "\n環保" else "")
                    + (if(child) "\n親子" else "")
                    + (if(bussiness) "\n商務" else "")
                    + (if(hotspring) "\n溫泉" else "")
                    + (if(camp) "\n露營" else "")
                    + (if(sky) "\n星空" else "")
                    + (if(young_people) "\n青旅" else "")
                    + (if(traffic) "\n交通便利" else "")
                    + (if(onethousand_twothousand) "\n1000-2000" else "")
                    + (if(twothousand_threethousand) "\n2000-3000" else "")
                    + (if(threethousand_fourthousand) "\n3000-4000" else "")
                    + (if(fourthousand_fivethousand) "\n4000-5000" else "")
                , Toast.LENGTH_SHORT).show()

            //從fragment跳轉到activity中
//            startActivity(Intent(activity, Hotelchoose_list::class.java))


        })

    }

}