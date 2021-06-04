package com.example.cupcake.fragments

import android.content.Context
import android.view.LayoutInflater
import androidx.fragment.app.FragmentTransaction
import com.example.cupcake.R
import com.example.cupcake.data.Repository
import com.example.cupcake.databinding.FragmentCityDetailsBinding
import com.example.cupcake.model.Model
import com.example.cupcake.util.Constant
import com.google.android.material.chip.Chip

class CityDetailsFragment: BaseFragment<FragmentCityDetailsBinding>() {
    override fun getViewBinding() = FragmentCityDetailsBinding.inflate(layoutInflater)
    var model: Model? = null
    private var _cityList: MutableList<Model> = mutableListOf()
    private var _cityListItem = arrayListOf<String>()

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
        bindChips(model.country)
    }
    private  fun bindChips(countryName: String){
        _cityList = Repository.getAllCities(countryName).toMutableList()
        _cityList.filter { (it.cityType == Constant.key.ADMIN || it.cityType == Constant.key.PRIMARY) && it.populationCity != 0 }.forEach {
            _cityListItem.add(it.city)
        }
        var chip_item : Chip
        val inflater = layoutInflater
        for (city in 0 until _cityListItem.size){
            chip_item = inflater.inflate(R.layout.chip_item,null,false) as Chip
            chip_item.text = _cityListItem[city]
            chip_item.setOnClickListener(){
                val cityModel = Repository.getCityObject(_cityListItem[city])
                bindModel(cityModel)
            }
            binding.chipGroup.addView(chip_item)
        }

    }
}