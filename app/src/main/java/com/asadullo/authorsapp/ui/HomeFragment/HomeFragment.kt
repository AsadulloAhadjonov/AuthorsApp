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
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var item = arrayListOf<String>(
            "Mumtoz Adabiyoti",
            "O'zbek Adabiyoti",
            "Jahon Adabiyoti"
        )

        var customAdapter = CustomAdapter(childFragmentManager, item)
        customAdapter.addFragment(FragmentCustom(), "Mumtoz Adabiyot")
        customAdapter.addFragment(FragmentCustom(), "O'zbek Adabiyot")
        customAdapter.addFragment(FragmentCustom(), "Jahon Adabiyot")
        binding.myViewPager.adapter = customAdapter

        binding.tabL.setupWithViewPager(binding.myViewPager)

        binding.searchBtn.setOnClickListener {
            findNavController().navigate(R.id.searchFragment)
        }

        return binding.root
    }


}