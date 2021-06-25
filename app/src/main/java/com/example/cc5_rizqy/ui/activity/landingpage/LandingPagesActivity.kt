package com.example.cc5_rizqy.ui.activity.landingpage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cc5_rizqy.data.fragmentadapter.MyAdapter
import com.example.cc5_rizqy.databinding.ActivityLandingPagesBinding
import com.example.cc5_rizqy.ui.fragment.intro.FirstFragment
import com.example.cc5_rizqy.ui.fragment.intro.SecondFragment
import com.example.cc5_rizqy.ui.fragment.intro.ThirdFragment

class LandingPagesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLandingPagesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingPagesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val dataFragment = mutableListOf(FirstFragment(), SecondFragment(), ThirdFragment())

        val adapter = MyAdapter(this)
        adapter.setData(dataFragment)

        val viewPager = binding.viewPager
        viewPager.adapter = adapter

        val springDotsIndicator = binding.springDotsIndicator
        springDotsIndicator.setViewPager2(viewPager)

    }
}