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
import com.example.cc5_rizqy.databinding.ActivityVsPlayerBinding
import com.example.cc5_rizqy.ui.fragment.dialog.CustomDialogFragment

class GameVsPlayerActivity : AppCompatActivity(), Callback {
    private lateinit var binding: ActivityVsPlayerBinding
    private var namePlayer: String? = null
    private lateinit var playerOneChoose: String
    private lateinit var playerTwoChoose: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVsPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        playerOneChoose = toString()
        playerTwoChoose = toString()
        val controller = Controller(this)

        if (intent.getStringExtra("Name") != null) {
            namePlayer = intent.getStringExtra("Name")
            binding.tvPlayerName.text = namePlayer
        }

        binding.ivBtnRockPlayer.setOnClickListener {
            playerOneChoose = "Batu"
            binding.ivBtnRockPlayer.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.bg_choice
                )
            )
            binding.ivBtnRockPlayer.isEnabled = false
            binding.ivBtnScissorPlayer.isEnabled = false
            binding.ivBtnPaperPlayer.isEnabled = false
            binding.ivRockComputer.isEnabled = true
            binding.ivScissorComputer.isEnabled = true
            binding.ivPaperComputer.isEnabled = true
        }

        binding.ivBtnPaperPlayer.setOnClickListener {
            playerOneChoose = "Kertas"
            binding.ivBtnPaperPlayer.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.bg_choice
                )
            )
            binding.ivBtnRockPlayer.isEnabled = false
            binding.ivBtnScissorPlayer.isEnabled = false
            binding.ivBtnPaperPlayer.isEnabled = false
            binding.ivRockComputer.isEnabled = true
            binding.ivScissorComputer.isEnabled = true
            binding.ivPaperComputer.isEnabled = true
        }

        binding.ivBtnScissorPlayer.setOnClickListener {
            playerOneChoose = "Gunting"
            binding.ivBtnScissorPlayer.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.bg_choice
                )
            )
            binding.ivBtnRockPlayer.isEnabled = false
            binding.ivBtnScissorPlayer.isEnabled = false
            binding.ivBtnPaperPlayer.isEnabled = false
            binding.ivRockComputer.isEnabled = true
            binding.ivScissorComputer.isEnabled = true
            binding.ivPaperComputer.isEnabled = true
        }

        binding.ivScissorComputer.setOnClickListener {
            playerTwoChoose = "Gunting"
            binding.ivScissorComputer.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.bg_choice
                )
            )
            Toast.makeText(
                this,
                "Player 2 memilih Gunting",
                Toast.LENGTH_LONG
            ).show()
            controller.rules(playerOneChoose, playerTwoChoose)
        }

        binding.ivRockComputer.setOnClickListener {
            playerTwoChoose = "Batu"
            binding.ivRockComputer.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.bg_choice
                )
            )
            Toast.makeText(
                this,
                "Player 2 memilih Batu",
                Toast.LENGTH_LONG
            ).show()
            controller.rules(playerOneChoose, playerTwoChoose)
        }

        binding.ivPaperComputer.setOnClickListener {
            playerTwoChoose = "Kertas"
            binding.ivPaperComputer.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.bg_choice
                )
            )
            Toast.makeText(
                this,
                "Player 2 memilih Kertas",
                Toast.LENGTH_LONG
            ).show()
            controller.rules(playerOneChoose, playerTwoChoose)
        }

        binding.ivBtnRefresh.setOnClickListener {
            binding.ivStatus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_vs))
            binding.ivBtnRockPlayer.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.transparent
                )
            )
            binding.ivBtnScissorPlayer.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.transparent
                )
            )
            binding.ivBtnPaperPlayer.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.transparent
                )
            )
            binding.ivRockComputer.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.transparent
                )
            )
            binding.ivScissorComputer.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.transparent
                )
            )
            binding.ivPaperComputer.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.transparent
                )
            )
            binding.ivBtnRockPlayer.isEnabled = true
            binding.ivBtnScissorPlayer.isEnabled = true
            binding.ivBtnPaperPlayer.isEnabled = true
            binding.ivRockComputer.isEnabled = true
            binding.ivScissorComputer.isEnabled = true
            binding.ivPaperComputer.isEnabled = true

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
                CustomDialogFragment("$namePlayer\nMENANG!").show(supportFragmentManager, null)
            }

            status.contains("2") -> {
                CustomDialogFragment("Player 2\n Menang!").show(supportFragmentManager, null)
            }

            status.contains("w") -> {
                CustomDialogFragment("SERI!").show(supportFragmentManager, null)
            }
        }
    }
}
