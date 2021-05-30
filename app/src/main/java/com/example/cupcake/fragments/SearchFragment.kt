package com.example.cupcake.fragments

import com.example.cupcake.databinding.FragmentSearchBinding

class SearchFragment: BaseFragment<FragmentSearchBinding>() {
    override fun getViewBinding() = FragmentSearchBinding.inflate(layoutInflater)
    override fun setUpViews() {

        // set up recycler view and bind data to UI
    }

    override fun addCallBack() {
    }
}