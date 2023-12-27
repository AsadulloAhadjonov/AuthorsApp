package com.asadullo.authorsapp.ui.HomeFragment.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asadullo.authorsapp.Models.Author
import com.asadullo.authorsapp.R
import com.asadullo.authorsapp.databinding.ItemRvBinding
import com.squareup.picasso.Picasso

class CustomAdapterRecycleview(var list: List<Author>):RecyclerView.Adapter<CustomAdapterRecycleview.MyViewHolder>() {
    private var recyclerView: RecycleViewListener? = null
    inner class MyViewHolder(val binding: ItemRvBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Author) {
            Picasso.get().
            load(book.imgLink)
                .resize(150, 150)
                .error(android.R.drawable.stat_notify_error)
                .centerCrop().into(binding.imgItem)

            binding.authorName.text = book.authorName
            binding.authorYear.text = "(${book.tugilgan} - ${book.vafot})"

            binding.root.setOnClickListener {
                recyclerView?.onItemClicked(adapterPosition, book)
            }
        }
    }

    fun recyclerView(listener: RecycleViewListener){
        recyclerView = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.item_rv,parent,false)
        return MyViewHolder(ItemRvBinding.bind(itemView))

    }

    fun setFilteredList(list2:List<Author>){
         list = list2
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }
}