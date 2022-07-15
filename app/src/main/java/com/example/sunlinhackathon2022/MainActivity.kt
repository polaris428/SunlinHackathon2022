package com.example.sunlinhackathon2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.sunlinhackathon2022.databinding.ActivityMainBinding

import com.example.sunlinhackathon2022.fragment.*
import com.example.sunlinhackathon2022.fragment.illustratedbook.DictionaryFragment
import com.example.sunlinhackathon2022.fragment.shop.ShopFragment
import com.google.zxing.integration.android.IntentIntegrator

class MainActivity : AppCompatActivity() {
    lateinit var integrator: IntentIntegrator
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
                Toast.makeText(this, "scanned" + result.contents, Toast.LENGTH_LONG).show()
                Log.d("TTT", "QR 코드 URL:${result.contents}")

                val checkList = arrayOf("1","2","3","4","5","6","7","8")
                //유효 QR 검사
                if(result.contents !in checkList) {
                    Toast.makeText(this, "유효하지 않은 QR코드입니다", Toast.LENGTH_LONG).show()
                } else {
                    val qrAnimalIntent: Intent = Intent(this, AnimalDetailActivity::class.java)
                    qrAnimalIntent.putExtra("animalCode", result.contents)
                    startActivity(qrAnimalIntent)
                }

                //웹뷰 설정
                //웹뷰를 띄운다.


            }

        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}