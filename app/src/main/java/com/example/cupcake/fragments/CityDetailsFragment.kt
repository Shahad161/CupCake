package com.example.cupcake.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import androidx.fragment.app.FragmentTransaction
import com.example.cupcake.R
import com.example.cupcake.databinding.ActivityMainBinding
import com.example.cupcake.databinding.FragmentCityDetailsBinding
import com.example.cupcake.databinding.FragmentHomeBinding
import com.example.cupcake.model.Model
import com.example.cupcake.util.Constant

class CityDetailsFragment: BaseFragment<FragmentCityDetailsBinding>() {
    val Log_tag: String = "MAIN_ACTIVITY"
    val bindingInflater: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate
    @SuppressLint("UseRequireInsteadOfGet")

    override fun setUpViews() {
//        val model: Model? = intent.getSerializableExtra(Constant.key.Model) as Model?
//        model?.let { bindModel(it) }

        val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
        transaction.replace(R.id.fragment_container, CityDetailsFragment()).commit()

    }

    override fun addCallBack() {


    }
    private fun bindModel(model: Model) {
        binding.apply {
            country.text = model.country
            city.text = model.city
            population.text = model.population.toString()
            tvLatitude.text = model.lat.toString()
            longitudeNum.text = model.toString()


        }
    }

    override fun getViewBinding(): FragmentCityDetailsBinding {
        TODO("Not yet implemented")
    }

}