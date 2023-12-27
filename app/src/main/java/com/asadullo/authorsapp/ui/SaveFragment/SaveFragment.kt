package com.asadullo.authorsapp.ui.SaveFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.asadullo.authorsapp.R
import com.asadullo.authorsapp.databinding.FragmentSaveBinding
import com.asadullo.authorsapp.ui.SaveFragment.Adapters.CustomAdapterSave


class SaveFragment : Fragment() {
    private val binding by lazy { FragmentSaveBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val adapter = CustomAdapterSave(childFragmentManager)
        binding.myViewPager.adapter = adapter

        return binding.root
    }

}