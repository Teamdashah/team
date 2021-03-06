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
    private lateinit var place_list: String


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

            val  onethousand_down = onethousand_down.isChecked
            if(onethousand_down)
                bundle.putString("onethousand_down",""+onethousand_down)
            val  onethousand_twothousand = onethousand_twothousand.isChecked
            if(onethousand_twothousand)
                bundle.putString("onethousand_twothousand",""+onethousand_twothousand)

            val  twothousand_threethousand = twothousand_threethousand.isChecked
            if(twothousand_threethousand)
                bundle.putString("twothousand_threethousand",""+twothousand_threethousand)

            val  threethousand_fourthousand = threethousand_fourthousand.isChecked
            if(threethousand_fourthousand)
                bundle.putString("threethousand_fourthousand",""+threethousand_fourthousand)

            val  fourthousand_fivethousand = fourthousand_fivethousand.isChecked
            if(fourthousand_fivethousand)
                bundle.putString("fourthousand_fivethousand",""+fourthousand_fivethousand)
            val  fivethousand_up = fivethousand_up.isChecked
            if(fivethousand_up)
                bundle.putString("fivethousand_up",""+fivethousand_up)


            var intent = activity?.getIntent()

            val sss= intent?.getStringExtra("begin_date")
            val eee= intent?.getStringExtra("end_date")
            val ddd= intent?.getStringExtra("destination")
            val nnn= intent?.getStringExtra("number_of_people")
            val begin_date = sss
            val end_date = eee
            val destination =ddd
            val number_of_people =nnn

            when(ddd) {
                "?????????" -> place_list = "Taipei City"
                "?????????" -> place_list = "New Taipei City"
                "?????????" -> place_list = "Keelung City"
                "?????????" -> place_list = "Yilan City"
                "?????????" -> place_list = "Taoyuan City"
                "?????????" -> place_list = "Hsinchu County"
                "?????????" -> place_list = "Hsinchu City"
                "?????????" -> place_list = "Miaoli City"
                "?????????" -> place_list = "Taichung City"
                "?????????" -> place_list = "Changhua County"
                "?????????" -> place_list = "Nantou County"
                "?????????" -> place_list = "Yunlin County"
                "?????????" -> place_list = "Chiayi City"
                "?????????" -> place_list = "Chiayi County"
                "?????????" -> place_list = "Tainan City"
                "?????????" -> place_list = "Kaohsiung City"
                "?????????" -> place_list = "Pingtung City"
                "?????????" -> place_list = "Hualien County"
                "?????????" -> place_list = "Taitung County"
                "?????????" -> place_list = "Penghu County"
                "?????????" -> place_list = "Kinmen County"


                else -> place_list = "Taipei City"
            }


            bundle.putString("place_list",place_list)
            bundle.putString("begin_date",begin_date)
            bundle.putString("destination",destination)
            intent = Intent(activity, Hotelchoose_list::class.java)
            intent.putExtra("bundle",bundle)
            startActivity(intent)



            Toast.makeText(activity, "??????????????????"
                    + (if(three_star) "\n?????????" else "")
                    +(if(four_star) "\n?????????" else "")
                    + (if(five_star) "\n?????????" else "")
                    + (if(smart) "\n??????" else "")
                    + (if(environment) "\n??????" else "")
                    + (if(child) "\n??????" else "")
                    + (if(bussiness) "\n??????" else "")
                    + (if(hotspring) "\n??????" else "")
                    + (if(camp) "\n??????" else "")
                    + (if(sky) "\n??????" else "")
                    + (if(young_people) "\n??????" else "")
                    + (if(traffic) "\n????????????" else "")
                    + (if(onethousand_twothousand) "\n1000-2000" else "")
                    + (if(twothousand_threethousand) "\n2000-3000" else "")
                    + (if(threethousand_fourthousand) "\n3000-4000" else "")
                    + (if(fourthousand_fivethousand) "\n4000-5000" else "")
                    + (if(fivethousand_up) "\n5000??????" else "")
                    + (if(onethousand_down) "\n1000??????" else "")
                , Toast.LENGTH_SHORT).show()

            //???fragment?????????activity???
//            startActivity(Intent(activity, Hotelchoose_list::class.java))


        })

    }

}