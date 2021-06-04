package com.example.cupcake.fragments

import androidx.fragment.app.FragmentTransaction
import com.example.cupcake.R
import com.example.cupcake.databinding.FragmentCityDetailsBinding
import com.example.cupcake.model.Model
import com.example.cupcake.util.Constant

class CityDetailsFragment: BaseFragment<FragmentCityDetailsBinding>() {
    override fun getViewBinding() = FragmentCityDetailsBinding.inflate(layoutInflater)
    var model: Model? = null
    override fun setUpViews() {
        binding.back.setOnClickListener {
            val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.fragment_container, HomeFragment()).commit()
        }
    }

    override fun onStart() {
        super.onStart()
        model?.let { bindModel(it) }
    }

    override fun addCallBack() {
        model = arguments?.getParcelable(Constant.key.Model) as Model?
    }
    private fun bindModel(model: Model) {
        binding.apply {
            abbreviation.text = model.iso
            countrylaple.text = model.country
            city.text = model.city
            populationcity.text = ("${model.populationCity} M")
            LatitudeNum.text = model.lat.toString()
            longitudeNum.text = model.lon.toString()
        }
    }
}