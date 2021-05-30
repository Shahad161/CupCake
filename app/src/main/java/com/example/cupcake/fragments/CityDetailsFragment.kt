package com.example.cupcake.fragments

import com.example.cupcake.databinding.FragmentCityDetailsBinding

class CityDetailsFragment: BaseFragment<FragmentCityDetailsBinding>() {
    override fun getViewBinding() = FragmentCityDetailsBinding.inflate(layoutInflater)
    override fun setUpViews() {

        // set up recycler view and bind data to UI
    }

    override fun addCallBack() {
    }
}