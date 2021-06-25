package com.example.cc5_rizqy.ui.activity.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.cc5_rizqy.data.constant.Constant
import com.example.cc5_rizqy.databinding.ActivitySplashScreenBinding
import com.example.cc5_rizqy.ui.activity.landingpage.LandingPagesActivity

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        Glide.with(this)
            .load(Constant.URL_SPLASH_SCREEN)
            .into(binding.ivTitle)

        val toLandingPagesActivity = Intent(this, LandingPagesActivity::class.java)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(
            { this.finish()
                startActivity(toLandingPagesActivity)
            }, 3000
        )
    }
}
