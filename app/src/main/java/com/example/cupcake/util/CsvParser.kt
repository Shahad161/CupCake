package com.example.cupcake.util

import com.example.cupcake.data.Repository
import com.example.cupcake.model.Model

// This is split the values based on the Sorter ( , ) to become Table
class CsvParser {
    fun parse(line : String) : Model {
        val tokens = line.split(",")
        return Model(
            city = tokens[Constant.ColumnIndex.CITY],
            country   = tokens[Constant.ColumnIndex.COUNTRY],
            capital  = tokens[Constant.ColumnIndex.CAPITAL],
            population  = tokens[Constant.ColumnIndex.POPULATION].toInt(),
            lat = tokens[Constant.ColumnIndex.LAT].toDouble(),
            lon = tokens[Constant.ColumnIndex.LON].toDouble()
        )
    }
}
