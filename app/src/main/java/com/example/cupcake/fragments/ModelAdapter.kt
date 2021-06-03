package com.example.cupcake.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cupcake.R.layout.item_model
import com.example.cupcake.databinding.ItemModelBinding
import com.example.cupcake.model.Model
import com.example.cupcake.ui.ModelInteractionListner

class ModelAdapter(val list: List<Model>,val listener: ModelInteractionListner): RecyclerView.Adapter<ModelAdapter.modelViewHolders>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): modelViewHolders {
        val view = LayoutInflater.from(parent.context).inflate(item_model, parent, false)
        return modelViewHolders(view)
    }

    override fun onBindViewHolder(holder: modelViewHolders, position: Int) {
        val currentModel = list[position]
        holder.binding.apply {
            countryMax.text = ("${currentModel.city}, ${currentModel.country}")
            populationMax.text = ("${currentModel.population} M")
            longitudeMaxNum.text = currentModel.lon.toString()
            LatitudeMaxNum.text = currentModel.lat.toString()
            countryMax.setOnClickListener{ listener.OnClickCountry(currentModel.country) }
            root.setOnClickListener { listener.OnClickItem(currentModel) }
        }

    }
    override fun getItemCount() =list.size

    class modelViewHolders(viewItem: View): RecyclerView.ViewHolder(viewItem) {
        val binding = ItemModelBinding.bind(viewItem)
    }

}