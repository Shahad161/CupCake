package com.example.cupcake.fragments

import android.graphics.Color
import android.util.Log
import android.widget.Toast
import com.example.cupcake.data.Repository
import com.example.cupcake.databinding.FragmentSearchBinding
import com.example.cupcake.model.Model
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.YAxis
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
            clearLists()
            val countryName = binding.etSearch.text.toString()
            val countryDetails = Repository.getCities(countryName)

            if (countryName==""){
                Toast.makeText(getActivity(), "Country not found", Toast.LENGTH_LONG).show()
            }else if (countryDetails== null){
                Toast.makeText(getActivity(), "Country not found", Toast.LENGTH_LONG).show()

            }else {

                bindCountry(countryDetails)
                search()
            }
        }
    }

    private fun search(){
        val countryName = binding.etSearch.text.toString()

        _cityList = Repository.getCityList()

        val citiesOfCountry = _cityList.filter {
            it.country == countryName
        }
        citiesOfCountry.forEach {
            _cityListItem.add(it.city)
            _populationList.add(it.population.toString())
        }

        getPopulation()

    }

    fun bindCountry(country: Model){
        binding.apply {
            tvCountrySearch.text = ("${country.city}, ${country.country}")
            tvPopulationSearch.text = ("${country.population} M")
        }
    }
    override fun addCallBack() {

    }
    //get all population for cities in some country
    fun getPopulation() {
        // solve the wasted data in population
        for (i in 0 until _cityListItem.size) {
            if (_populationList[i].trim().isNotEmpty()) {
                _populationDataList.add(BarEntry(_populationList[i].toFloat(),i))
            } else {
                _populationList[i] = "0"
                _populationDataList.add(BarEntry(_populationList[i].toFloat(), i))
//                Toast.makeText(this, "the 0 in some city mean data not fond", Toast.LENGTH_SHORT)
//                    .show()
            }

        }
        BarChart()
    }


    fun BarChart(){
//        Log.i("mmmm", _cityListItem.toString())

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
        val rightYAxis: YAxis = binding.barChart.axisRight
        rightYAxis.isEnabled = false
        rightYAxis.setDrawGridLines(false)

        val liftYAxis: YAxis = binding.barChart.axisLeft
        liftYAxis.isEnabled = false
        liftYAxis.setDrawGridLines(false)

    }
    //clear old value after finish the search
    fun clearLists() {
        //clear lists
        _cityListItem.clear()
        _populationDataList.clear()
        _populationList.clear()
    }
}