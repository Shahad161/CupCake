package com.example.cupcake.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cupcake.R
import com.example.cupcake.fragments.viewHolders.modelViewHolders
import com.example.cupcake.model.Model

class ModelAdapter(val list: List<Model>): RecyclerView.Adapter<modelViewHolders>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): modelViewHolders {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_model, parent, false)
        return modelViewHolders(view)
    }

    override fun onBindViewHolder(holder: modelViewHolders, position: Int) {
        val currentModel = list[position]
        holder.apply {
            textCountryName.text = currentModel.country
            textPop.text = currentModel.population.toString()
            textLong.text = currentModel.lon.toString()
            textlat.text = currentModel.lat.toString()
        }

    }

    override fun getItemCount() =list.size

}