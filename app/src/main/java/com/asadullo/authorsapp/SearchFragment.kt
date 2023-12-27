package com.asadullo.authorsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.asadullo.authorsapp.Models.Author
import com.asadullo.authorsapp.databinding.FragmentSearchBinding
import com.asadullo.authorsapp.ui.HomeFragment.Adapters.CustomAdapterRecycleview
import com.google.firebase.firestore.FirebaseFirestore

class SearchFragment : Fragment() {
    private val binding by lazy { FragmentSearchBinding.inflate(layoutInflater) }
    private lateinit var arrayList: ArrayList<Author>
    private lateinit var adapterRecycleview: CustomAdapterRecycleview
    private lateinit var firestore: FirebaseFirestore
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arrayList = ArrayList()
        firestore = FirebaseFirestore.getInstance()
        f0()
        adapterRecycleview = CustomAdapterRecycleview(arrayList)
        binding.rv.layoutManager = GridLayoutManager(context, 2)
        binding.rv.adapter = adapterRecycleview

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
            val filterList = ArrayList<Author>()
            for (i in arrayList){
                if (i.authorName!!.lowercase().contains(query.lowercase())){
                    filterList.add(i)
                }
            }

            if (filterList.isEmpty()){
                Toast.makeText(context, "Ushbu adib yo'q", Toast.LENGTH_SHORT).show()
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
                        arrayList.add(author)
                    }
                }
            }
    }
}