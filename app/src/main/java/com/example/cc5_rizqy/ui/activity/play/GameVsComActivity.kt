package com.example.cc5_rizqy.ui.activity.play

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.cc5_rizqy.R
import com.example.cc5_rizqy.data.constant.Constant
import com.example.cc5_rizqy.data.controller.Callback
import com.example.cc5_rizqy.data.controller.Controller
import com.example.cc5_rizqy.databinding.ActivityVsComBinding
import com.example.cc5_rizqy.ui.fragment.dialog.CustomDialogFragment

class GameVsComActivity : AppCompatActivity(), Callback {
    private lateinit var binding: ActivityVsComBinding
    private var namePlayer: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVsComBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val controller = Controller(this)
        val choose = mutableListOf("Batu", "Gunting", "Kertas")

        if (intent.getStringExtra("Name") != null) {
            namePlayer = intent.getStringExtra("Name")
            binding.tvPlayerName.text = namePlayer
        }

        binding.ivBtnRockPlayer.setOnClickListener {
            binding.ivBtnRockPlayer.setBackgroundColor(ContextCompat.getColor(this, R.color.bg_choice))
            val computer = choose.random()
            controller.rules("Batu", computer)
            when (computer) {
                "Gunting" -> {
                    binding.ivScissorComputer.setBackgroundColor(
                        ContextCompat.getColor(
                            this,
                            R.color.bg_choice
                        )
                    )
                    Toast.makeText(this, "CPU Memilih Gunting", Toast.LENGTH_LONG).show()
                }
                "Batu" -> {
                    binding.ivRockComputer.setBackgroundColor(
                        ContextCompat.getColor(
                            this,
                            R.color.bg_choice
                        )
                    )
                    Toast.makeText(this, "CPU Memilih batu", Toast.LENGTH_LONG).show()
                }
                else -> {
                    binding.ivPaperComputer.setBackgroundColor(
                        ContextCompat.getColor(
                            this,
                            R.color.bg_choice
                        )
                    )
                    Toast.makeText(this, "CPU Memilih Kertas", Toast.LENGTH_LONG).show()
                }
            }
            binding.ivBtnRockPlayer.isEnabled = false
            binding.ivBtnScissorPlayer.isEnabled = false
            binding.ivBtnPaperPlayer.isEnabled = false
        }

        binding.ivBtnPaperPlayer.setOnClickListener {

            binding.ivBtnPaperPlayer.setBackgroundColor(ContextCompat.getColor(this, R.color.bg_choice))
            val computer = choose.random()
            controller.rules("Kertas", computer)
            when (computer) {
                "Gunting" -> {
                    binding.ivScissorComputer.setBackgroundColor(
                        ContextCompat.getColor(
                            this,
                            R.color.bg_choice
                        )
                    )
                    Toast.makeText(this, "CPU Memilih Gunting", Toast.LENGTH_LONG).show()
                }
                "Batu" -> {
                    binding.ivRockComputer.setBackgroundColor(
                        ContextCompat.getColor(
                            this,
                            R.color.bg_choice
                        )
                    )
                    Toast.makeText(this, "CPU Memilih batu", Toast.LENGTH_LONG).show()
                }
                else -> {
                    binding.ivPaperComputer.setBackgroundColor(
                        ContextCompat.getColor(
                            this,
                            R.color.bg_choice
                        )
                    )
                    Toast.makeText(this, "CPU Memilih Kertas", Toast.LENGTH_LONG).show()
                }
            }
            binding.ivBtnRockPlayer.isEnabled = false
            binding.ivBtnScissorPlayer.isEnabled = false
            binding.ivBtnPaperPlayer.isEnabled = false
        }

        binding.ivBtnScissorPlayer.setOnClickListener {

            binding.ivBtnScissorPlayer.setBackgroundColor(ContextCompat.getColor(this, R.color.bg_choice))
            val computer = choose.random()
            controller.rules("Gunting", computer)
            when (computer) {
                "Gunting" -> {
                    binding.ivScissorComputer.setBackgroundColor(
                        ContextCompat.getColor(
                            this,
                            R.color.bg_choice
                        )
                    )
                    Toast.makeText(this, "CPU Memilih Gunting", Toast.LENGTH_LONG).show()
                }
                "Batu" -> {
                    binding.ivRockComputer.setBackgroundColor(
                        ContextCompat.getColor(
                            this,
                            R.color.bg_choice
                        )
                    )
                    Toast.makeText(this, "CPU Memilih batu", Toast.LENGTH_LONG).show()
                }
                else -> {
                    binding.ivPaperComputer.setBackgroundColor(
                        ContextCompat.getColor(
                            this,
                            R.color.bg_choice
                        )
                    )
                    Toast.makeText(this, "CPU Memilih Kertas", Toast.LENGTH_LONG).show()
                }
            }
            binding.ivBtnRockPlayer.isEnabled = false
            binding.ivBtnScissorPlayer.isEnabled = false
            binding.ivBtnPaperPlayer.isEnabled = false
        }

        binding.ivBtnRefresh.setOnClickListener {
            binding.ivStatus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_vs))
            binding.ivBtnRockPlayer.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent))
            binding.ivBtnScissorPlayer.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent))
            binding.ivBtnPaperPlayer.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent))
            binding.ivScissorComputer.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent))
            binding.ivPaperComputer.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent))
            binding.ivRockComputer.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent))
            binding.ivBtnRockPlayer.isEnabled = true
            binding.ivBtnScissorPlayer.isEnabled = true
            binding.ivBtnPaperPlayer.isEnabled = true

        }
        Glide.with(this)
            .load(Constant.URL_SPLASH_SCREEN)
            .into(binding.ivTitle)

        binding.ivBtnClose.setOnClickListener {
            finish()
        }
    }

    override fun sendStatus(status: String) {
        namePlayer = intent.getStringExtra("Name")
        when {
            status.contains("1") -> {
                CustomDialogFragment("$namePlayer\nMENANG!").show(supportFragmentManager,null)
            }

            status.contains("2") -> {
                CustomDialogFragment("COM\n Menang!").show(supportFragmentManager, null)
            }

            status.contains("w") -> {
                CustomDialogFragment("SERI!").show(supportFragmentManager, null)
            }
        }
    }
}