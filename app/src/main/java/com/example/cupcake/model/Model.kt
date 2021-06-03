package com.example.cupcake.model

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

@SuppressLint("ParcelCreator")
data class Model(
    val city: String,
    val country: String,
    val abbreviation: String,
    val populationCountry: Int,
    val populationCity: String,
    val lat: Double,
    val lon: Double
) : Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("Not yet implemented")
    }
}
