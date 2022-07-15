package com.example.sunlinhackathon2022.fragment.home

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sunlinhackathon2022.R
import com.example.sunlinhackathon2022.databinding.FragmentCommunityBinding
import com.example.sunlinhackathon2022.databinding.FragmentHome1Binding

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
                }
                "2" -> {
                    binding.raccoon.visibility = View.VISIBLE
                }
                "3" -> {
                    binding.deer.visibility = View.VISIBLE
                }
                "8" -> {
                    binding.tiger.visibility = View.VISIBLE
                }
                else -> {

                }
            }
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}