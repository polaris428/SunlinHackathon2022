package com.example.sunlinhackathon2022.minigame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sunlinhackathon2022.R
import com.example.sunlinhackathon2022.databinding.ActivityTigerTouchMinigameBinding

class TigerTouchMinigameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTigerTouchMinigameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTigerTouchMinigameBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}