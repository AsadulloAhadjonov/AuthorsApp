package com.asadullo.authorsapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.asadullo.authorsapp.Models.Author
import com.asadullo.authorsapp.Models.SaveAuthor
import com.asadullo.authorsapp.Room.Dbhelper
import com.asadullo.authorsapp.databinding.FragmentSearchBinding
import com.asadullo.authorsapp.ui.HomeFragment.Adapters.CustomAdapterRecycleview
import com.asadullo.authorsapp.ui.HomeFragment.Adapters.RecycleViewListener
import com.google.firebase.firestore.FirebaseFirestore

class SearchFragment : Fragment(), CustomAdapterRecycleview.saveFun {
    private val binding by lazy { FragmentSearchBinding.inflate(layoutInflater) }
    private lateinit var arrayList: ArrayList<SaveAuthor>
    private lateinit var adapterRecycleview: CustomAdapterRecycleview
    private lateinit var firestore: FirebaseFirestore
    private lateinit var dbhelper: Dbhelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arrayList = ArrayList()
        firestore = FirebaseFirestore.getInstance()
        dbhelper = Dbhelper.getIns(binding.root.context)
        var key = arguments?.getInt("keySearch")
        binding.rv.layoutManager = GridLayoutManager(context, 2)
        when(key){
            0->{
                f0()
                adapterRecycleview = CustomAdapterRecycleview(arrayList, this)
                adapterRecycleview.recyclerView(object : RecycleViewListener{
                    override fun onItemClicked(position: Int, author: SaveAuthor) {
                        val bundle = Bundle()
                        bundle.putSerializable("data", author)
                        findNavController().navigate(R.id.aboutAuthorFragment, bundle)
                    }
                })
                binding.rv.adapter = adapterRecycleview
            }
            1->{
                dbSerach()
                adapterRecycleview = CustomAdapterRecycleview(arrayList, this)
                adapterRecycleview.recyclerView(object : RecycleViewListener{
                    override fun onItemClicked(position: Int, author: SaveAuthor) {
                        val bundle = Bundle()
                        bundle.putSerializable("data", author)
                        findNavController().navigate(R.id.aboutAuthorFragment, bundle)
                    }
                })
                binding.rv.adapter = adapterRecycleview
            }
        }


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                filter(p0!!)
                return true
            }
        })

        return binding.root
    }

    fun filter(query:String){
        if (query != null){
            val filterList = ArrayList<SaveAuthor>()
            for (i in arrayList){
                if (i.authorName!!.lowercase().contains(query.lowercase())){
                    filterList.add(i)
                }
            }

            if (filterList.isEmpty()){
                adapterRecycleview.list.clear()
                binding.rv.adapter = adapterRecycleview
            }else{
                adapterRecycleview.setFilteredList(filterList)
            }
        }
    }

    fun f0(){
        firestore.collection("authors")
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful){
                    val result = it.result
                    result?.forEach {
                        val author = it.toObject(Author::class.java)
                        arrayList.add(SaveAuthor(author.imgLink, author.authorName, author.tugilgan, author.vafot, author.type, author.about, it.id))
                    }
                }
            }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun dbSerach(){
        arrayList.clear()
        arrayList.addAll(dbhelper.dao().get())
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun save(author: SaveAuthor, position: Int) {
        if (author.idData == arrayList[position].idData){
            Toast.makeText(context, "BU ADIB SAQLAB QO'YILGAN", Toast.LENGTH_SHORT).show()
        }else{
            dbhelper.dao().add(author)
            Toast.makeText(context, "Saqlandi", Toast.LENGTH_SHORT).show()
        }
    }
}