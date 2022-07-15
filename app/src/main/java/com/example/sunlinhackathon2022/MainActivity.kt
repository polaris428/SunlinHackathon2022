package com.example.sunlinhackathon2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.sunlinhackathon2022.account.SignInActivity
import com.example.sunlinhackathon2022.databinding.ActivityMainBinding

import com.example.sunlinhackathon2022.fragment.*
import com.example.sunlinhackathon2022.fragment.home.HomeFragment
import com.example.sunlinhackathon2022.fragment.illustratedbook.DictData
import com.example.sunlinhackathon2022.fragment.illustratedbook.DictionaryFragment
import com.example.sunlinhackathon2022.fragment.illustratedbook.ResultData
import com.example.sunlinhackathon2022.fragment.shop.ShopFragment
import com.example.sunlinhackathon2022.minigame.EndangeredCountMinigameActivity
import com.example.sunlinhackathon2022.minigame.TurtleTouchActivity
import com.google.zxing.integration.android.IntentIntegrator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var integrator: IntentIntegrator
    var waitTime = 0L
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.qrButton.setOnClickListener {
            integratoInit()
        }

        supportFragmentManager.beginTransaction().add(R.id.frameLayout, HomeFragment()).commit()
        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false
        binding.bottomNavigationView.setOnItemSelectedListener {

            replaceFragment(
                when (it.itemId) {
                    R.id.item_fragment1 -> HomeFragment()
                    R.id.item_fragment2 -> DictionaryFragment()
                    R.id.item_fragment3 -> CommunityFragment()
                    R.id.item_fragment4 -> ShopFragment()
                    else -> HomeFragment()
                }
            )
            true
        }


    }

    private fun replaceFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
        return true
    }
    fun integratoInit(){
        integrator=IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE) // 여러가지 바코드중에 특정 바코드 설정 가능
        integrator.setPrompt("QR 코드를 스캔하여 주세요:)") // 스캔할 때 하단의 문구
        integrator.setCameraId(0) // 0은 후면 카메라, 1은 전면 카메라
        integrator.setBeepEnabled(true) // 바코드를 인식했을 때 삑 소리유무
        integrator.setBarcodeImageEnabled(false) // 스캔 했을 때 스캔한 이미지 사용여부
        integrator.initiateScan() // 스캔
    }
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        // QR 코드를 찍은 결과를 변수에 담는다.
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        Log.d("TTT", "QR 코드 체크")

        val sharedPreferences = getSharedPreferences("account", 0)
        val edit=sharedPreferences.edit()
        val token =sharedPreferences.getString("token","").toString()
        val test =sharedPreferences.getString("test","").toString()
        val point =sharedPreferences.getInt("point",0)
        Log.d("token",token)

        //결과가 있으면
        if (result != null) {
            // 컨텐츠가 없으면
            if (result.contents == null) {
                //토스트를 띄운다.
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
            }
            // 컨텐츠가 있으면
            else {
                //토스트를 띄운다.

                Log.d("TTT", "QR 코드 URL:${result.contents}")



                //val checkList = arrayOf("1","2","3","4","5","6","7","8")
                val qrAnimalIntent = Intent(this, AnimalDetailActivity::class.java)
                val qrGameAnimalIntent1 = Intent(this, EndangeredCountMinigameActivity::class.java)
                val qrGameAnimalIntent2 = Intent(this, TurtleTouchActivity::class.java)
                //유효 QR 검사
                if(token == "") {
                    startActivity(Intent(this, SignInActivity::class.java ))
                } else {
                    val call1 = RetrofitClass.getApiService().getDictList(token)
                    call1.enqueue(object : Callback<DictData> {
                        override fun onResponse(
                            call: Call<DictData>,
                            response: Response<DictData>
                        ) {
                            if(response.isSuccessful) {
                                edit.putInt("point",point+10000)

                                edit.apply()
                                if(result.contents.toInt() in response.body()!!.dict) {
                                    edit.putString("test",response.body()!!.dict.toString())//있다
                                    Log.d("response.body()!!.dict.toString()",response.body()!!.dict.toString())
                                    edit.apply()
                                    if(result.contents.toInt() == 4) { //게임대상
                                        qrGameAnimalIntent1.putExtra("animalCode",result.contents)
                                        startActivity(qrGameAnimalIntent1)
                                    } else if(result.contents.toInt() == 6) {
                                        qrGameAnimalIntent2.putExtra("animalCode",result.contents)
                                        startActivity(qrGameAnimalIntent2)
                                    } else { //게임대상X
                                        qrAnimalIntent.putExtra("animalCode", result.contents)
                                        startActivity(qrAnimalIntent)
                                    }
                                } else { //포인트 추가
                                    val call22 = RetrofitClass.getApiService().updateMyPoint(token, 100)
                                    call22.enqueue(object : Callback<ResultData>{
                                        override fun onResponse(
                                            call: Call<ResultData>,
                                            response: Response<ResultData>
                                        ) {
                                            if(response.isSuccessful) {
                                                if(result.contents.toInt() == 4) { //게임대상
                                                    qrGameAnimalIntent1.putExtra("animalCode",result.contents)
                                                    startActivity(qrGameAnimalIntent1)
                                                } else if(result.contents.toInt() == 6) {
                                                    qrGameAnimalIntent2.putExtra("animalCode",result.contents)
                                                    startActivity(qrGameAnimalIntent2)
                                                } else { //게임대상X
                                                    qrAnimalIntent.putExtra("animalCode", result.contents)
                                                    startActivity(qrAnimalIntent)
                                                }
                                            }
                                        }

                                        override fun onFailure(
                                            call: Call<ResultData>,
                                            t: Throwable
                                        ) {
                                            Log.d("main-call22","error")
                                        }

                                    })
                                }
                            }
                        }

                        override fun onFailure(call: Call<DictData>, t: Throwable) {
                            Log.d("main-call1","error")
                        }

                    })

                }

                //웹뷰 설정
                //웹뷰를 띄운다.


            }

        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
    override fun onBackPressed() {
        if(System.currentTimeMillis() - waitTime >=1500 ) {
            waitTime = System.currentTimeMillis()
            Toast.makeText(this,"뒤로가기 버튼을 한번 더 누르면 종료됩니다.",Toast.LENGTH_SHORT).show()
        } else {
            finish() // 액티비티 종료
        }
    }
}