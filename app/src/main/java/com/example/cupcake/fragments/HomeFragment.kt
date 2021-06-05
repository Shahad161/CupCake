package com.example.cupcake.fragments

import android.annotation.SuppressLint
import androidx.fragment.app.FragmentTransaction
import com.example.cupcake.R
import com.example.cupcake.data.Repository
import com.example.cupcake.databinding.FragmentHomeBinding
import com.example.cupcake.model.Model
import com.example.cupcake.ui.ModelAdapter
import com.example.cupcake.ui.ModelInteractionListner

class HomeFragment : BaseFragment<FragmentHomeBinding>(), ModelInteractionListner {
    private lateinit var passData: ModelInteractionListner

    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)
    @SuppressLint("UseRequireInsteadOfGet")

    override fun setUpViews() {
        // Open search fragment when you click on ImageButton in frontend
        passData = activity as ModelInteractionListner
        binding.btnToSearch.setOnClickListener {
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.fragment_container, SearchFragment()).addToBackStack(null).commit()
        }
    }
    override fun addCallBack() {
        val adapter = ModelAdapter(Repository.getCountryList().sortedBy { it.populationCity }.reversed(), this) // list of cities to adapter
        binding.recycleMain.adapter = adapter
    }


    override fun OnClickItem(model: Model) {
        passData.OnClickItem(model)
    }

}
