package com.asadullo.authorsapp.ui.AddFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.asadullo.authorsapp.Models.Author
import com.asadullo.authorsapp.R
import com.asadullo.authorsapp.databinding.FragmentAddBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


class AddFragment : Fragment() {
    var TAG = "AddFragment"
    private val binding by lazy { FragmentAddBinding.inflate(layoutInflater) }
    private lateinit var fireBaseStorage:FirebaseStorage
    private lateinit var reference: StorageReference
    private lateinit var firebaseFirestore:FirebaseFirestore
    private var img:String? = null
    private var type:String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fireBaseStorage = FirebaseStorage.getInstance()
        firebaseFirestore = FirebaseFirestore.getInstance()
        reference = fireBaseStorage.getReference("author_images")

        binding.addImg.setOnClickListener {
            getImage.launch("image/*")
        }

        val spinnerAdapter =ArrayAdapter.createFromResource(binding.root.context, R.array.array, android.R.layout.simple_spinner_item)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.typeSpinner.adapter = spinnerAdapter
        binding.typeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                type = p0?.getItemAtPosition(p2).toString()
                binding.typeSpinner.setSelection(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        binding.save.setOnClickListener {
            val name = binding.authorName.text.toString()
            val brith = binding.authorYearOfBirth.text.toString()
            val death = binding.authorYearOfDeath.text.toString()
            val about = binding.authorAbout.text.toString()
            if (img == null || type == null || name == "" || brith == "" || death == "" || about == ""){
                Toast.makeText(context, "To'liq to'ldiring\nYoki rasim joylanganligiga to'liq ishonch hosil qiling", Toast.LENGTH_SHORT).show()
            }else {
                val author = Author(img, name, brith, death, type, about)
                firebaseFirestore.collection("authors")
                    .add(author)
                    .addOnSuccessListener {
                        binding.authorName.text.clear()
                        binding.authorAbout.text.clear()
                        binding.authorYearOfBirth.text.clear()
                        binding.authorYearOfDeath.text.clear()
                        Toast.makeText(context, "${it.id} Yuklandi", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(context, "${it.message}", Toast.LENGTH_SHORT).show()
                        Toast.makeText(context, "Xatolik", Toast.LENGTH_SHORT).show()
                    }
            }
        }

        return binding.root
    }

    private val getImage = registerForActivityResult(ActivityResultContracts.GetContent()){
        if (it != null){
            binding.imgAuthor.setImageURI(it)
            val m = System.currentTimeMillis()
            val uploadTask = reference.child(m.toString()).putFile(it)

            uploadTask.addOnSuccessListener {
                if (it.task.isSuccessful){
                    val downloadUrl = it.metadata?.reference?.downloadUrl
                    downloadUrl?.addOnSuccessListener {
                        img = it.toString()
                    }
                }
            }.addOnFailureListener{
                Toast.makeText(context, "Xatolik", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "${it.message}", Toast.LENGTH_SHORT).show()
                Log.d(TAG, ":${it.message}")
            }
        }
    }

}