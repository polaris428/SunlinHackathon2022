package com.example.sunlinhackathon2022.minigame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
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
                binding.tv1.visibility = View.GONE
                binding.tv2.visibility = View.VISIBLE
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
                Toast.makeText(this,"다시 한번 생각해봐라, 어흥",Toast.LENGTH_SHORT).show()
            }
        }

    }
}