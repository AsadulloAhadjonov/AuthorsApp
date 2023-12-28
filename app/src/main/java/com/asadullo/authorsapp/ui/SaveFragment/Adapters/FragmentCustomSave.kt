package com.asadullo.authorsapp.ui.SaveFragment.Adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.asadullo.authorsapp.Models.Author
import com.asadullo.authorsapp.Models.SaveAuthor
import com.asadullo.authorsapp.R
import com.asadullo.authorsapp.Room.Dbhelper
import com.asadullo.authorsapp.databinding.FragmentCustomBinding
import com.asadullo.authorsapp.databinding.FragmentCustomSaveBinding
import com.google.firebase.firestore.FirebaseFirestore
import java.util.ArrayList

class FragmentCustomSave : Fragment(), CutomAdapterRv.unSave {
    private val binding by lazy { FragmentCustomSaveBinding.inflate(layoutInflater) }
    private lateinit var arrayList: ArrayList<SaveAuthor>
    private lateinit var firestore: FirebaseFirestore
    private lateinit var dbhelper: Dbhelper
    private lateinit var adapterRv: CutomAdapterRv
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arrayList = ArrayList()
        dbhelper = Dbhelper.getIns(binding.root.context)
        firestore = FirebaseFirestore.getInstance()
        binding.rv.layoutManager = GridLayoutManager(context, 2)
        binding.progress.visibility = View.VISIBLE
        adapterRv = CutomAdapterRv(arrayList, this)
        f0()
        binding.rv.adapter = adapterRv
        adapterRv.recyclerView(object : RecycleViewListenerSave{
            override fun onItemClicked(position: Int, author: SaveAuthor) {
                val bundle = Bundle()
                bundle.putSerializable("data", author)
                findNavController().navigate(R.id.aboutAuthorFragment, bundle)
            }
        })
        binding.progress.visibility = View.GONE



        return binding.root
    }

    fun f0() {
        adapterRv.list.clear()
        adapterRv.list.addAll(dbhelper.dao().get())
        adapterRv.notifyDataSetChanged()
    }

    override fun UNSAVE(position: Int, author: SaveAuthor) {
        dbhelper.dao().delet(author)
        arrayList.remove(author)
        adapterRv.notifyItemRemoved(position)
        adapterRv.notifyItemRangeChanged(position, arrayList.size)
    }
}