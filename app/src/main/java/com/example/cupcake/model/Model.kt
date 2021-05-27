package com.example.cupcake.model

object Model{
    private val citesList = mutableListOf<City>()
    var countryList = mutableListOf<Country>()

    private var cityIndex = 0
    private var countryIndex = 0
fun addCity(city: Repository) {
    citesList.add(city)
}

// this function return a long represent total population of list of cities
private fun getTotalPopulation(list: MutableList<Repository>): Long =
    list.sumOf { it.population }.toLong()

fun getCountriesInfo() {
    citesList.groupBy { it.countryName }.entries.map { (name, group) ->
        name.let { Country(it, group as ArrayList<Repository>) }.let { countryList.add(it) }
    }
}

// this function return data grouped by country
fun createCountriesInfo(): List<Country> {
    citesList.groupBy { it.countryName }.entries.map { (name, group) ->
        name.let { Country(it, group as ArrayList<Repository>) }.let { countryList.add(it) }
    }

    return countryList
}

// this function return an instance of Country
fun getCountryByIndex(index: Int): Country = countryList[index]

// this function return an instance of Country
@OptIn(ExperimentalStdlibApi::class)
fun getCountryByName(countryName: String): Country? {
    return countryList.firstOrNull {
        it.name.lowercase().trim() == countryName.lowercase().trim()
    }
}

// this function return an instance of CurrentCountry while swiping between countries info
fun getCurrentCountry(): Country = countryList[countryIndex]


// this function return an instance of NextCountry while swiping between countries info
fun getNextCountry(): Country {
    countryIndex++
    if (countryIndex == countryList.size) {
        countryIndex = 0
    }
    return countryList[countryIndex]
}


// this function return an instance of PreviousCountry while swiping between countries info
fun getPreviousCountry(): Country {
    countryIndex--
    if (countryIndex == -1) {
        countryIndex = countryList.size - 1
    }
    return countryList[countryIndex]
}


//this function return an long represent to total population of a given Country
fun getTotalCountryPopulation(country: Country): Long {
    return getTotalPopulation(country.cities)
}


// this function return a ISO2 of a country
fun getPopulationByCountry(country: Country): String {
    return country.cities[0].population
}



// this function return a list of cities name
fun getCitiesName(cities: List<Repository>): List<String> {
    return cities.map { it.cityName }
}


// this function return a list of cities name of a country
fun getCountryCitiesName(country: Country): List<String> {
    return getCitiesName(country.cities)
}

// this function return string represent country latitude and longitude
fun getLatLan(country: Country): String {
    return "${country.cities[0].latitude.toString()},${country.cities[0].longitude.toString()}"
}
}