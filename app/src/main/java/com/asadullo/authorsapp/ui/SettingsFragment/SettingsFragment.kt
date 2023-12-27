package com.asadullo.authorsapp.ui.SettingsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.asadullo.authorsapp.R
import com.asadullo.authorsapp.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    private val binding by lazy { FragmentSettingsBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.add.setOnClickListener {
            findNavController().navigate(R.id.addFragment)
        }

        return binding.root
    }
}