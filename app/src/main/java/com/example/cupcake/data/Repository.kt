package com.example.cupcake.data

import com.example.cupcake.model.Model

object Repository {
    private val countryList = mutableListOf<Model>()
    fun addCountry(country: Model){
        countryList.add(country)
    }
    fun getCountryList() : MutableList<Model> = countryList

    //Get max City For a specific country
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
        return countryList.filter { it.country.equals(countryName, ignoreCase = true) }
    }
    //Get object of one city
    fun getCityObject(cityName: String):Model {
        var citiesList : Model? = null
        for (city in countryList) {
            if(city.city == cityName) citiesList = city
        }
        return citiesList!!
    }
}