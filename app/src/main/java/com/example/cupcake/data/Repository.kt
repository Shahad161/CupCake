package com.example.cupcake.data

import com.example.cupcake.model.Model

object Repository {
    private val countryList = mutableListOf<Model>()
    private var countryIndex = 0

    fun addCountry(country: Model){
        countryList.add(country)
    }

    fun getCountryList() : MutableList<Model> = countryList
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
        val citiesList = countryList.filter {
            it.country.equals(countryName, ignoreCase = true)
        }
        val city = citiesList.maxByOrNull { it.populationCity }
        val maxIndex = citiesList.indexOf(city)
        return citiesList[maxIndex]
    }

    //Get All Cities For a specific country
    fun getAllCities(countryName: String): List<Model> {
        val citiesList = countryList.filter {it.country.equals(countryName, ignoreCase = true)}
        return citiesList
    }
}