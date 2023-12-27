package com.asadullo.authorsapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginRight
import androidx.core.view.setMargins
import androidx.navigation.findNavController
import com.asadullo.authorsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    var selectTab = 1
    @SuppressLint("SetTextI18n", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.author.setOnClickListener {
            if (selectTab != 1){
                findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.homeFragment)
                binding.saveText.visibility = View.GONE
                binding.settingsTv.visibility = View.GONE
                binding.saveImg.setImageResource(R.drawable.unselect_save)
                binding.settingsImg.setImageResource(R.drawable.unselect_settings)
                binding.save.setBackgroundColor(getColor(android.R.color.transparent))
                binding.settings.setBackgroundColor(getColor(android.R.color.transparent))

//                val layoutParams = binding.author.layoutParams as ViewGroup.MarginLayoutParams
//                layoutParams.setMargins(0, 0, 53, 0)
//                binding.author.layoutParams = layoutParams
//
//                val layoutParams2 = binding.save.layoutParams as ViewGroup.MarginLayoutParams
//                layoutParams.setMargins(13, 0, 13,0)
//                binding.save.layoutParams = layoutParams2
//
//                val layoutParams3 = binding.settings.layoutParams as ViewGroup.MarginLayoutParams
//                layoutParams.setMargins(13, 0, 13,0)
//                binding.save.layoutParams = layoutParams3

                binding.authorImg.setImageResource(R.drawable.select_home)
                binding.auhorText.visibility  = View.VISIBLE
                binding.author.setBackgroundResource(R.drawable.bac_bottom_item)

                var scaleAnimation = ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f)
                scaleAnimation.duration = 500
                scaleAnimation.fillAfter = true

                binding.auhorText.startAnimation(scaleAnimation)


                selectTab = 1
            }
        }

        binding.save.setOnClickListener {
            if (selectTab != 2){
                findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.saveFragment)
                binding.auhorText.visibility = View.GONE
                binding.settingsTv.visibility = View.GONE
                binding.authorImg.setImageResource(R.drawable.unselect_home)
                binding.settingsImg.setImageResource(R.drawable.unselect_settings)
                binding.author.setBackgroundColor(getColor(android.R.color.transparent))
                binding.settings.setBackgroundColor(getColor(android.R.color.transparent))

                binding.saveImg.setImageResource(R.drawable.select_save)
                binding.saveText.visibility  = View.VISIBLE
                binding.save.setBackgroundResource(R.drawable.bac_bottom_item)

                val scaleAnimation = ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f)
                scaleAnimation.duration = 500
                scaleAnimation.fillAfter = true

                binding.saveText.startAnimation(scaleAnimation)


                selectTab = 2
            }
        }

        binding.settings.setOnClickListener {
            if (selectTab != 3){
                findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.settingsFragment)
                binding.saveText.visibility = View.GONE
                binding.auhorText.visibility = View.GONE
                binding.saveImg.setImageResource(R.drawable.unselect_save)
                binding.authorImg.setImageResource(R.drawable.unselect_home)
                binding.save.setBackgroundColor(getColor(android.R.color.transparent))
                binding.author.setBackgroundColor(getColor(android.R.color.transparent))

                binding.settingsImg.setImageResource(R.drawable.select_settings)
                binding.settingsTv.visibility  = View.VISIBLE
                binding.settings.setBackgroundResource(R.drawable.bac_bottom_item)

                var scaleAnimation = ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f)
                scaleAnimation.duration = 500
                scaleAnimation.fillAfter = true

                binding.settingsTv.startAnimation(scaleAnimation)


                selectTab = 3
            }
        }

    }

}