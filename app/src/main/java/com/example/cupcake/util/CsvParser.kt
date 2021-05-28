package com.example.cupcake.util

import com.example.cupcake.data.Repository

// This is split the values based on the Sorter ( , ) to become Table
class CsvParser {
    fun parse(line : String) : Repository {
        val tokens = line.split(",")
        return Repository(
            city = tokens[Constant.ColumnIndex.CITY],
            country   = tokens[Constant.ColumnIndex.COUNTRY],
            capital  = tokens[Constant.ColumnIndex.CAPITAL],
            population  = tokens[Constant.ColumnIndex.POPULATION],
            lat = tokens[Constant.ColumnIndex.LAT].toDouble(),
            lng = tokens[Constant.ColumnIndex.LNG].toDouble()
        )
    }
}
