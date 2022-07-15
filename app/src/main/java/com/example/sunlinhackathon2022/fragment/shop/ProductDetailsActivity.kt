package com.example.sunlinhackathon2022.fragment.shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.sunlinhackathon2022.R
import com.example.sunlinhackathon2022.databinding.ActivityProductDetailsBinding

class ProductDetailsActivity : AppCompatActivity() {
    lateinit var  binding:ActivityProductDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences = getSharedPreferences("account", 0)
        var point=sharedPreferences.getInt("point",0)

        val price= Integer.getInteger( intent.getStringExtra("price").toString())
        binding.payButton.setOnClickListener {
            if(price>point){
                Log.d("상품 구매","성공")
            }else{
                Toast.makeText(this,"포인트가 부족합니다",Toast.LENGTH_SHORT).show()
            }
        }

        val intent:Intent= getIntent()
        binding.productName.text=intent.getStringExtra("name").toString()
        binding.productExplanation.text=intent.getStringExtra("description").toString()
        binding.productTag.text=intent.getStringExtra("tag").toString()
        Glide.with(this).load(intent.getStringExtra("photo")).centerCrop().into(binding.productImageView)
    }
}