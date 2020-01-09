package com.example.mybaseapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mybaseapp.R

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT=3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        init()
    }

    private fun init() {
        android.os.Handler().postDelayed(
            {
                val next= Intent(this@SplashActivity, LoginActivity::class.java)
                startActivity(next)
                finish()
            }, SPLASH_TIME_OUT)

    }


}