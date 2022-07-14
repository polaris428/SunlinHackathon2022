package com.example.sunlinhackathon2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.sunlinhackathon2022.databinding.ActivityMainBinding
import com.example.sunlinhackathon2022.fragment.BlankFragment
import com.example.sunlinhackathon2022.fragment.BlankFragment2
import com.example.sunlinhackathon2022.fragment.BlankFragment3
import com.example.sunlinhackathon2022.fragment.BlankFragment4

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().add(R.id.frameLayout, BlankFragment()).commit()

        binding.bottomNavigationView.setOnItemSelectedListener {

            replaceFragment(
                when (it.itemId) {
                    R.id.item_fragment1 -> BlankFragment()
                    R.id.item_fragment2 -> BlankFragment2()
                    R.id.item_fragment3 -> BlankFragment3()
                    R.id.item_fragment4 -> BlankFragment4()
                    else -> BlankFragment()
                }
            )
            true
        }


    }
    private fun replaceFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
        return true
    }
}