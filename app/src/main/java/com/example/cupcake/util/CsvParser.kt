package com.example.cupcake.util

import com.example.cupcake.model.Model

// This is split the values based on the Sorter ( , ) to become Table
class CsvParser {
    fun parse(line : String) : Model {
        val tokens = line.split(",")
        return Model(
            city = tokens[Constant.ColumnIndex.CITY],
            country   = tokens[Constant.ColumnIndex.COUNTRY],
            abbreviation = tokens[Constant.ColumnIndex.ABBREVIATION],
            populationCountry = tokens[Constant.ColumnIndex.POPULATIONCOUNTRY].toInt(),
            populationCity  = tokens[Constant.ColumnIndex.POPULATIONCITY].toString(),
            lat = tokens[Constant.ColumnIndex.LAT].toDouble(),
            lon = tokens[Constant.ColumnIndex.LON].toDouble(),
            cityType = tokens[Constant.ColumnIndex.CITY_TYPE]
        )
    }
}
