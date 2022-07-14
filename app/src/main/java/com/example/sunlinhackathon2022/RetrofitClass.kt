package com.example.sunlinhackathon2022

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClass {
    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://2022API.2tle.repl.co/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiService():ApiService{
        return getRetrofit().create(ApiService::class.java)
    }

}