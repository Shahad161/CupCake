package com.example.cupcake.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.example.cupcake.R
import com.example.cupcake.data.Repository
import com.example.cupcake.databinding.FragmentHomeBinding
import com.example.cupcake.model.Model
import com.example.cupcake.ui.MainActivity
import com.example.cupcake.ui.ModelInteractionListner
import com.example.cupcake.util.Constant
import com.razerdp.widget.animatedpieview.AnimatedPieView
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig
import com.razerdp.widget.animatedpieview.data.SimplePieInfo


class HomeFragment : BaseFragment<FragmentHomeBinding>(), ModelInteractionListner {
    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)
    @SuppressLint("UseRequireInsteadOfGet")

    override fun setUpViews() {
        // Open search fragment when you click on ImageButton in frontend
        binding.btnToSearch.setOnClickListener {
            val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.fragment_container, SearchFragment()).commit()
        }


    }
    override fun addCallBack() {
        getCitiesInfo()
        pieChart()
        val adapter = ModelAdapter(Repository.countryList.sortedBy { it.population }.reversed(), this) // list of cities to adapter
        binding.recycleMain.adapter = adapter

    }

//call function to get Info from Csv file
    private fun getCitiesInfo(){
        (activity as MainActivity).parseFile()
//        bindCountryMax(Repository.getMaxCity())
//        bindCountryMin(Repository.getMinCity())
    }

// Send Info. of MinCity to frontend
//    fun bindCountryMax(country: Model){
//        binding?.apply {
//            countryMax!!.text = ("${country.city}, ${country.country}")
//            populationMax!!.text = ("${country.population} M")
//            longitudeMaxNum!!.text = country.lon.toString()
//            LatitudeMaxNum!!.text = country.lat.toString()
//        }
//    }
//
//// Send Info. of MinCity to frontend
//    fun bindCountryMin(country: Model){
//        binding?.apply {
//            countryMin!!.text = ("${country.city}, ${country.country}")
//            populationMin!!.text = ("${country.population} M")
//            longitudeMinNum!!.text = country.lon.toString()
//            LatitudeMinNum!!.text = country.lat.toString()
//
//        }
//    }

// Display PieChart
    fun pieChart() {
        val mAnimatedPieView: AnimatedPieView? = binding.PieChart
        val config = AnimatedPieViewConfig()
        config.startAngle(-90f)
            .addData(SimplePieInfo(30.0, Color.parseColor("#386CBA"), "Baghdad"))
            .addData(SimplePieInfo(18.0, Color.parseColor("#FFEECA"), "London"))
            .addData(SimplePieInfo(10.0, Color.parseColor("#A6ABBD"), "Paris"))
            .addData(SimplePieInfo(20.0, Color.parseColor("#B44760"), "Dubai"))
            .addData(SimplePieInfo(10.0, Color.parseColor("#F07C92"), "Cairo"))
            .drawText(true).textSize(30.0F).duration(2000)
        mAnimatedPieView?.applyConfig(config)
        mAnimatedPieView?.start()
    }

    override fun OnClickItem(model: Model) {
        val myIntent = Intent(context,CityDetailsFragment::class.java)
        myIntent.putExtra(Constant.key.Model, model)
        startActivity(myIntent)


    }

    override fun OnClickCountry(name: String) {
        Toast.makeText(context, name, Toast.LENGTH_SHORT).show()
    }
}

private fun Intent.putExtra(model: String, model1: Model) {

}
