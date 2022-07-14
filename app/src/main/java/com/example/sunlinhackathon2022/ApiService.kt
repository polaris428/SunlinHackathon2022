package com.example.sunlinhackathon2022

import com.example.sunlinhackathon2022.account.LogInData
import com.example.sunlinhackathon2022.account.NewUserData
import com.example.sunlinhackathon2022.account.SignInData
import com.example.sunlinhackathon2022.account.SignUpData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("auth/local")
    fun setUser(@Body newUserData: NewUserData): Call<SignUpData>
    @POST("auth/local")
    fun getUser(@Body logInData: LogInData): Call<SignInData>





}