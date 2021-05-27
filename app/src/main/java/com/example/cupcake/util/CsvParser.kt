package com.example.cupcake.util

// This is split the values based on the Sorter ( , ) to become Table
class CsvParser {
    fun parse(line : String) : City {
        val tokens = line.split(",")
        return City(
            city = tokens[Constants.ColumnIndex.CITY],
            country   = tokens[Constants.ColumnIndex.COUNTRY],
            capital  = tokens[Constants.ColumnIndex.CAPITAL],
            population  = tokens[Constants.ColumnIndex.POPULATION].toDouble(),
            lat = tokens[Constants.ColumnIndex.LAT].toDouble(),
            lng = tokens[Constants.ColumnIndex.LNG].toDouble()
        )
    }
}