package com.example.cupcake.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.cupcake.data.Repository
import com.example.cupcake.databinding.ActivitySearchBinding
import com.example.cupcake.model.Model
import com.example.cupcake.util.CsvParser
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import java.io.BufferedReader
import java.io.InputStreamReader

class SearchActivity : BaseActivity<ActivitySearchBinding>() {
    override val Log_tag: String = "SEARCH_ACTIVITY"
    override val bindingInflater: (LayoutInflater) -> ActivitySearchBinding =
        ActivitySearchBinding::inflate

    //get list and of values of search
    var listOfCountryName = mutableListOf<String>()
    private var _cityListItem = arrayListOf<String>()
    private var _populationList = mutableListOf<String>()
    var adapter: ArrayAdapter<String>? = null
    private var _populationDataList = arrayListOf<BarEntry>()
    private var _cityList: MutableList<Model> = mutableListOf<Model>()
    lateinit var barData: BarData
    lateinit var barDataSet: BarDataSet

    override fun setup() {
        //disappear for list if there is no value in search box
        binding?.listView?.isVisible = false
        _cityList = Repository.getCityList()

        //make loop to check all item
        _cityList.forEach {
            listOfCountryName.add(it.country)
        }
        adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfCountryName.distinct())
        binding?.listView?.adapter = adapter

        showChart()
    }

    //clear old value after finish the search
    fun clearLists() {
        //clear lists
        _cityListItem.clear()
        _populationDataList.clear()
    }

    //show chart for population of country
    fun showChart() {
        binding?.listView?.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, _, i, _ ->
                clearLists()

                //make filter to make values as table
                val x = _cityList.filter {
                    it.country == adapterView.getItemAtPosition(i).toString()
                }
                x.forEach {
                    _cityListItem.add(it.city)
                    _populationList.add(it.population.toString())
                    //set the select country in search view
                    binding?.searchView?.setQuery(it.country, false)

                }
                //show chart and hide list after execute the search function
                binding?.listView?.isVisible = false
                binding?.barChart?.isVisible = true

                BarChart()
            }

    }

    override fun addCallBack() {
        binding?.apply {
            //add set query listener to search box
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    searchView.clearFocus()

                    return if (listOfCountryName.contains(query)) {
                        adapter?.filter?.filter(query)

                        true
                    } else {
                        Toast.makeText(applicationContext, "Country not found", Toast.LENGTH_LONG)
                            .show()
                        false
                    }
                    return true
                }

                //add query text change to this listener
                override fun onQueryTextChange(newText: String?): Boolean {
                    listView.isVisible = true
                    barChart.isVisible = false
                    adapter?.filter?.filter(newText)
                    if (newText == "") listView.isVisible = false
                    return false
                }
            })
        }
    }

    //get all population for cities in some country

   // fun getPopulation() {
    //            // solve the wasted data in population
    //            for (i in 0 until _cityListItem.size) {
    //                if (_populationList[i].trim().isNotEmpty()) {
    //                    _populationDataList. add(BarEntry(_populationList[i].toFloat(),i.toFloat() + 1 ))
    //                } else {
    //                    _populationList[i] = "0.0"
    //                    _populationList.add(BarEntry( _populationList[i].toFloat(), i.toFloat() + 1))
    //                   Toast.makeText(this, "the 0 in some city mean data not fond", Toast.LENGTH_SHORT)
    //                        .show()
    //               }
    //            }
    //
    //       }


    fun getInfo(){
        listOfCountryName= ArrayList()
        listOfCountryName.add("Iraq")
        listOfCountryName.add("London")
        listOfCountryName.add("Dubai")
        listOfCountryName.add("Cairo")
        listOfCountryName.add("Paris")
        listOfCountryName.add("Basra")
        listOfCountryName.add("Karbalaa")



        _populationDataList = ArrayList()
        _populationDataList.add(BarEntry(4f, 0))
        _populationDataList.add(BarEntry(3f, 1))
        _populationDataList.add(BarEntry(3.5f, 2))
        _populationDataList.add(BarEntry(8.9f, 3))
        _populationDataList.add(BarEntry(2f, 4))
        _populationDataList.add(BarEntry(4f, 5))
        _populationDataList.add(BarEntry(4f, 6))

    }
    fun BarChart() {
        val barChart: BarChart = findViewById(binding!!.barChart.id)
        barDataSet = BarDataSet(_populationDataList, "Population")
        barData = BarData(listOfCountryName, barDataSet)
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
    }
}


