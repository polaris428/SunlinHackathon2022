package com.example.sunlinhackathon2022.fragment.shop

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.sunlinhackathon2022.*
import com.example.sunlinhackathon2022.databinding.ActivityProductDetailsBinding
import com.example.sunlinhackathon2022.fragment.illustratedbook.ResultData

import com.example.sunlinhackathon2022.fragment.shop.purchase.Barcode
import com.example.sunlinhackathon2022.fragment.shop.purchase.Buy
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDetailsActivity : AppCompatActivity() {
    lateinit var  binding: ActivityProductDetailsBinding
    lateinit  var description:String
    lateinit var name:String
    lateinit var token:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences = getSharedPreferences("account", 0)
        val edit=sharedPreferences.edit()
        var point:Int=sharedPreferences.getInt("point",0)
        point=1000000
         token =sharedPreferences.getString("token","").toString()
        Log.d("token",token)
        val intent:Intent= intent
         name=intent.getStringExtra("name").toString()
        val photo=intent.getStringExtra("photo").toString()
         description=intent.getStringExtra("description").toString()

        val price=  intent.getIntExtra("price",0)
        binding.costText.text=price.toString()+"p"
        binding.payButton.setOnClickListener {
            if(point>=price){
                MaterialAlertDialogBuilder(this)
                    .setTitle("결제하시겠습니까?")
                    .setMessage("정말 결제하시겠습니까?\n결제시 환불이 어렵습니다.")
                    .setNegativeButton("취소") { dialog, which ->
                        // Respond to negative button press
                    }
                    .setPositiveButton("확인") { dialog, which ->
                        edit.putInt("point",point-price)
                        edit.apply()
                        category()
                    }
                    .show()

            }else{
                Toast.makeText(this,"포인트가 부족합니다",Toast.LENGTH_SHORT).show()
            }

        }
        binding.back.setOnClickListener {
            finish()
        }

        binding.productName.text=name
        binding.productExplanation.text=description
        binding.productTag.text=intent.getStringExtra("tag").toString()
        Glide.with(this).load(photo).centerCrop().into(binding.productImageView)
    }
//    fun barcode(token:String,buy: Buy){
//        val call=RetrofitClass.getApiService().setBarcode(token,buy)
//        call.enqueue(object:Callback<Barcode>{
//            override fun onResponse(call: Call<Barcode>, response: Response<Barcode>) {
//               if(response.isSuccessful){
//                   var intent=Intent(this@ProductDetailsActivity,MainActivity::class.java)
//                   intent.putExtra("barcode",response.body()!!.barcode)
//                   intent.putExtra("name",response.body()!!.name)
//                   intent.putExtra("photo",response.body()!!.photo)
//                   intent.putExtra("description",description)
//                   startActivity(intent)
//                   finish()
//               }else{
//                   Toast.makeText(this@ProductDetailsActivity,"잠시 후 다시 시도해주세요",Toast.LENGTH_SHORT).show()
//               }
//            }
//
//            override fun onFailure(call: Call<Barcode>, t: Throwable) {
//                Toast.makeText(this@ProductDetailsActivity,"잠시 후 다시 시도해주세요",Toast.LENGTH_SHORT).show()
//            }
//
//        })
//}




    private fun category(){
        when(name){
            "악어"->{
                binding.progressBar.visibility= View.VISIBLE
                binding.payButton.visibility=View.GONE
                addAnimals(7)
            }
            "상어"->{
                binding.progressBar.visibility= View.VISIBLE
                binding.payButton.visibility=View.GONE
                addAnimals(5)
            }
            "꽃 장식1", "꽃 장식2"->{
                val sharedPreferences = binding.root.context.getSharedPreferences("flow", 0)
                val preferencesEditor: SharedPreferences.Editor = sharedPreferences.edit()
                preferencesEditor.putBoolean("flow",true)
                preferencesEditor.apply()
                startActivity(Intent(this@ProductDetailsActivity,MainActivity::class.java))
                finish()
            }

        }
    }

    private fun addAnimals(code:Int){
        val getCall = RetrofitClass.getApiService().addDict(token, (code).toString())
        getCall.enqueue(object : Callback<ResultData> {
            override fun onResponse(
                call: Call<ResultData>,
                response: Response<ResultData>
            ) {
                if(response.isSuccessful) {
                    startActivity(Intent(this@ProductDetailsActivity,MainActivity::class.java))
                    finish()
                }else{
                    Log.d("test",response.code().toString())
                    Toast.makeText(binding.root.context,"잠시후 다시 시도해주세요",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResultData>, t: Throwable) {
                Toast.makeText(binding.root.context,"잠시후 다시 시도해주세요",Toast.LENGTH_SHORT).show()
            }

        })
    }


}