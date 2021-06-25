package com.example.cc5_rizqy.ui.activity.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cc5_rizqy.databinding.ActivityMainBinding
import com.example.cc5_rizqy.ui.activity.play.GameVsComActivity
import com.example.cc5_rizqy.ui.activity.play.GameVsPlayerActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var namePlayer: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        if (intent.getStringExtra("Name") != null) {
            namePlayer = intent.getStringExtra("Name")
            binding.tvPlayerVsPlayer.text = "$namePlayer vs Pemain"
        }

        if (intent.getStringExtra("Name") != null) {
            namePlayer = intent.getStringExtra("Name")
            binding.tvPlayerVsComputer.text = "$namePlayer vs Computer"
        }

        val snackBar = Snackbar.make(
            binding.root,
            "Selamat Datang $namePlayer", Snackbar.LENGTH_INDEFINITE,
        )

        snackBar.setAction("Tutup") {
            snackBar.dismiss()
        }
        snackBar.show()

        binding.ivPlayerVsPlayer.setOnClickListener {
            val intent = Intent(this@MainActivity, GameVsPlayerActivity::class.java)
            intent.putExtra("Name", namePlayer.toString())
            startActivity(intent)
        }

        binding.ivPlayerVsComputer.setOnClickListener {
            val intent = Intent(this@MainActivity, GameVsComActivity::class.java)
            intent.putExtra("Name", namePlayer.toString())
            startActivity(intent)
        }
    }
}