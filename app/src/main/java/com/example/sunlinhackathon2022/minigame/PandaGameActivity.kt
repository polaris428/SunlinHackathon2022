package com.example.sunlinhackathon2022.minigame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.sunlinhackathon2022.AnimalDetailActivity
import com.example.sunlinhackathon2022.databinding.ActivityPandaGameBinding

class PandaGameActivity : AppCompatActivity() {
    lateinit var binding: ActivityPandaGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPandaGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        click(button = binding.OButton)
        click(button = binding.XButton)

    }

    private fun click(button: Button) {
        button.setOnClickListener {
            if (button.text == "X") {
                binding.examText.visibility = View.GONE
                binding.answerText.visibility = View.VISIBLE
                binding.btnLayout.visibility = View.GONE
                val handler = Handler()
                handler.postDelayed(Runnable {
                    val animalId = intent.getStringExtra("animalCode")
                    val detailIntent = Intent(this, AnimalDetailActivity::class.java)
                    detailIntent.putExtra("animalCode", animalId)
                    startActivity(detailIntent)
                    finish()
                }, 3000)

            } else {
                Toast.makeText(this, "다시 한번 생각해봐라, 판다", Toast.LENGTH_SHORT).show()
            }
        }

    }
}