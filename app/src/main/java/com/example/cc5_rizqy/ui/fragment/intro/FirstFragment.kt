package com.example.cc5_rizqy.ui.fragment.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.example.cc5_rizqy.R

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)
        val nextFirstFragment = view.findViewById<ImageView>(R.id.iv_next_landing_page_1)
        nextFirstFragment.setOnClickListener {
            viewPager?.currentItem = 1
        }
        return view
    }
}