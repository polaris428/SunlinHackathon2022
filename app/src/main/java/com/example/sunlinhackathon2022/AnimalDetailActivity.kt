package com.example.sunlinhackathon2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sunlinhackathon2022.databinding.ActivityAnimalDetailBinding
import com.example.sunlinhackathon2022.databinding.ActivityMyPageBinding

class AnimalDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimalDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animalCode = intent.getStringExtra("animalCode")

    }
}