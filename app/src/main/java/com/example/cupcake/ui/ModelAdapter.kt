package com.example.cupcake.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.cupcake.R
import com.example.cupcake.R.layout.item_model
import com.example.cupcake.databinding.ItemModelBinding
import com.example.cupcake.model.Model

class ModelAdapter(val list: List<Model>,val listener: ModelInteractionListner): RecyclerView.Adapter<ModelAdapter.modelViewHolders>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): modelViewHolders {
        val view = LayoutInflater.from(parent.context).inflate(item_model, parent, false)
        return modelViewHolders(view)
    }

    override fun onBindViewHolder(holder: modelViewHolders, position: Int) {
        val currentModel = list[position]

        holder.binding.apply {
            countryMax.text = currentModel.iso
            cityMax.text = currentModel.city
            populationMax.text = ("${currentModel.populationCity} M")
            longitudeMaxNum.text = currentModel.lon.toString()
            LatitudeMaxNum.text = currentModel.lat.toString()
            root.setOnClickListener { listener.OnClickItem(currentModel) }
            holder.itemView.animation =
                AnimationUtils.loadAnimation(holder.itemView.context, R.anim.cards_anim)
        }

    }
    override fun getItemCount() =list.size

    class modelViewHolders(viewItem: View): RecyclerView.ViewHolder(viewItem) {
        val binding = ItemModelBinding.bind(viewItem)
    }

}