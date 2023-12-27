package com.asadullo.authorsapp.ui.SaveFragment.Adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.asadullo.authorsapp.Models.Author
import com.asadullo.authorsapp.databinding.FragmentCustomBinding
import java.util.ArrayList

class FragmentCustomSave : Fragment() {
    private val binding by lazy { FragmentCustomBinding.inflate(layoutInflater) }
    private lateinit var arrayList: ArrayList<Author>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arrayList = ArrayList()
        binding.rv.layoutManager = GridLayoutManager(context, 2)
        f0()
        binding.rv.adapter = CutomAdapterRv(arrayList)


        return binding.root
    }

    fun f0(){
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
        arrayList.add(Author("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "O'tkir Hoshimov", "1923", "2019"))
    }
}