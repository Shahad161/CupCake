package com.example.cupcake.fragments

import android.graphics.Color
import com.example.cupcake.databinding.FragmentSearchBinding
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

    override fun getViewBinding() = FragmentSearchBinding.inflate(layoutInflater)
    override fun setUpViews() {

        // set up recycler view and bind data to UI
    }

    override fun addCallBack() {
        getInfo()
        BarChart()
    }

    fun getInfo(){
        county= ArrayList()
        county.add("Iraq")
        county.add("London")
        county.add("Dubai")
        county.add("Cairo")
        county.add("Paris")
        county.add("Basra")
        county.add("Karbalaa")


        barList = ArrayList()
        barList.add(BarEntry(4f, 0))
        barList.add(BarEntry(3f, 1))
        barList.add(BarEntry(3.5f, 2))
        barList.add(BarEntry(8.9f, 3))
        barList.add(BarEntry(2f, 4))
        barList.add(BarEntry(4f, 5))
        barList.add(BarEntry(4f, 6))

    }

    fun BarChart(){
        val barChart: BarChart = binding.barChart
        barDataSet = BarDataSet(barList, "Population")
        barData = BarData(county,barDataSet)
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