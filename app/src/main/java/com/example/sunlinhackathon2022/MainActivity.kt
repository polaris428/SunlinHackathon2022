package com.example.sunlinhackathon2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.sunlinhackathon2022.databinding.ActivityMainBinding

import com.example.sunlinhackathon2022.fragment.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
}