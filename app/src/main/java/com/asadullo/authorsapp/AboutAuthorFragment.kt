package com.asadullo.authorsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.asadullo.authorsapp.Models.Author
import com.asadullo.authorsapp.databinding.FragmentAboutAuthorBinding
import com.squareup.picasso.Picasso

class AboutAuthorFragment : Fragment() {
    private val binding by lazy { FragmentAboutAuthorBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var author = arguments?.getSerializable("data") as Author

        binding.aboutAuthor.text = author.about
        binding.txtName.text = author.authorName
        binding.txtYear.text = "(${author.tugilgan} - ${author.vafot})"
        Picasso.get().load(author.imgLink).into(binding.authorImg)

        binding.cardView3.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }

        return binding.root
    }
}