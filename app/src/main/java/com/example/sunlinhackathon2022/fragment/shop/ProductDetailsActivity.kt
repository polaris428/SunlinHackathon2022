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
import com.google.android.material.dialog.MaterialAlertDialogBuilder
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
        var name=intent.getStringExtra("name").toString()
        var photo=intent.getStringExtra("photo").toString()
         description=intent.getStringExtra("description").toString()

        val price=  intent.getIntExtra("price",-1)
        binding.payButton.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("결제하시겠습니까?")
                .setMessage("정말 결제하시겠습니까?\n결제시 환불이 어렵습니다.")
                .setNegativeButton("취소") { dialog, which ->
                    // Respond to negative button press
                }
                .setPositiveButton("확인") { dialog, which ->
                    if(true){
                        barcode(token,Buy(name,price,photo))
                    }else{
                        Toast.makeText(this,"포인트가 부족합니다",Toast.LENGTH_SHORT).show()
                    }
                }
                .show()
        }
        binding.back.setOnClickListener {
            finish()
        }

        binding.productName.text=name
        binding.productExplanation.text=description
        binding.productTag.text=intent.getStringExtra("tag").toString()
        Glide.with(this).load(photo).centerCrop().into(binding.productImageView)
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
                   finish()
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