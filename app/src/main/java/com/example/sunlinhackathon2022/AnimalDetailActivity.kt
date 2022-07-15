package com.example.sunlinhackathon2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.sunlinhackathon2022.databinding.ActivityAnimalDetailBinding
import com.example.sunlinhackathon2022.databinding.ActivityMyPageBinding
import com.example.sunlinhackathon2022.fragment.illustratedbook.ResultData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimalDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimalDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("account", 0)

        val token =sharedPreferences.getString("token","").toString()
        Log.d("token",token)

        //back code
        binding.back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        val animalDataList: List<List<String>> = listOf( // 0 이름 1 ar 2 이미지 3 디테일
            listOf("대왕판다","GiantPanda/model.glb","https://cdn.discordapp.com/attachments/997399980765618177/997400102853414972/panda.jpg",""),
            listOf("너구리","Raccoon/model.glb","https://cdn.discordapp.com/attachments/997399980765618177/997400103927160873/raccoon.jpg",""),
            listOf("사슴","WhiteTailedDeer/model.glb","https://cdn.discordapp.com/attachments/997399980765618177/997400102161350727/deer.jpg",""),
            listOf("늑대","TimberWolf/model.glb","https://cdn.discordapp.com/attachments/997399980765618177/997400102454964325/wolf.jpg",""),
            listOf("백상아리","GreatWhiteShark/model.glb","https://cdn.discordapp.com/attachments/997399980765618177/997400101335081001/shark.jpg",""),
            listOf("바다거북","GreenSeaTurtle/model.glb","https://media.discordapp.net/attachments/997399980765618177/997453166297763850/turtle.jpg",""),
            listOf("악어","Alligator/model.glb","https://cdn.discordapp.com/attachments/997399980765618177/997400101838405722/nile.jpg",""),
            listOf("호랑이","Tiger/model.glb","https://cdn.discordapp.com/attachments/997399980765618177/997400103532904449/tiger.jpg","")
        )

        val animalARBaseUrl = "https://arvr.google.com/scene-viewer/web?file=https://storage.googleapis.com/ar-answers-in-search-models/static/"
        val animalCode = intent.getStringExtra("animalCode")!!.toInt() - 1
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

        val getCall = RetrofitClass.getApiService().addDict(token, animalCode+1)
        getCall.enqueue(object : Callback<ResultData> {
            override fun onResponse(
                call: Call<ResultData>,
                response: Response<ResultData>
            ) {
                if(response.isSuccessful) {

                }
            }

            override fun onFailure(call: Call<ResultData>, t: Throwable) {
                Log.d("mini_endaged","error")
            }

        })




    }
}