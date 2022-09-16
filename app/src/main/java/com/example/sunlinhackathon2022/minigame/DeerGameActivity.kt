package com.example.sunlinhackathon2022.minigame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.sunlinhackathon2022.AnimalDetailActivity
import com.example.sunlinhackathon2022.R

class DeerGameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deer_game)
        findViewById<ImageView>(R.id.hurtImageView).setOnClickListener {
            val animalId = intent.getStringExtra("animalCode")
            val detailIntent = Intent(this, AnimalDetailActivity::class.java)
            detailIntent.putExtra("animalCode",animalId)
            startActivity(detailIntent)
            finish()
        }
    }
}