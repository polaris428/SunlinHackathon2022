package com.example.sunlinhackathon2022.minigame

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.example.sunlinhackathon2022.AnimalDetailActivity
import com.example.sunlinhackathon2022.databinding.ActivityRaccoonGameBinding

class RaccoonGameActivity : AppCompatActivity() {
    lateinit var binding: ActivityRaccoonGameBinding
    var test = false
    var count = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRaccoonGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageView.setOnTouchListener { v, event ->
            val action = event.action // 상당히 많이 호출되는, 온터치 메소드의 구분자역할을 함.
            val curX = event.x
            val curY = event.y
            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    println("손가락 눌렸음 : $curX,$curY")
                }
                MotionEvent.ACTION_MOVE -> {
                    if (!test) {
                        count++
                        test = true
                        Handler().postDelayed({
                            test = false
                        }, 1000) // 0.6초 정도 딜레이를 준 후 시작


                    }
                    if (count>=5){
                        val animalId = intent.getStringExtra("animalCode")
                        val detailIntent = Intent(this, AnimalDetailActivity::class.java)
                        detailIntent.putExtra("animalCode",animalId)
                        startActivity(detailIntent)
                    }
                    println("손가락 움직임 : $curX,$curY")
                }
                MotionEvent.ACTION_UP -> {
                    println("손가락 뗴졌음 : $curX,$curY")
                }
            }
            true
        }

    }

}