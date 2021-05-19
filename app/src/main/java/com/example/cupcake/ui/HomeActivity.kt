package com.example.cupcake.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import com.example.cupcake.databinding.ActivityHomeBinding
import com.razerdp.widget.animatedpieview.AnimatedPieView
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig
import com.razerdp.widget.animatedpieview.data.SimplePieInfo


class HomeActivity : BaseActivity<ActivityHomeBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityHomeBinding
        get() = ActivityHomeBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PieChart()
        binding?.btnToSearch?.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

    }
    fun PieChart() {
    val mAnimatedPieView: AnimatedPieView = findViewById(binding!!.PieChart.id)
    val config = AnimatedPieViewConfig()
    config.startAngle(-90f)
        .addData(SimplePieInfo(30.0, Color.parseColor("#386CBA"), "Baghdad"))
        .addData(SimplePieInfo(18.0, Color.parseColor("#FFEECA"), "London"))
        .addData(SimplePieInfo(10.0, Color.parseColor("#A6ABBD"), "Paris"))
        .addData(SimplePieInfo(20.0, Color.parseColor("#B44760"), "Dubai"))
        .addData(SimplePieInfo(10.0, Color.parseColor("#F07C92"), "Cairo"))
        .drawText(true).textSize(30.0F).duration(2000)
    mAnimatedPieView.applyConfig(config)
    mAnimatedPieView.start()
}
}