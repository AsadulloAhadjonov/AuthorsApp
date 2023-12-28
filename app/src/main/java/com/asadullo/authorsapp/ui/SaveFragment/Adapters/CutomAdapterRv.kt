package com.asadullo.authorsapp.ui.SaveFragment.Adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asadullo.authorsapp.Models.Author
import com.asadullo.authorsapp.Models.SaveAuthor
import com.asadullo.authorsapp.R
import com.asadullo.authorsapp.databinding.ItemRvBinding
import com.squareup.picasso.Picasso

class CutomAdapterRv(val list: ArrayList<SaveAuthor>, var unSave2: unSave):RecyclerView.Adapter<CutomAdapterRv.MyViewHolder>()  {
    private var recyclerView: RecycleViewListenerSave? = null
    inner class MyViewHolder(val binding: ItemRvBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(book: SaveAuthor, position: Int) {
            Picasso.get().
            load(book.imgLink).into(binding.imgItem)

            binding.authorName.text = book.authorName
            binding.authorYear.text = "(${book.tugilgan} - ${book.vafot})"

            binding.saveBtn.setCardBackgroundColor(Color.GREEN)

            binding.root.setOnClickListener {
                recyclerView?.onItemClicked(adapterPosition, book)
            }

            binding.saveBtn.setOnClickListener {
                unSave2.UNSAVE(position, book)
            }
        }
    }

    fun recyclerView(listener: RecycleViewListenerSave){
        recyclerView = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.item_rv,parent,false)
        return MyViewHolder(ItemRvBinding.bind(itemView))

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface unSave{
        fun UNSAVE(position: Int, author: SaveAuthor)
    }
}