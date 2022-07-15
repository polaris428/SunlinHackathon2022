package com.example.sunlinhackathon2022

import com.example.sunlinhackathon2022.account.LogInData
import com.example.sunlinhackathon2022.account.NewUserData
import com.example.sunlinhackathon2022.account.SignInData
import com.example.sunlinhackathon2022.account.SignUpData
import com.example.sunlinhackathon2022.fragment.shop.ShopData
import com.example.sunlinhackathon2022.fragment.shop.purchase.Barcode
import com.example.sunlinhackathon2022.fragment.shop.purchase.Buy
import com.example.sunlinhackathon2022.mypage.BarcodeList
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("auth/new")
    fun signUp(@Body newUserData: NewUserData): Call<SignUpData>
    @POST("auth/local")
    fun signIn(@Body logInData: LogInData): Call<SignInData>
    @GET("shop")
    fun getShop(): Call<ShopData>
    @POST("barcode")
    fun setBarcode(@Header("x-access-token")token: String,@Body barcode: Buy) :Call<Barcode>
    @GET("barcode/list")
    fun getBarcodeList(@Header("x-access-token")token: String):Call<BarcodeList>







}