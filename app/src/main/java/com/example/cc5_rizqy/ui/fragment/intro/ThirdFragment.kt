package com.example.cc5_rizqy.ui.fragment.intro

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cc5_rizqy.databinding.FragmentThirdBinding
import com.example.cc5_rizqy.ui.activity.main.MainActivity

class ThirdFragment : Fragment() {
    private lateinit var binding: FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etInputPlayerName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.isNotEmpty() == true) {
                    binding.ivNextLandingPage3.visibility = View.VISIBLE
                } else {
                    binding.ivNextLandingPage3.visibility = View.GONE
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        binding.ivNextLandingPage3.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            intent.putExtra("Name", binding.etInputPlayerName.text.toString())
            activity!!.startActivity(intent)
        }
    }
}