package com.example.cupcake.data

import com.example.cupcake.model.Model

// هذا مثل كلاس ال DataManager  اللي سواه بارق
object Repository {
    private val countryList = mutableListOf<Model>()
    private var countryIndex = 0

    fun addCountry(country: Model){
        countryList.add(country)
    }
    fun getCurrentCity(): Model = countryList[countryIndex]
}