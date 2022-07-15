package com.example.sunlinhackathon2022.minigame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.sunlinhackathon2022.AnimalDetailActivity
import com.example.sunlinhackathon2022.MainActivity
import com.example.sunlinhackathon2022.R
import com.example.sunlinhackathon2022.databinding.ActivityTurtleTouchBinding

class TurtleTouchActivity : AppCompatActivity() {
    lateinit var binding:ActivityTurtleTouchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTurtleTouchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var count = 12
        binding.text3.visibility= View.GONE
        binding.dangerButton.setOnClickListener {
            count--
            if(count==8){
                binding.dangerButton.setImageResource(R.drawable.danger2)
            }else if(count==4){
                binding.dangerButton.setImageResource(R.drawable.danger3)
            }else if(count==0){
                binding.dangerButton.visibility = View.GONE
                binding.turtle.setImageResource(R.drawable.turtle)
                binding.text1.visibility = View.GONE
                binding.text2.visibility = View.GONE
                binding.text3.visibility = View.VISIBLE
                val handler = Handler()
                handler.postDelayed(Runnable {
                    //화면전환
                    val animalId = intent.getStringExtra("animalCode")
                    val detailIntent = Intent(this, AnimalDetailActivity::class.java)
                    detailIntent.putExtra("animalCode",animalId)
                    startActivity(detailIntent)

                }, 3000)
            }
        }
    }
}