package com.example.sunlinhackathon2022.fragment.home

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sunlinhackathon2022.AnimalDetailActivity
import com.example.sunlinhackathon2022.R
import com.example.sunlinhackathon2022.RetrofitClass
import com.example.sunlinhackathon2022.databinding.FragmentCommunityBinding
import com.example.sunlinhackathon2022.databinding.FragmentHome1Binding
import com.example.sunlinhackathon2022.fragment.illustratedbook.DictData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding: FragmentHome1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHome1Binding.inflate(inflater, container, false)

        val sharedPreferences = binding.root.context.getSharedPreferences("account", 0)

        var viList =sharedPreferences.getString("test","").toString()
        viList = viList.replace("[","")
        viList = viList.replace("]","")
        viList = viList.replace(",","")
        val visualList = viList.split(" ")
        for( x in visualList) {
            when(x) {
                "1" -> {
                    binding.panda.visibility = View.VISIBLE
                    binding.panda.setOnClickListener {
                        val goDetail = Intent(binding.root.context, AnimalDetailActivity::class.java)
                        goDetail.putExtra("animalCode","1");
                        startActivity(goDetail)
                    }
                }
                "2" -> {
                    binding.raccoon.visibility = View.VISIBLE
                    binding.raccoon.setOnClickListener {
                        val goDetail = Intent(binding.root.context, AnimalDetailActivity::class.java)
                        goDetail.putExtra("animalCode","2");
                        startActivity(goDetail)
                    }
                }
                "3" -> {
                    binding.deer.visibility = View.VISIBLE
                    binding.deer.setOnClickListener {
                        val goDetail = Intent(binding.root.context, AnimalDetailActivity::class.java)
                        goDetail.putExtra("animalCode","3");
                        startActivity(goDetail)
                    }
                }
                "8" -> {
                    binding.tiger.visibility = View.VISIBLE
                    binding.tiger.setOnClickListener {
                        val goDetail = Intent(binding.root.context, AnimalDetailActivity::class.java)
                        goDetail.putExtra("animalCode","8");
                        startActivity(goDetail)
                    }
                }
                else -> {

                }
            }
        }

        // Inflate the layout for this fragment
        return binding.root
    }



}