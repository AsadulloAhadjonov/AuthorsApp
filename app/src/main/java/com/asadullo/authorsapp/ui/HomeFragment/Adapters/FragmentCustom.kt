package com.asadullo.authorsapp.ui.HomeFragment.Adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.asadullo.authorsapp.Models.Author
import com.asadullo.authorsapp.R
import com.asadullo.authorsapp.databinding.FragmentCustomBinding
import com.google.firebase.firestore.FirebaseFirestore
import java.util.ArrayList

class FragmentCustom : Fragment() {
    private val binding by lazy { FragmentCustomBinding.inflate(layoutInflater) }
    private lateinit var arrayList: ArrayList<Author>
    private lateinit var firebaseFirestore: FirebaseFirestore
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        firebaseFirestore = FirebaseFirestore.getInstance()
        arrayList = ArrayList()
        binding.rv.layoutManager = GridLayoutManager(context, 2)
        when(arguments?.getInt("key")){
            0->{
                f0()
                var adapter = CustomAdapterRecycleview(arrayList)
                binding.rv.adapter = adapter
                adapter.recyclerView(object : RecycleViewListener{
                    override fun onItemClicked(position: Int, author: Author) {
                        val bundle = Bundle()
                        bundle.putSerializable("data", author)
                        findNavController().navigate(R.id.aboutAuthorFragment, bundle)
                    }
                })
            }
            1->{
                f1()
                val adapterRecycleview = CustomAdapterRecycleview(arrayList)
                binding.rv.adapter = adapterRecycleview
                adapterRecycleview.recyclerView(object : RecycleViewListener{
                    override fun onItemClicked(position: Int, author: Author) {
                        val bundle = Bundle()
                        bundle.putSerializable("data", author)
                        findNavController().navigate(R.id.aboutAuthorFragment, bundle)
                    }
                })
            }
            2->{
                f2()
                var adapterRecycleview = CustomAdapterRecycleview(arrayList)
                binding.rv.adapter = adapterRecycleview
                adapterRecycleview.recyclerView(object : RecycleViewListener{
                    override fun onItemClicked(position: Int, author: Author) {
                        val bundle = Bundle()
                        bundle.putSerializable("data", author)
                        findNavController().navigate(R.id.aboutAuthorFragment, bundle)
                    }
                })
            }
        }


        return binding.root
    }

    fun f0(){
        firebaseFirestore.collection("authors")
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful){
                    val result = it.result
                    result?.forEach{
                        val author = it.toObject(Author::class.java)
                        if (author.type == "Mumtoz") {
                            arrayList.add(author)
                        }

                    }
                }
            }
    }

    fun f1(){
        firebaseFirestore.collection("authors")
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful){
                    val result = it.result
                    result?.forEach {
                        val author = it.toObject(Author::class.java)
                        if (author.type == "O'zbek"){
                            Toast.makeText(context, "${author.type}", Toast.LENGTH_SHORT).show()
                            arrayList.add(author)
                        }
                    }
                }
            }
    }

    fun f2(){
        firebaseFirestore.collection("authors")
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful){
                    val result = it.result
                    result?.forEach{
                        val author = it.toObject(Author::class.java)
                        if (author.type == "Jahon") {
                            arrayList.add(author)
                        }
                    }
                }
            }
    }

}