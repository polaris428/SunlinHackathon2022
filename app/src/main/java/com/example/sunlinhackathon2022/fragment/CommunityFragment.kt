package com.example.sunlinhackathon2022.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater

import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.core.content.res.ComplexColorCompat.inflate
import androidx.fragment.app.FragmentContainer
import com.example.sunlinhackathon2022.StoryDetailActivity

import com.example.sunlinhackathon2022.databinding.ActivityIntroBinding.inflate
import com.example.sunlinhackathon2022.databinding.FragmentCommunityBinding
import com.example.sunlinhackathon2022.databinding.FragmentHomeBinding.inflate
import com.example.sunlinhackathon2022.databinding.FragmentShopBinding
import com.example.sunlinhackathon2022.databinding.FragmentShopBinding.inflate

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CommunityFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CommunityFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding: FragmentCommunityBinding





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding=FragmentCommunityBinding.inflate(inflater,container,false)

        binding.tigerButton.setOnClickListener{
            val intent = Intent(activity, StoryDetailActivity::class.java)
            intent.putExtra("animal", "tiger")
            startActivity(intent)
        }
        binding.wolfButton.setOnClickListener{
            val intent = Intent(activity, StoryDetailActivity::class.java)
            intent.putExtra("animal", "wolf")
            startActivity(intent)
        }
        binding.tortoiseButton.setOnClickListener{
            val intent = Intent(activity, StoryDetailActivity::class.java)
            intent.putExtra("animal", "tortoise")
            startActivity(intent)
        }
        binding.pandaButton.setOnClickListener{
            val intent = Intent(activity, StoryDetailActivity::class.java)
            intent.putExtra("animal", "panda")
            startActivity(intent)
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
         * @return A new instance of fragment CommunityFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CommunityFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}