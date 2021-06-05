package com.example.cupcake.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.example.cupcake.R
import com.example.cupcake.data.Repository
import com.example.cupcake.databinding.ActivityMainBinding
import com.example.cupcake.fragments.CityDetailsFragment
import com.example.cupcake.fragments.HomeFragment
import com.example.cupcake.model.Model
import com.example.cupcake.util.Constant
import com.example.cupcake.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : BaseActivity<ActivityMainBinding>(), ModelInteractionListner{
    override val Log_tag: String = "MainActivity"
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate

    override fun setup() {
        replaceFragment(HomeFragment())
        parseFile()
    }

    override fun addCallBack() {
    }

//add fragment inside Home_Activity
    private fun replaceFragment(fragment: Fragment){
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.fragment_container, fragment).addToBackStack(null).commit()
    }

// read data from Csv file
    fun parseFile(){
        val inputStream = assets.open("worldcities.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser = CsvParser()
        buffer.forEachLine {
            val currentCity = parser.parse(it)
            Repository.addCountry(currentCity)
        }
    }

    override fun OnClickItem(model: Model) {
        val bundle = Bundle()
        val cityDetailsFragment = CityDetailsFragment()
        bundle.putParcelable(Constant.key.Model, model)
        cityDetailsFragment.arguments = bundle
        replaceFragment(cityDetailsFragment)
    }
}