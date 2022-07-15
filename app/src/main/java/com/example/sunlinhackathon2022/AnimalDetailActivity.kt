package com.example.sunlinhackathon2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.sunlinhackathon2022.databinding.ActivityAnimalDetailBinding
import com.example.sunlinhackathon2022.databinding.ActivityMyPageBinding

class AnimalDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimalDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //back code
        binding.back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        val animalDataList: List<List<String>> = listOf( // 0 이름 1 ar 2 이미지 3 디테일
            listOf("대왕판다","GiantPanda/model.glb","",""),
            listOf("너구리","Raccoon/model.glb","",""),
            listOf("사슴","WhiteTailedDeer/model.glb","",""),
            listOf("늑대","TimberWolf/model.glb","",""),
            listOf("백상아리","GreatWhiteShark/model.glb","",""),
            listOf("바다거북","GreenSeaTurtle/model.glb","",""),
            listOf("악어","Alligator/model.glb","",""),
            listOf("호랑이","Tiger/model.glb","","")
        )

        val animalARBaseUrl = "https://arvr.google.com/scene-viewer/web?file=https://storage.googleapis.com/ar-answers-in-search-models/static/"
        val animalCode = intent.getStringExtra("animalCode")!!.toInt()
        val animalImageUrl: String = animalDataList[animalCode][2]
        val animalName: String = animalDataList[animalCode][0]
        val animalARUrl: String = animalDataList[animalCode][1]
        val animalDetail: String = animalDataList[animalCode][3]

        Glide.with(this)
            .load(animalImageUrl)
            .into(binding.animalImageView)


        binding.animalName.text = animalName
        binding.animalExplanation.text = animalDetail

        binding.payButton.setOnClickListener {
            val ARIntent = Intent(this, ArWebViewActivity::class.java)
            ARIntent.putExtra("arUrl",animalARBaseUrl+animalARUrl)
            startActivity(ARIntent)
        }




    }
}