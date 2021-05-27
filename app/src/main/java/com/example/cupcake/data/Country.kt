package com.example.cupcake.data


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(
    val name: String = "",
    val cities : ArrayList<City>
): Parcelable