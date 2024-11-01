package com.example.hookingfish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.hookingfish.view.LoginActivity

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        Handler(Looper.myLooper()!!).postDelayed({

            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 3000)

    }

}