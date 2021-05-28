package com.example.cupcake.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.cupcake.R
import java.lang.Thread.sleep

@Suppress("UNCHECKED_CAST")
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    abstract val Log_tag: String
    abstract val bindingInflater: (LayoutInflater) -> VB
    var _binding: ViewBinding? = null
    protected var binding: VB?
        get() = _binding as? VB
        set(value) = TODO()


    //This is onCreate function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CupCake)
        sleep(3000)
        _binding = bindingInflater(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        setup()
        addCallBack()

    }
    abstract fun setup()
    abstract fun addCallBack()

    protected fun log(value: Any){
        Log.v(Log_tag, value.toString())
    }

}