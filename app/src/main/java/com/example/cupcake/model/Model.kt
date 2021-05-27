package com.example.cupcake.model

import com.example.cupcake.data.Repository

object Model{
    private val _cityList: MutableList<Repository> = mutableListOf<Repository>()
    private var _index = 0
    fun getCityList() : MutableList<Repository> = _cityList

    //Add Components to list
    fun addCity(city: Repository){
        _cityList.add(city)
    }

    fun getCurrentCity(): Repository = _cityList[_index]

    //check  get next Components in list
    fun getNextCity():Repository{
        if (_index == _cityList.size-1){
            _index = 0
            return _cityList[_index]
        }
        _index++
        return _cityList[_index]
    }

    //check  get previous Components in list
    fun getPreviousCity(): Repository{
        if (_index == 0){
            _index = _cityList.size-1
            return _cityList[_index]
        }
        _index--
        return _cityList[_index]
    }
}


