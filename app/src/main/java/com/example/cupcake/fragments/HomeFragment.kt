package com.example.cupcake.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.example.cupcake.R
import com.example.cupcake.data.Repository
import com.example.cupcake.databinding.FragmentHomeBinding
import com.example.cupcake.model.Model
import com.example.cupcake.ui.MainActivity
import com.example.cupcake.ui.ModelInteractionListner
import com.razerdp.widget.animatedpieview.AnimatedPieView
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig
import com.razerdp.widget.animatedpieview.data.SimplePieInfo


class HomeFragment : BaseFragment<FragmentHomeBinding>(), ModelInteractionListner {
    private lateinit var passData: ModelInteractionListner

    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)
    @SuppressLint("UseRequireInsteadOfGet")

    override fun setUpViews() {
        // Open search fragment when you click on ImageButton in frontend
        passData = activity as ModelInteractionListner
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

    }
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
        passData.OnClickItem(model)
    }

    override fun OnClickCountry(name: String) {
        Toast.makeText(context, name, Toast.LENGTH_SHORT).show()
    }
}
