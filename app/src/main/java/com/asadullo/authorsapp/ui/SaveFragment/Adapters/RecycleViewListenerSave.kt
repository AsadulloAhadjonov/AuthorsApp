package com.asadullo.authorsapp.ui.SaveFragment.Adapters

import com.asadullo.authorsapp.Models.Author
import com.asadullo.authorsapp.Models.SaveAuthor


interface RecycleViewListenerSave{
    fun onItemClicked(position: Int, author: SaveAuthor)
}