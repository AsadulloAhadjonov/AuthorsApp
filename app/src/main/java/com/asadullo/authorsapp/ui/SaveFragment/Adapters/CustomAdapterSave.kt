package com.asadullo.authorsapp.ui.SaveFragment.Adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.asadullo.authorsapp.ui.HomeFragment.Adapters.FragmentCustom

class CustomAdapterSave(fragment: FragmentManager) : FragmentPagerAdapter(fragment) {
    override fun getCount(): Int {
        return 1
    }

    override fun getItem(position: Int): Fragment {
        return FragmentCustomSave()
    }
    private val fragmentList = mutableListOf<Fragment>()
    private val fragmentTitleList = mutableListOf<String>()

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList[position]
    }

}