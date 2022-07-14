package com.example.sunlinhackathon2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sunlinhackathon2022.account.SignUpActivity
import com.example.sunlinhackathon2022.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    lateinit var  binding:ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.signInButton.setOnClickListener {

        }
        binding.signUpButton.setOnClickListener {
            var intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }

    }
}