package com.example.sunlinhackathon2022.fragment.illustratedbook

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.sunlinhackathon2022.R
import com.example.sunlinhackathon2022.RetrofitClass
import com.example.sunlinhackathon2022.databinding.FragmentCommunityBinding
import com.example.sunlinhackathon2022.databinding.FragmentDictionaryBinding
import com.example.sunlinhackathon2022.dict.AnimalDTO
import com.example.sunlinhackathon2022.dict.AnimalDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DictionaryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DictionaryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentDictionaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }




        //illustratedbookAdapter.listData=  리스트 삽입
        //illustratedbookAdapter.notifyDataSetChanged()


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentDictionaryBinding.inflate(inflater,container,false)

        val animalDataList: List<List<String>> = listOf( // 0 이름 1 ar 2 이미지 3 디테일
            listOf("대왕판다","GiantPanda/model.glb","https://cdn.discordapp.com/attachments/997399980765618177/997400102853414972/panda.jpg",""),
            listOf("너구리","Raccoon/model.glb","https://cdn.discordapp.com/attachments/997399980765618177/997400103927160873/raccoon.jpg",""),
            listOf("사슴","WhiteTailedDeer/model.glb","https://cdn.discordapp.com/attachments/997399980765618177/997400102161350727/deer.jpg",""),
            listOf("늑대","TimberWolf/model.glb","https://cdn.discordapp.com/attachments/997399980765618177/997400102454964325/wolf.jpg",""),
            listOf("백상아리","GreatWhiteShark/model.glb","https://cdn.discordapp.com/attachments/997399980765618177/997400101335081001/shark.jpg",""),
            listOf("바다거북","GreenSeaTurtle/model.glb","https://media.discordapp.net/attachments/997399980765618177/997453166297763850/turtle.jpg",""),
            listOf("악어","Alligator/model.glb","https://cdn.discordapp.com/attachments/997399980765618177/997400101838405722/nile.jpg",""),
            listOf("호랑이","Tiger/model.glb","https://cdn.discordapp.com/attachments/997399980765618177/997400103532904449/tiger.jpg","")
        )

        val sharedPreferences = binding.root.context.getSharedPreferences("account", 0)

        val token =sharedPreferences.getString("token","").toString()
        Log.d("token",token)


        /* RecyclerView 코드 작성해야 하는 부분
        * fragment/dictionary 패키지 안에다 해주시면 감사하겠습니다.
        *
        * */

        binding.seadView.visibility=View.GONE
        binding.lottieView.playAnimation()
        binding.lottieView.loop(true)
        var illustratedbookAdapter=illustratedbookAdapter()
        binding.recyclerView.layoutManager= LinearLayoutManager(binding.root.context)
        binding.recyclerView.adapter = illustratedbookAdapter

        val getCall = RetrofitClass.getApiService().getDictList(token)
        getCall.enqueue(object: Callback<DictData> {
            override fun onResponse(call: Call<DictData>, response: Response<DictData>) {
                if(response.isSuccessful) {
                    val idList = ArrayList<illustratedBookData>()
                    for(idx in response.body()!!.dict){
                        idList.add(illustratedBookData(animalDataList[idx-1][2], animalDataList[idx-1][0]))
                    }
                    Log.d("dogam",idList.toString())
                    if(idList.size>=1){
                        binding.seadView.visibility=View.GONE
                        illustratedbookAdapter.listData=idList
                        illustratedbookAdapter.notifyDataSetChanged()
                    }else{
                        binding.seadView.visibility=View.VISIBLE
                    }
                    binding.lottieView.visibility= View.GONE
                    binding.lottieView.cancelAnimation()
                }
            }

            override fun onFailure(call: Call<DictData>, t: Throwable) {
                Log.d("DictFrag","error")
            }

        })


        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DictionaryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DictionaryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}