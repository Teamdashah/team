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
            val  three_star = three_star.isChecked
            if(three_star)
                bundle.putString("three_star",""+three_star)

            val  four_star = four_star.isChecked
            if(four_star)
                bundle.putString("four_star",""+four_star)

            val  five_star = five_star.isChecked
            if(five_star)
                bundle.putString("five_star",""+five_star)

            val  hotspring = hotspring.isChecked
            if(hotspring)
                bundle.putString("hotspring",""+hotspring)

            val  traffic = traffic.isChecked
            if(traffic)
                bundle.putString("traffic",""+traffic)

            val  child = child.isChecked
            if(child)
                bundle.putString("child",""+child)

            val  smart = smart.isChecked
            if(smart)
                bundle.putString("smart",""+smart)

            val  environment = environment.isChecked
            if(environment)
                bundle.putString("environment",""+environment)

            val  bussiness = bussiness.isChecked
            if(bussiness)
                bundle.putString("bussiness",""+bussiness)

            val  camp = camp.isChecked
            if(camp)
                bundle.putString("camp",""+camp)

            val  young_people = young_people.isChecked
            if(young_people)
                bundle.putString("young_people",""+young_people)

            val  sky = sky.isChecked
            if(sky)
                bundle.putString("sky",""+sky)


            val  onethousand_twothousand = onethousand_twothousand.isChecked
            val  twothousand_threethousand = twothousand_threethousand.isChecked
            val  threethousand_fourthousand = threethousand_fourthousand.isChecked
            val  fourthousand_fivethousand = fourthousand_fivethousand.isChecked

            var intent = activity?.getIntent()

            val sss= intent?.getStringExtra("begin_date")
            val eee= intent?.getStringExtra("end_date")
            val ddd= intent?.getStringExtra("destination")
            val nnn= intent?.getStringExtra("number_of_people")
            val begin_date = sss
            val end_date = eee
            val destination =ddd
            val number_of_people =nnn
            bundle.putString("destination",""+destination)
            intent = Intent(activity, Hotelchoose_list::class.java)
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