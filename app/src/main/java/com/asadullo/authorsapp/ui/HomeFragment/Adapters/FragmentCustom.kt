package com.asadullo.authorsapp.ui.HomeFragment.Adapters

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.asadullo.authorsapp.Models.Author
import com.asadullo.authorsapp.Models.SaveAuthor
import com.asadullo.authorsapp.R
import com.asadullo.authorsapp.Room.Dbhelper
import com.asadullo.authorsapp.databinding.FragmentCustomBinding
import com.google.firebase.firestore.FirebaseFirestore
import java.util.ArrayList

class FragmentCustom : Fragment(), CustomAdapterRecycleview.saveFun {
    private val binding by lazy { FragmentCustomBinding.inflate(layoutInflater) }
    private lateinit var arrayList: ArrayList<SaveAuthor>
    private lateinit var firebaseFirestore: FirebaseFirestore
    private lateinit var dbhelper: Dbhelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        firebaseFirestore = FirebaseFirestore.getInstance()
        arrayList = ArrayList()
        dbhelper = Dbhelper.getIns(binding.root.context)
        binding.rv.layoutManager = GridLayoutManager(binding.root.context, 2)
        when(arguments?.getInt("key")){
            0->{
                binding.progress.visibility = View.VISIBLE
                f0()
                var adapter = CustomAdapterRecycleview(arrayList, this)
                binding.rv.adapter = adapter
                adapter.recyclerView(object : RecycleViewListener{
                    override fun onItemClicked(position: Int, author: SaveAuthor) {
                        val bundle = Bundle()
                        bundle.putSerializable("data", author)
                        findNavController().navigate(R.id.aboutAuthorFragment, bundle)
                    }
                })
                binding.progress.visibility = View.GONE
            }
            1->{
                binding.progress.visibility = View.VISIBLE
                f1()
                val adapterRecycleview = CustomAdapterRecycleview(arrayList, this)
                binding.rv.adapter = adapterRecycleview
                adapterRecycleview.recyclerView(object : RecycleViewListener{
                    override fun onItemClicked(position: Int, author: SaveAuthor) {
                        val bundle = Bundle()
                        bundle.putSerializable("data", author)
                        findNavController().navigate(R.id.aboutAuthorFragment, bundle)
                    }
                })
                binding.progress.visibility = View.GONE
            }
            2->{
                binding.progress.visibility = View.VISIBLE
                f2()
                var adapterRecycleview = CustomAdapterRecycleview(arrayList, this)
                binding.rv.adapter = adapterRecycleview
                adapterRecycleview.recyclerView(object : RecycleViewListener{
                    override fun onItemClicked(position: Int, author: SaveAuthor) {
                        val bundle = Bundle()
                        bundle.putSerializable("data", author)
                        findNavController().navigate(R.id.aboutAuthorFragment, bundle)
                    }
                })
                binding.progress.visibility = View.GONE
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
                            arrayList.add(SaveAuthor(author.imgLink, author.authorName, author.tugilgan, author.vafot, author.type, author.about, it.id))
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
                            arrayList.add(SaveAuthor(author.imgLink, author.authorName, author.tugilgan, author.vafot, author.type, author.about, it.id))
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
                            arrayList.add(SaveAuthor(author.imgLink, author.authorName, author.tugilgan, author.vafot, author.type, author.about, it.id))
                        }
                    }
                }
            }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun save(author: SaveAuthor, position: Int) {
        if (author.idData == arrayList[position].idData){
            for(i in 0 .. dbhelper.dao().get().size){
                if (author.idData == dbhelper.dao().get()[i].idData){
                    Toast.makeText(context, "${dbhelper.dao().get()[i].authorName} - bu adib qo'shilgan", Toast.LENGTH_SHORT).show()
                    break
                }else{
                    dbhelper.dao().add(author)
                    Toast.makeText(context, "Saqlandi", Toast.LENGTH_SHORT).show()
                    break
                }
            }
        }else{
            dbhelper.dao().add(author)
            Toast.makeText(context, "Saqlandi", Toast.LENGTH_SHORT).show()
        }
    }

}