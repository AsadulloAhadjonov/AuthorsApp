package com.asadullo.authorsapp.ui.HomeFragment.Adapters

import com.asadullo.authorsapp.Models.Author


interface RecycleViewListener{
    fun onItemClicked(position: Int, author: Author)
}