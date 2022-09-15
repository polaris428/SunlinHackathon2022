package com.example.sunlinhackathon2022

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.sunlinhackathon2022.databinding.ActivityMainBinding
import com.example.sunlinhackathon2022.databinding.ActivitySplashBinding
import com.example.sunlinhackathon2022.fragment.illustratedbook.DictData
import com.google.zxing.integration.android.IntentIntegrator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    lateinit var token:String
     val  sharedPreferences: SharedPreferences by lazy {
         getSharedPreferences("account", 0)
     }
    val edit by lazy {
        sharedPreferences.edit()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getToken()
        test(token)

        binding.constraintLayout.setBackgroundResource(R.drawable.oceanback)

        val handler = Handler()
        handler.postDelayed(Runnable {

            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)

    }
    private fun getToken(){


            token =sharedPreferences.getString("token","").toString()
            val test =sharedPreferences.getString("test","").toString()
            val point =sharedPreferences.getInt("point",0)
        if(token!=""){
            test(token)
        }


    }
    fun test(token:String){
        val callee = RetrofitClass.getApiService().getDictList(token)
        callee.enqueue(object : Callback<DictData> {
            override fun onResponse(call: Call<DictData>, response: Response<DictData>) {
                if(response.isSuccessful) {
                    edit.putString("test",response.body()!!.dict.toString())//있다
                    Log.d("Main",response.body().toString())
                    edit.apply()
                }
            }

            override fun onFailure(call: Call<DictData>, t: Throwable) {
                Log.e("Main",t.toString())
            }

        })
    }
}