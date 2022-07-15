package com.example.sunlinhackathon2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sunlinhackathon2022.databinding.ActivityMyPageBinding

class MyPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener{
            finish()
        }



    }
}