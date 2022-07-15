package com.example.sunlinhackathon2022

import com.example.sunlinhackathon2022.account.LogInData
import com.example.sunlinhackathon2022.account.NewUserData
import com.example.sunlinhackathon2022.account.SignInData
import com.example.sunlinhackathon2022.account.SignUpData
import com.example.sunlinhackathon2022.fragment.illustratedbook.DictData
import com.example.sunlinhackathon2022.fragment.illustratedbook.ResultData
import com.example.sunlinhackathon2022.fragment.shop.ShopData
import com.example.sunlinhackathon2022.fragment.shop.purchase.Barcode
import com.example.sunlinhackathon2022.fragment.shop.purchase.Buy
import com.example.sunlinhackathon2022.mypage.BarcodeList
import retrofit2.Call
import retrofit2.http.*

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

    @GET("auth/dict")
    fun getDictList(@Header("x-access-token")token: String):Call<DictData>

    @POST("auth/dict/{id}")
    fun addDict(@Header("x-access-token")token: String,@Path("id") id: String ):Call<ResultData>

    @POST("auth/point")
    fun updateMyPoint(@Header("x-access-token")token: String, @Body point: Int):Call<ResultData>





}