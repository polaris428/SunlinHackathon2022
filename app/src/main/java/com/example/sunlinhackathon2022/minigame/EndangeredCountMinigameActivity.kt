package com.example.sunlinhackathon2022.minigame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.sunlinhackathon2022.AnimalDetailActivity
import com.example.sunlinhackathon2022.R
import com.example.sunlinhackathon2022.RetrofitClass
import com.example.sunlinhackathon2022.databinding.ActivityEndangeredCountMinigameBinding
import com.example.sunlinhackathon2022.databinding.ActivityMyPageBinding
import com.example.sunlinhackathon2022.fragment.illustratedbook.ResultData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EndangeredCountMinigameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEndangeredCountMinigameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEndangeredCountMinigameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val answer = 267

        val sharedPreferences = getSharedPreferences("account", 0)

        val token =sharedPreferences.getString("token","").toString()
        Log.d("token",token)

        binding.goBtn.setOnClickListener {
            if(binding.inputCount.text.toString().toInt() == answer) {
                val animalId = intent.getStringExtra("animalCode")
                val detailIntent = Intent(this, AnimalDetailActivity::class.java)
                val getCall = RetrofitClass.getApiService().addDict(token, animalId!!.toInt())
                getCall.enqueue(object : Callback<ResultData> {
                    override fun onResponse(
                        call: Call<ResultData>,
                        response: Response<ResultData>
                    ) {
                        if(response.isSuccessful) {
                            detailIntent.putExtra("animalCode",animalId)
                            startActivity(detailIntent)
                        }
                    }

                    override fun onFailure(call: Call<ResultData>, t: Throwable) {
                        Log.d("mini_endaged","error")
                    }

                })

            } else if(binding.inputCount.text.toString().toInt() < answer) {
                Toast.makeText(this, "입력한 값보다 정답이 더 큽니다.", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "입력한 값보다 정답이 더 작습니다.", Toast.LENGTH_LONG).show()
            }
        }
    }
}