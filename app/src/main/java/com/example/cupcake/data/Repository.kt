package com.example.cupcake.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//This is data type of the Components
@Parcelize
data class Repository(
    val city: String,
    val country: String,
    val capital: String,
    val population: Double,
    val lat:Double,
    val lng:Double


): Parcelable