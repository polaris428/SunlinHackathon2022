package com.example.sunlinhackathon2022.minigame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.sunlinhackathon2022.AnimalDetailActivity
import com.example.sunlinhackathon2022.databinding.ActivityPandaGameBinding

class PandaGameActivity : AppCompatActivity() {
    lateinit var binding:ActivityPandaGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPandaGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        click(button = binding.OButton)
        click(button = binding.XButton)

    }
    private fun click(button: Button) {
        button.setOnClickListener {
            if (button.text == "O") {
                Toast.makeText(this,"정딥입니다", Toast.LENGTH_SHORT).show()
                val animalId = intent.getStringExtra("animalCode")
                val detailIntent = Intent(this, AnimalDetailActivity::class.java)
                detailIntent.putExtra("animalCode",animalId)
                startActivity(detailIntent)
                finish()

            } else {
                Toast.makeText(this,"다시 한번 시도해주세요", Toast.LENGTH_SHORT).show()
            }
        }

    }
}