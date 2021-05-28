package com.example.cupcake.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

@Suppress("UNCHECKED_CAST")
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {


    //This is initialvar of log
    abstract val LOG_TAG: String

    //This is initialvar of binding In flater
    abstract val bindingInflater: (LayoutInflater) -> VB
    private var _binding: ViewBinding? = null
    protected val binding
        get() = _binding as VB?


    //This is onCreate function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater(layoutInflater)
        setContentView(requireNotNull(_binding).root)

        setup()
        addCallbacks()

    }


    //basic function in this project
    protected abstract fun setup()
    protected abstract fun addCallbacks()

    //This function of log
    protected fun log(value: Any) {
        Log.v(LOG_TAG, value.toString())
    }
}
