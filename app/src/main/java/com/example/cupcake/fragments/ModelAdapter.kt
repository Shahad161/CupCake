package com.example.cupcake.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cupcake.R
import com.example.cupcake.R.layout.item_model
import com.example.cupcake.databinding.ItemModelBinding
import com.example.cupcake.model.Model

class ModelAdapter(val list: List<Model>): RecyclerView.Adapter<ModelAdapter.modelViewHolders>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): modelViewHolders {
        val view = LayoutInflater.from(parent.context).inflate(item_model, parent, false)
        return modelViewHolders(view)
    }

    override fun onBindViewHolder(holder: modelViewHolders, position: Int) {
        val currentModel = list[position]
        holder.binding.apply {
            countryMax.text = currentModel.country
            populationMax.text = currentModel.population.toString()
            longitudeMaxNum.text = currentModel.lon.toString()
            LatitudeMaxNum.text = currentModel.lat.toString()
            countryMax.setOnClickListener{
                Toast.makeText(countryMax.context, currentModel.country,Toast.LENGTH_SHORT)
            }
        }

    }
    override fun getItemCount() =list.size

    class modelViewHolders(viewItem: View): RecyclerView.ViewHolder(viewItem) {
        val binding = ItemModelBinding.bind(viewItem)
    }

}