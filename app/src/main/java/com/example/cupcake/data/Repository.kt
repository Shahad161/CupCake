package com.example.cupcake.data

import android.os.Build
import androidx.annotation.RequiresApi
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
    @RequiresApi(Build.VERSION_CODES.N)
    fun getMinCity():Model {
        val city = countryList.maxWithOrNull(Comparator.comparingInt { it.populationCity })
        val maxIndex = countryList.indexOf(city)
        return countryList[maxIndex]
    }

    //Get max City For a specific country
    @RequiresApi(Build.VERSION_CODES.N)
    fun getMaxCityOfCountry(countryName: String):Model {
        val citiesList = countryList.filter {
            it.country.equals(countryName, ignoreCase = true)
        }
        val city = citiesList.maxWithOrNull(Comparator.comparingInt { it.populationCity })
        val maxIndex = citiesList.indexOf(city)
        return citiesList[maxIndex]
    }

    //Get All Cities For a specific country
    fun getAllCities(countryName: String): List<Model> {
        val citiesList = countryList.filter {it.country.equals(countryName, ignoreCase = true)}
        return citiesList
    }
}