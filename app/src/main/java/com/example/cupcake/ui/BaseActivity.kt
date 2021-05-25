package com.example.cupcake.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.cupcake.R
import java.lang.Thread.sleep

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    abstract val bindingInflater: (LayoutInflater) -> VB
    private var _binding: ViewBinding? = null

    protected val binding
        get() = _binding as VB?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CupCake)
        sleep(3000)
        _binding = bindingInflater(layoutInflater)
        setContentView(requireNotNull(_binding).root)
    }
}