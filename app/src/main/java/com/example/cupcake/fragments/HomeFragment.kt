package com.example.cupcake.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.fragment.app.FragmentTransaction
import com.example.cupcake.R
import com.example.cupcake.data.Repository
import com.example.cupcake.databinding.FragmentHomeBinding
import com.example.cupcake.model.Model
import com.example.cupcake.ui.MainActivity
import com.razerdp.widget.animatedpieview.AnimatedPieView
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig
import com.razerdp.widget.animatedpieview.data.SimplePieInfo


class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)
    @SuppressLint("UseRequireInsteadOfGet")

    override fun setUpViews() {
        // Open search fragment when you click on ImageButton in frontend
        binding.btnToSearch.setOnClickListener {
            val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.fragment_container, SearchFragment()).commit()

            val adapter = ModelAdapter(Repository.countryList) // list of cities to adapter
            binding.recycleMain.adapter = adapter

        }
    }
    override fun addCallBack() {
        getCitiesInfo()
        pieChart()


    }

//call function to get Info from Csv file
    private fun getCitiesInfo(){
        (activity as MainActivity).parseFile()
//        bindCountryMax(Repository.getMaxCity())
//        bindCountryMin(Repository.getMinCity())
    }

// Send Info. of MinCity to frontend
//    fun bindCountryMax(country: Model){
//        binding?.apply {
//            countryMax!!.text = ("${country.city}, ${country.country}")
//            populationMax!!.text = ("${country.population} M")
//            longitudeMaxNum!!.text = country.lon.toString()
//            LatitudeMaxNum!!.text = country.lat.toString()
//        }
//    }
//
//// Send Info. of MinCity to frontend
//    fun bindCountryMin(country: Model){
//        binding?.apply {
//            countryMin!!.text = ("${country.city}, ${country.country}")
//            populationMin!!.text = ("${country.population} M")
//            longitudeMinNum!!.text = country.lon.toString()
//            LatitudeMinNum!!.text = country.lat.toString()
//
//        }
//    }

// Display PieChart
    fun pieChart() {
        val mAnimatedPieView: AnimatedPieView? = binding.PieChart
        val config = AnimatedPieViewConfig()
        config.startAngle(-90f)
            .addData(SimplePieInfo(30.0, Color.parseColor("#386CBA"), "Baghdad"))
            .addData(SimplePieInfo(18.0, Color.parseColor("#FFEECA"), "London"))
            .addData(SimplePieInfo(10.0, Color.parseColor("#A6ABBD"), "Paris"))
            .addData(SimplePieInfo(20.0, Color.parseColor("#B44760"), "Dubai"))
            .addData(SimplePieInfo(10.0, Color.parseColor("#F07C92"), "Cairo"))
            .drawText(true).textSize(30.0F).duration(2000)
        mAnimatedPieView?.applyConfig(config)
        mAnimatedPieView?.start()
    }
}