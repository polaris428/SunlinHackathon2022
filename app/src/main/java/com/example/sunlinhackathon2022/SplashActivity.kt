package com.example.sunlinhackathon2022

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.sunlinhackathon2022.databinding.ActivityMainBinding
import com.example.sunlinhackathon2022.databinding.ActivitySplashBinding
import com.google.zxing.integration.android.IntentIntegrator
import java.util.*

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val random = Random()

        if(random.nextInt(1)==1){
            binding.constraintLayout.setBackgroundResource(R.drawable.oceanback)
        }else{

        }
        val handler = Handler()
        handler.postDelayed(Runnable {
            val intent=Intent(this,WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)

    }
}