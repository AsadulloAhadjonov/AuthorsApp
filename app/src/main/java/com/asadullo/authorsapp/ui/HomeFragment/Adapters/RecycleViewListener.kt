package com.asadullo.authorsapp.ui.HomeFragment.Adapters

import com.asadullo.authorsapp.Models.Author
import com.asadullo.authorsapp.Models.SaveAuthor


interface RecycleViewListener{
    fun onItemClicked(position: Int, author: SaveAuthor)
}