package com.example.cupcake.data

import android.util.Log
import com.example.cupcake.model.Model

object Repository {
    val Log_tag: String = "test3"
    private val countryList = mutableListOf<Model>()
    private var countryIndex = 0

    fun addCountry(country: Model){
        countryList.add(country)
    }
    fun getCityList() : MutableList<Model> = countryList
    fun getCurrentCity(): Model = countryList[countryIndex]
    fun getMaxCity():Model {
        val city = countryList.maxByOrNull { it.population }
        val maxIndex = countryList.indexOf(city)
        return countryList[maxIndex]
    }
    fun getMinCity():Model {
        val city = countryList.minByOrNull { it.population }
        val maxIndex = countryList.indexOf(city)
        return countryList[maxIndex]
    }
    fun getCities(countryName: String):Model? {
        var citiesList = countryList.filter { it.country == countryName }
        if (citiesList==null){
            return null
        }else {
            val city = citiesList.maxByOrNull { it.population }
            val maxIndex = citiesList.indexOf(city)
            //      log(citiesList[maxIndex])
            return citiesList[maxIndex]
        }
    }
    fun log(value: Any){
        Log.v(Log_tag, value.toString())
    }
}