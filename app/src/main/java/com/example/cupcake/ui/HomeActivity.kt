package com.example.cupcake.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.example.cupcake.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity<ActivityHomeBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityHomeBinding
        get() = ActivityHomeBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding?.btnToSearch?.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

    }
}