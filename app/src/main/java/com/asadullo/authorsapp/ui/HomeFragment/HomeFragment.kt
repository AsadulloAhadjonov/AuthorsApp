package com.asadullo.authorsapp.ui.HomeFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.findNavController
import com.asadullo.authorsapp.R
import com.asadullo.authorsapp.ui.HomeFragment.Adapters.FragmentCustom
import com.asadullo.authorsapp.databinding.FragmentHomeBinding
import com.asadullo.authorsapp.ui.HomeFragment.Adapters.CustomAdapter

class HomeFragment : Fragment() {
    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    private lateinit var customAdapter: CustomAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        customAdapter = CustomAdapter(childFragmentManager)
        customAdapter.addFragment(FragmentCustom(), "Mumtoz Adabiyot")
        customAdapter.addFragment(FragmentCustom(), "O'zbek Adabiyot")
        customAdapter.addFragment(FragmentCustom(), "Jahon Adabiyot")
        binding.myViewPager.adapter = customAdapter

        binding.tabL.setupWithViewPager(binding.myViewPager)

        binding.searchBtn.setOnClickListener {
            var bundle = Bundle()
            bundle.putInt("keySearch", 0)
            findNavController().navigate(R.id.searchFragment, bundle)
        }

        return binding.root
    }


}