package com.example.cupcake.fragments.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cupcake.R
import com.example.cupcake.databinding.ItemModelBinding

class modelViewHolders(viewItem: View): RecyclerView.ViewHolder(viewItem) {
    val textCountryName: TextView = viewItem.findViewById(R.id.countryMax)
    val textPop: TextView = viewItem.findViewById(R.id.populationMax)
    val textLong: TextView = viewItem.findViewById(R.id.longitudeMaxNum)
    val textlat: TextView = viewItem.findViewById(R.id.LatitudeMaxNum)
}