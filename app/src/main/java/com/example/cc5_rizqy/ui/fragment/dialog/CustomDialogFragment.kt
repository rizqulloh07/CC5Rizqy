package com.example.cc5_rizqy.ui.fragment.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.cc5_rizqy.R
import com.example.cc5_rizqy.databinding.FragmentCustomDialogBinding


class CustomDialogFragment (private val message :String) : DialogFragment() {

    private lateinit var binding: FragmentCustomDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dialog?.window?.setBackgroundDrawableResource(R.drawable.bg_dialog_rounded_white)
        super.onViewCreated(view, savedInstanceState)

        binding.tvWinner.text = message

        binding.btnReplay.setOnClickListener {
            dialog?.dismiss()
        }

        binding.btnReturn.setOnClickListener {
            activity!!.finish()
        }
    }
}
