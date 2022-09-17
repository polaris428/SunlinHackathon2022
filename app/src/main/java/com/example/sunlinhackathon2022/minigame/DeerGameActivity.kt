package com.example.sunlinhackathon2022.minigame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import com.example.sunlinhackathon2022.AnimalDetailActivity
import com.example.sunlinhackathon2022.R
import com.example.sunlinhackathon2022.databinding.ActivityDeerGameBinding
import com.example.sunlinhackathon2022.databinding.ActivityTurtleTouchBinding

class DeerGameActivity : AppCompatActivity() {
    lateinit var binding: ActivityDeerGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeerGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var count = 12
        findViewById<ImageView>(R.id.hurtImageView).setOnClickListener {
            count--
            if (count == 0) {
                binding.examText.visibility = View.GONE
                binding.answerText.visibility = View.VISIBLE
                binding.hurtImageView.setImageResource(R.drawable.deer)
                val handler = Handler()
                handler.postDelayed(Runnable {
                    val animalId = intent.getStringExtra("animalCode")
                    val detailIntent = Intent(this, AnimalDetailActivity::class.java)
                    detailIntent.putExtra("animalCode", animalId)
                    //detailIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    //finishAffinity()
                    detailIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                    //detailIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(detailIntent)

                    finish()
                }, 3000)

            }
        }
    }
}