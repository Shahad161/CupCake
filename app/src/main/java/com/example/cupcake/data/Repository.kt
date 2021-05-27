package com.example.cupcake.data

import com.example.cupcake.model.Model

object Repository {
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
}