package com.asadullo.authorsapp

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.asadullo.authorsapp.Models.SaveAuthor
import com.asadullo.authorsapp.Room.Dbhelper
import com.asadullo.authorsapp.databinding.FragmentAboutAuthorBinding
import com.squareup.picasso.Picasso

class AboutAuthorFragment : Fragment() {
    private val binding by lazy { FragmentAboutAuthorBinding.inflate(layoutInflater) }
    private lateinit var dbhelper: Dbhelper
    var a = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dbhelper = Dbhelper.getIns(binding.root.context)

        val author = arguments?.getSerializable("data") as SaveAuthor

        binding.aboutAuthor.text = author.about
        binding.txtName.text = author.authorName
        binding.txtYear.text = "(${author.tugilgan} - ${author.vafot})"
        Picasso.get().load(author.imgLink).into(binding.authorImg)

        binding.cardView3.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }

        dbhelper.dao().get().forEach{
            if (author.idData == it.idData){
                binding.cardView4.setCardBackgroundColor(Color.GREEN)
            }
        }

        binding.cardView4.setOnClickListener {
            dbhelper.dao().get().forEach{
                if (author.idData == it.idData){
                    dbhelper.dao().delet(author)
                    binding.cardView4.setCardBackgroundColor(Color.WHITE)
                    a = 1
                }
            }
            if (a == 0){
                dbhelper.dao().add(author)
                binding.cardView4.setCardBackgroundColor(Color.GREEN)
                a == 1
            }else{
                dbhelper.dao().delet(author)
                Toast.makeText(context, "O'chirildi", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
}