package com.example.sunlinhackathon2022.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sunlinhackathon2022.RetrofitClass
import com.example.sunlinhackathon2022.databinding.ActivityMyPageBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences = getSharedPreferences("account", 0)

        val token =sharedPreferences.getString("token","").toString()
        val call=RetrofitClass.getApiService().getBarcodeList(token)
        call.enqueue(object :Callback<BarcodeList>{
            override fun onResponse(call: Call<BarcodeList>, response: Response<BarcodeList>) {
                if(response.isSuccessful){
                    Log.d("test",response.body()!!.barcode.toString())
                }else{
                    Log.d("tst","sfasd")
                }
            }

            override fun onFailure(call: Call<BarcodeList>, t: Throwable) {
                Log.d("tst","ss")
            }

        })
        binding.back.setOnClickListener{
            finish()
        }



    }
}