package com.example.cupcake.util

import com.example.cupcake.model.Model

class CsvParser {
    fun parse(line: String): Model{
        val tokens = line.split(",")
        return Model(
            city = tokens[constant.ColumnIndex.CITY],
            country = tokens[constant.ColumnIndex.COUNTRY],
            population = tokens[constant.ColumnIndex.POPULATION].toInt(),
            lat = tokens[constant.ColumnIndex.LAT].toDouble(),
            lang = tokens[constant.ColumnIndex.LANG].toDouble(),
        )
    }
}