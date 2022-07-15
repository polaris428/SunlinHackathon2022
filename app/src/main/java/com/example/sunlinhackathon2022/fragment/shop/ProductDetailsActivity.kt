package com.example.sunlinhackathon2022.fragment.shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.sunlinhackathon2022.BarcodeActivity
import com.example.sunlinhackathon2022.R
import com.example.sunlinhackathon2022.RetrofitClass
import com.example.sunlinhackathon2022.Token
import com.example.sunlinhackathon2022.databinding.ActivityProductDetailsBinding
import com.example.sunlinhackathon2022.fragment.shop.purchase.Barcode
import com.example.sunlinhackathon2022.fragment.shop.purchase.Buy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDetailsActivity : AppCompatActivity() {
    lateinit var  binding: ActivityProductDetailsBinding
    lateinit  var description:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences = getSharedPreferences("account", 0)
        var point:Int=sharedPreferences.getInt("point",0)
        var token =sharedPreferences.getString("token","").toString()
        val intent:Intent= getIntent()
         description=intent.getStringExtra("description").toString()

        val price=  intent.getIntExtra("price",-1)
        binding.payButton.setOnClickListener {
            if(true){
                barcode(token,Buy("test",100,"test"))
            }else{
                Toast.makeText(this,"포인트가 부족합니다",Toast.LENGTH_SHORT).show()
            }
        }
        binding.productName.text=intent.getStringExtra("name").toString()
        binding.productExplanation.text=description
        binding.productTag.text=intent.getStringExtra("tag").toString()
        Glide.with(this).load(intent.getStringExtra("photo")).centerCrop().into(binding.productImageView)
    }
    fun barcode(token:String,buy: Buy){
        val call=RetrofitClass.getApiService().setBarcode(token,buy)
        call.enqueue(object:Callback<Barcode>{
            override fun onResponse(call: Call<Barcode>, response: Response<Barcode>) {
               if(response.isSuccessful){
                   var intent=Intent(this@ProductDetailsActivity,BarcodeActivity::class.java)
                   intent.putExtra("barcode",response.body()!!.barcode)
                   intent.putExtra("name",response.body()!!.name)
                   intent.putExtra("photo",response.body()!!.photo)
                   intent.putExtra("description",description)
                   startActivity(intent)
               }else{
                   Toast.makeText(this@ProductDetailsActivity,"잠시 후 다시 시도해주세요",Toast.LENGTH_SHORT).show()
               }
            }

            override fun onFailure(call: Call<Barcode>, t: Throwable) {
                Toast.makeText(this@ProductDetailsActivity,"잠시 후 다시 시도해주세요",Toast.LENGTH_SHORT).show()
            }

        })


    }
}