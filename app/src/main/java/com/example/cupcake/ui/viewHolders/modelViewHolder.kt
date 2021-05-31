package com.example.cupcake.ui.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cupcake.R

class modelViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
    val countryName: TextView = viewItem.findViewById(R.id.countryMax)
    val lon: TextView = viewItem.findViewById(R.id.longitudeMaxNum)
    val lat: TextView = viewItem.findViewById(R.id.LatitudeMaxNum)
    val pop: TextView = viewItem.findViewById(R.id.populationMin)

}