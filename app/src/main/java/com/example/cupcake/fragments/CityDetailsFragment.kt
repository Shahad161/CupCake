package com.example.cupcake.fragments


import com.example.cupcake.databinding.FragmentCityDetailsBinding
import com.example.cupcake.model.Model
import com.example.cupcake.util.Constant

class CityDetailsFragment: BaseFragment<FragmentCityDetailsBinding>() {
    override fun getViewBinding() = FragmentCityDetailsBinding.inflate(layoutInflater)
    var model: Model? = null
    override fun setUpViews() {
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
            country.text = model.abbreviation
            city.text = model.city
            population.text = model.populationCity.toString()
            LatitudeNum.text = model.lat.toString()
            longitudeNum.text = model.lon.toString()
        }
    }
}