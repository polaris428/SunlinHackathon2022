package com.example.sunlinhackathon2022

import com.example.sunlinhackathon2022.account.SignUpData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("auth/local")
    fun getUser(username:String,email:String,password:String): Call<SignUpData>



}