package com.example.cupcake.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.cupcake.R
import com.example.cupcake.data.Repository
import com.example.cupcake.databinding.FragmentCityDetailsBinding
import com.example.cupcake.databinding.FragmentHomeBinding
import com.example.cupcake.model.Model
import com.example.cupcake.ui.HomeActivity
import com.example.cupcake.util.CsvParser
import com.github.mikephil.charting.charts.Chart
import com.razerdp.widget.animatedpieview.AnimatedPieView
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig
import com.razerdp.widget.animatedpieview.data.SimplePieInfo
import java.io.BufferedReader
import java.io.InputStreamReader


class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    var searchFragment = SearchFragment()
    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)
    @SuppressLint("UseRequireInsteadOfGet")
    override fun setUpViews() {
        binding.btnToSearch.setOnClickListener {
            val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.fragment_container, searchFragment).commit()
        }
    }
    override fun addCallBack() {
        getCitiesInfo()
    }

    private fun getCitiesInfo(){
        (activity as HomeActivity).parseFile()
        bindCountryMax(Repository.getMaxCity())
        bindCountryMin(Repository.getMinCity())
    }

    fun bindCountryMax(country: Model){
        binding?.apply {
            countryMax!!.text = ("${country.city}, ${country.country}")
            populationMax!!.text = ("${country.population} M")
            longitudeMaxNum!!.text = country.lon.toString()
            LatitudeMaxNum!!.text = country.lat.toString()

        }
    }
    fun bindCountryMin(country: Model){
        binding?.apply {
            countryMin!!.text = ("${country.city}, ${country.country}")
            populationMin!!.text = ("${country.population} M")
            longitudeMinNum!!.text = country.lon.toString()
            LatitudeMinNum!!.text = country.lat.toString()

        }
    }
    fun PieChart() {
        val mAnimatedPieView: AnimatedPieView? = view?.findViewById(binding.PieChart.id)
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