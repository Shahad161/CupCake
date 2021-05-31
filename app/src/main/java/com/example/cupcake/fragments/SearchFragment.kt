package com.example.cupcake.fragments

import android.graphics.Color
import android.widget.Toast
import com.example.cupcake.data.Repository
import com.example.cupcake.databinding.FragmentSearchBinding
import com.example.cupcake.model.Model
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate

class SearchFragment: BaseFragment<FragmentSearchBinding>() {

    lateinit var barData: BarData
    lateinit var barDataSet: BarDataSet
    lateinit var barList: ArrayList<BarEntry>
    lateinit var county: ArrayList<String>
    private var _cityList: MutableList<Model> = mutableListOf<Model>()
    private var _cityListItem = arrayListOf<String>()
    private var _populationList = mutableListOf<String>()
    private val _populationDataList = arrayListOf<BarEntry>()

    override fun getViewBinding() = FragmentSearchBinding.inflate(layoutInflater)
    override fun setUpViews() {
        binding.searchbtn.setOnClickListener{
            search()

        }
    }

    private fun search(){
        val countryName = binding.etSearch.text.toString()
        val dd = Repository.getCities(countryName)
        _cityList = Repository.getCityList()

        val citiesOfCountry = _cityList.filter {
            it.country == countryName
        }
        citiesOfCountry.forEach {
            _cityListItem.add(it.city)
            _populationList.add(it.population.toString())
        }
        bindCountry(dd)
        getPopulation()

    }

    fun bindCountry(country: Model){
        binding.apply {
            tvCountrySearch.text = ("${country.city}, ${country.country}")
            tvPopulationSearch.text = ("${country.population} M")
        }
    }
    override fun addCallBack() {
//        getInfo()
        BarChart()
    }
    //get all population for cities in some country
    fun getPopulation() {
        // solve the wasted data in population
        for (i in 0 until _cityListItem.size-1) {
            if (_populationList[i].trim().isNotEmpty()) {
                _populationDataList.add(BarEntry(_populationList[i].toFloat(),i))
            } else {
                _populationList[i] = "0"
                _populationDataList.add(BarEntry(_populationList[i].toFloat(), i))
//                Toast.makeText(this, "the 0 in some city mean data not fond", Toast.LENGTH_SHORT)
//                    .show()
            }
        }

    }
//    fun getInfo(){
//
//
//        county= ArrayList()
//        county.add("Iraq")
//        county.add("London")
//        county.add("Dubai")
//        county.add("Cairo")
//        county.add("Paris")
//        county.add("Basra")
//        county.add("Karbalaa")
//
//
//        barList = ArrayList()
//        barList.add(BarEntry(4f, 0))
//        barList.add(BarEntry(3f, 1))
//        barList.add(BarEntry(3.5f, 2))
//        barList.add(BarEntry(8.9f, 3))
//        barList.add(BarEntry(2f, 4))
//        barList.add(BarEntry(4f, 5))
//        barList.add(BarEntry(4f, 6))
//
//    }

    fun BarChart(){

        val barChart: BarChart = binding.barChart
        barDataSet = BarDataSet(_populationDataList, "Population")
        barData = BarData(_cityListItem,barDataSet)
        binding!!.barChart.data = barData
        barDataSet.setColors(ColorTemplate.PASTEL_COLORS, 250)
        barDataSet.valueTextColor = Color.WHITE
        barDataSet.valueTextSize = 14f
        barChart.animateXY(2000,2000)
        barChart.setVisibleXRangeMaximum(5f)
        barChart.xAxis.textColor = Color.WHITE
        barChart.axisRight.textColor = Color.WHITE
        barChart.axisLeft.textColor = Color.WHITE
        barChart.setDescription("Cities Population")
        barChart.setDescriptionColor(Color.WHITE)
        barChart.legend.textColor = Color.WHITE
        barChart.xAxis.isEnabled = true

   //     barChart.xAxis.c(_populationDataList.size, true)

    }
}