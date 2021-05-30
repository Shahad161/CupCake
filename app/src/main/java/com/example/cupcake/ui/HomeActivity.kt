package com.example.cupcake.ui

import android.graphics.Color
import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.example.cupcake.R
import com.example.cupcake.data.Repository
import com.example.cupcake.databinding.ActivityHomeBinding
import com.example.cupcake.fragments.HomeFragment
import com.example.cupcake.util.CsvParser
import com.razerdp.widget.animatedpieview.AnimatedPieView
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig
import com.razerdp.widget.animatedpieview.data.SimplePieInfo
import java.io.BufferedReader
import java.io.InputStreamReader

class HomeActivity : BaseActivity<ActivityHomeBinding>(){
    override val Log_tag: String = "MAIN_ACTIVITY"
    override val bindingInflater: (LayoutInflater) -> ActivityHomeBinding = ActivityHomeBinding::inflate

    override fun setup() {
        addFragment()
    }

    override fun addCallBack() {
    }

//add fragment inside Home_Activity
    private fun addFragment(){
        val fm: FragmentManager = supportFragmentManager
        fm.beginTransaction().add(R.id.fragment_container, HomeFragment()).commit()
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
}