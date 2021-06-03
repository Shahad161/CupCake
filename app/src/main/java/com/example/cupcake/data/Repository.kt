package com.example.cupcake.data

import com.example.cupcake.model.Model

object Repository {
    val countryList: MutableList<Model> = mutableListOf<Model>()
    private var countryIndex = 0

    fun addCountry(country: Model){
        countryList.add(country)
    }

    fun getCityList() : MutableList<Model> = countryList
    fun getCurrentCity(): Model = countryList[countryIndex]
    fun getMaxCity():Model {
        val city = countryList.maxByOrNull { it.populationCity }
        val maxIndex = countryList.indexOf(city)
        return countryList[maxIndex]
    }
    fun getMinCity():Model {
        val city = countryList.minByOrNull { it.populationCity }
        val maxIndex = countryList.indexOf(city)
        return countryList[maxIndex]
    }

//Get City For a specific country
    fun getMaxCityOfCountry(countryName: String):Model {
        val citiesList = countryList.filter { it.country == countryName }
        val city = citiesList.maxByOrNull { it.populationCity }
        val maxIndex = citiesList.indexOf(city)
        return citiesList[maxIndex]
    }

//Get All Cities For a specific country
    fun getAllCities(countryName: String): List<Model> {
        val citiesList = countryList.filter { it.country == countryName }
        return citiesList
    }
}