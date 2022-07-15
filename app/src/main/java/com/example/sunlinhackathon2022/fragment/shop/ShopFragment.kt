package com.example.sunlinhackathon2022.fragment.shop

import android.content.Context.MODE_PRIVATE
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sunlinhackathon2022.RetrofitClass
import com.example.sunlinhackathon2022.databinding.FragmentShopBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShopFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShopFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentShopBinding
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
        // Inflate the layout for this fragment
        binding = FragmentShopBinding.inflate(inflater, container, false)
        var sharedPreferences=binding.root.context.getSharedPreferences("account",MODE_PRIVATE);
        val id=sharedPreferences.getString("id","")
        if (id==""){
            binding.loginTextView.visibility=View.VISIBLE
            binding.recyclerView.visibility=View.GONE
            val str = "상점을 이용하시러면 \n 로그인 해주세요"
            val ssb = SpannableStringBuilder(str)
            ssb.setSpan(
                ForegroundColorSpan(Color.parseColor("#0085ff")), 13, 16,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            binding.loginTextView.text=ssb
        }else{
            binding.loginTextView.visibility=View.GONE
            binding.recyclerView.visibility=View.VISIBLE
            val datas = arrayListOf<ShopData>()
            var call = RetrofitClass.getApiService().getShop()
            call.enqueue(object : Callback<ShopData> {
                override fun onResponse(call: Call<ShopData>, response: Response<ShopData>) {
                    response.body()?.let { datas.add(it) }
                    var shopAdapter = ShopAdapter()
                    binding.recyclerView.layoutManager = LinearLayoutManager(getActivity())

                    binding.recyclerView.adapter = shopAdapter
                    shopAdapter.listData = datas
                    shopAdapter.notifyDataSetChanged()

                }

                override fun onFailure(call: Call<ShopData>, t: Throwable) {
                    Log.d("실패", "실패")
                }

            })
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
         * @return A new instance of fragment ShopFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShopFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}