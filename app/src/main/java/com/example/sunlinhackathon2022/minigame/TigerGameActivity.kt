package com.example.sunlinhackathon2022.minigame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.example.sunlinhackathon2022.AnimalDetailActivity
import com.example.sunlinhackathon2022.databinding.ActivityTigerGameBinding

class TigerGameActivity : AppCompatActivity() {
    lateinit var binding: ActivityTigerGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTigerGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        click(button = binding.OButton)
        click(button = binding.XButton)

    }
    private fun click(button: Button) {
        button.setOnClickListener {
            if (button.text == "O") {
                Toast.makeText(this,"정딥입니다",Toast.LENGTH_SHORT).show()
                val animalId = intent.getStringExtra("animalCode")
                val detailIntent = Intent(this, AnimalDetailActivity::class.java)
                detailIntent.putExtra("animalCode",animalId)
                startActivity(detailIntent)
                finish()

            } else {
                Toast.makeText(this,"다시 한번 시도해주세요",Toast.LENGTH_SHORT).show()
            }
        }

    }
}