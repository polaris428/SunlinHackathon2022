package com.example.sunlinhackathon2022.fragment.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sunlinhackathon2022.AnimalDetailActivity
import com.example.sunlinhackathon2022.R
import com.example.sunlinhackathon2022.databinding.FragmentHome1Binding
import com.example.sunlinhackathon2022.databinding.FragmentHome2Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentHome2Binding

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
        binding = FragmentHome2Binding.inflate(inflater, container, false)
        val sharedPreferences = binding.root.context.getSharedPreferences("account", 0)

        var viList =sharedPreferences.getString("test","").toString()
        viList = viList.replace("[","")
        viList = viList.replace("]","")
        viList = viList.replace(",","")
        val visualList = viList.split(" ")
        Log.d("ddd",visualList.toString())
        for( x in visualList) {
            when(x) {
                "4" -> {
                    binding.wolf.visibility = View.VISIBLE
                    binding.wolf.setOnClickListener {
                        val goDetail = Intent(binding.root.context, AnimalDetailActivity::class.java)
                        goDetail.putExtra("animalCode","4");
                        startActivity(goDetail)
                    }
                }
                "5" -> {
                    binding.shark.visibility = View.VISIBLE
                    binding.shark.setOnClickListener {
                        val goDetail = Intent(binding.root.context, AnimalDetailActivity::class.java)
                        goDetail.putExtra("animalCode","5");
                        startActivity(goDetail)
                    }
                }
                "6" -> {
                    binding.turtle.visibility = View.VISIBLE
                    binding.turtle.setOnClickListener {
                        val goDetail = Intent(binding.root.context, AnimalDetailActivity::class.java)
                        goDetail.putExtra("animalCode","6");
                        startActivity(goDetail)
                    }
                }
                "7" -> {
                    binding.nile.visibility = View.VISIBLE
                    binding.nile.setOnClickListener {
                        val goDetail = Intent(binding.root.context, AnimalDetailActivity::class.java)
                        goDetail.putExtra("animalCode","7");
                        startActivity(goDetail)
                    }
                }
                else -> {

                }
            }
        }


        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onStart() {
        super.onStart()
        val sharedPreferences = binding.root.context.getSharedPreferences("account", 0)

        var viList =sharedPreferences.getString("test","").toString()
        viList = viList.replace("[","")
        viList = viList.replace("]","")
        viList = viList.replace(",","")
        val visualList = viList.split(" ")
        Log.d("ddd",visualList.toString())
        for( x in visualList) {
            when(x) {
                "4" -> {
                    binding.wolf.visibility = View.VISIBLE
                    binding.wolf.setOnClickListener {
                        val goDetail = Intent(binding.root.context, AnimalDetailActivity::class.java)
                        goDetail.putExtra("animalCode","4");
                        startActivity(goDetail)
                    }
                }
                "5" -> {
                    binding.shark.visibility = View.VISIBLE
                    binding.shark.setOnClickListener {
                        val goDetail = Intent(binding.root.context, AnimalDetailActivity::class.java)
                        goDetail.putExtra("animalCode","5");
                        startActivity(goDetail)
                    }
                }
                "6" -> {
                    binding.turtle.visibility = View.VISIBLE
                    binding.turtle.setOnClickListener {
                        val goDetail = Intent(binding.root.context, AnimalDetailActivity::class.java)
                        goDetail.putExtra("animalCode","6");
                        startActivity(goDetail)
                    }
                }
                "7" -> {
                    binding.nile.visibility = View.VISIBLE
                    binding.nile.setOnClickListener {
                        val goDetail = Intent(binding.root.context, AnimalDetailActivity::class.java)
                        goDetail.putExtra("animalCode","7");
                        startActivity(goDetail)
                    }
                }
                else -> {

                }
            }
        }
    }
}