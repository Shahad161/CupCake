package com.example.cupcake.fragments

import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.example.cupcake.R
import com.example.cupcake.data.Repository
import com.example.cupcake.databinding.FragmentHomeBinding
import com.example.cupcake.model.Model
import com.example.cupcake.ui.MainActivity
import com.example.cupcake.ui.ModelInteractionListner

class HomeFragment : BaseFragment<FragmentHomeBinding>(), ModelInteractionListner {
    private lateinit var passData: ModelInteractionListner
    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)
    override fun setUpViews() {
        // Open search fragment when you click on ImageButton in frontend
        passData = activity as ModelInteractionListner
        binding.btnToSearch.setOnClickListener {
            val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.fragment_container, SearchFragment()).addToBackStack(null).commit()
        }
    }
    override fun addCallBack() {
        getCitiesInfo()
        val adapter = ModelAdapter(Repository.countryList, this) // list of cities to adapter
        binding.recycleMain.adapter = adapter
    }

//call function to get Info from Csv file
    private fun getCitiesInfo(){
        (activity as MainActivity).parseFile()
    }

    override fun OnClickItem(model: Model) {
        passData.OnClickItem(model)
    }


    override fun OnClickCountry(name: String) {
        Toast.makeText(context, name, Toast.LENGTH_SHORT).show()
    }
}
