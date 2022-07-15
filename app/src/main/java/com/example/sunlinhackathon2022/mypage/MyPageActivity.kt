package com.example.sunlinhackathon2022.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sunlinhackathon2022.RetrofitClass
import com.example.sunlinhackathon2022.databinding.ActivityMyPageBinding
import com.example.sunlinhackathon2022.fragment.shop.ShopAdapter
import com.example.sunlinhackathon2022.fragment.shop.ShopData
import com.example.sunlinhackathon2022.fragment.shop.purchase.Barcode
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
        val id =sharedPreferences.getString("id","").toString()
        var point:Int=sharedPreferences.getInt("point",0)

        Log.d("token",token)
        binding.point.text=point.toString()+"p"
        binding.userName.text=id
        binding.lottieView.playAnimation()
        binding.lottieView.loop(true)
        val call=RetrofitClass.getApiService().getBarcodeList(token)
        call.enqueue(object :Callback<BarcodeList>{
            override fun onResponse(call: Call<BarcodeList>, response: Response<BarcodeList>) {
                if(response.isSuccessful){
                    Log.d("test",response.body()!!.barcode.toString())
                    var barcodeAdapter = BarcodeAdapter()
                    var datas = arrayListOf<Barcode>()
                    datas=response.body()!!.barcode
                        binding.recyclerView.layoutManager = LinearLayoutManager(this@MyPageActivity)

                    binding.recyclerView.adapter = barcodeAdapter
                    barcodeAdapter.listData =datas
                    barcodeAdapter.notifyDataSetChanged()
                    binding.lottieView.visibility= View.GONE
                    binding.lottieView.cancelAnimation()
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