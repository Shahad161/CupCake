package com.example.cupcake.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cupcake.R
import com.example.cupcake.databinding.ItemModelBinding
import com.example.cupcake.model.Model

class ModelAdapter(val list: List<Model>): RecyclerView.Adapter<ModelAdapter.modelViewHolders>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): modelViewHolders {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_model, parent, false)
        return modelViewHolders(view)
    }

    override fun onBindViewHolder(holder: modelViewHolders, position: Int) {
        val currentModel = list[position]
        holder.binding.apply {
            countryMax.text = currentModel.country
            populationMax.text = currentModel.population.toString()
            longitudeMaxNum.text = currentModel.lon.toString()
            LatitudeMaxNum.text = currentModel.lat.toString()
        }

    }

    override fun getItemCount() =list.size



    class modelViewHolders(viewItem: View): RecyclerView.ViewHolder(viewItem) {
        val binding = ItemModelBinding.bind(viewItem)
//    val textCountryName: TextView = viewItem.findViewById(R.id.countryMax) // delete after check
//    val textPop: TextView = viewItem.findViewById(R.id.populationMax)
//    val textLong: TextView = viewItem.findViewById(R.id.longitudeMaxNum)
//    val textlat: TextView = viewItem.findViewById(R.id.LatitudeMaxNum)
    }

}