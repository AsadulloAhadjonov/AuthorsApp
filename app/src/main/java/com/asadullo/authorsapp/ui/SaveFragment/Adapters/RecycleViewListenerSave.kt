package com.asadullo.authorsapp.ui.SaveFragment.Adapters

import com.asadullo.authorsapp.Models.Author


interface RecycleViewListenerSave{
    fun onItemClicked(position: Int, author: Author)
}