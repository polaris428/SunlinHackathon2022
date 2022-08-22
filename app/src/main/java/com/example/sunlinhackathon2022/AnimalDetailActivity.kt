package com.example.sunlinhackathon2022

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.sunlinhackathon2022.databinding.ActivityAnimalDetailBinding
import com.example.sunlinhackathon2022.databinding.ActivityMyPageBinding
import com.example.sunlinhackathon2022.fragment.illustratedbook.ResultData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimalDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimalDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("account", 0)

        val token =sharedPreferences.getString("token","").toString()
        Log.d("token",token)

        //back code
        binding.back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        val animalDataList: List<List<String>> = listOf( // 0 이름 1 ar 2 이미지 3 디테일
            listOf("대왕판다","GiantPanda/model.glb","https://cdn.discordapp.com/attachments/997399980765618177/997400102853414972/panda.jpg","대왕판다는 주로 중국에서 사는 동물이에요. 주로 대나무를 먹는답니다. 대왕판다는 사람들이 판다가 사는곳을 파괴하거나, 허락 없이 몰래 사냥해서 멸종위기동물이 되었어요 그럼 우리는 대왕판다를 보존하기 위해서 어떤 노력이 필요할까요? 바로 판다에 대한 끊임없는 관심이 판다를 살릴 수 있어요. 지금도 세계 여러나라에서 판다에 관심을 갖게 하기 위해서 다양한 축제나 행사가 진행되고 있어요."),
            listOf("너구리","Raccoon/model.glb","https://cdn.discordapp.com/attachments/997399980765618177/997400103927160873/raccoon.jpg","너구리는 한국과 중국의 동쪽, 일본 등에 살고 있어요. 너구리는 몸에 살이 많고 특히 볼살이 통통해서 상당히 귀여워요. 주둥이가 뾰족하고 귀가 둥글둥글한 것이 특징이에요. 너구리는 원래 숲, 산, 계곡과 같은 곳에서 살아요. 하지만 사람들의 무분별한 개발로 인해 사는 곳을 잃었어요. 그래서 자주 도시에 나타나기도 한답니다. 숲과 산, 계곡을 지켜주면 너구리의 수도 늘어날거에요."),
            listOf("사슴","WhiteTailedDeer/model.glb","https://cdn.discordapp.com/attachments/997399980765618177/997400102161350727/deer.jpg","사슴의 가장 큰 특징은 뿔이에요. 보통 사슴은 숲에 살아요. 사슴은 다리가 길고 마른 느낌이 있으며, 눈망울이 매우 맑아요. 덕분에 약하고 순해 보이기도 해요. 몇몇 종류의 사슴은 멸종위기에 처해 있어요. 대부분 인간의 불법적인 사냥과 살고 있는 지역의 파괴로 인해 사슴의 수가 빠르게 감소하고 있어요. 특히 사슴의 뿔은 약재로 쓰여서 자주 사냥을 당해요. 사슴에게 많은 관심을 가져주는 것이 가장 좋은 방법일거에요"),
            listOf("늑대","TimberWolf/model.glb","https://cdn.discordapp.com/attachments/997399980765618177/997400102454964325/wolf.jpg","우리나라에서 늑대는 보통 회색늑대로 부르고, 북한에서는 승냥이라고 불러요. 늑대의 몸은 좁고 길쭉한 날렵한 몸이며, 특히 북쪽에 사는 늑대들은 털이 두꺼워 덩치가 커 보여요. 늑대는 여러 지역에서 사라질 위기에 처해 있어요. 특히 우리나라에서 늑대는 멸종위기동물 1급으로 사실상 멸종이에요. 무분별한 사냥과 생태계 교란 때문이에요. 우리나라 사람들은 한국 늑대를 야생에 복원하는 일을 하고 있어요."),
            listOf("백상아리","GreatWhiteShark/model.glb","https://cdn.discordapp.com/attachments/997399980765618177/997400101335081001/shark.jpg","백상아리는 전 세계 바다를 떠돌며 가끔 사람도 잡아먹는 무시무시한 친구에요. 현재 전 세계에서 살고 있는 상어 중에서 네번째로 큰 상어랍니다. 이렇게 무시무시한 백상아리도 멸종위기에 처해 있어요. 지구온난화 때문에 먹이가 줄어들기 때문이에요. 가장 큰 이유는 ‘샥스핀' 요리의 재료로 이용되는 상어지느러미를 얻기 위해 산채로 지느러미만 자르고 몸통은 버리는 것이에요. 캐나다 사람들은 샥스핀을 다른나라 사람들과 사고 파는것을 금지하기로 했어요."),
            listOf("바다거북","GreenSeaTurtle/model.glb","https://media.discordapp.net/attachments/997399980765618177/997453166297763850/turtle.jpg","바다거북은 북극해를 제외한 대부분의 바다에서 살아가고 있어요. 바다거북의 상징이라고 할 수 있는 등딱지는 매우 단단해서, 무시무시한 상어들이 공격해도 살 수 있어요. 바다거북이 멸종위기에 처한 가장 큰 이유는 아시아 지역에서는 고기 먹거나 악세사리를 만들기 위해서 일부러 잡기도 해요. 우리나라 사람들은 바다거북을 돕기 위해 노력하고 있어요. 다친 바다거북이 있으면 치료한 뒤에 다시 바다로 돌려보내고 있어요."),
            listOf("악어","Alligator/model.glb","https://cdn.discordapp.com/attachments/997399980765618177/997400101838405722/nile.jpg","악어는 길이가 긴 동물로 가장 큰 악어는 4m를 넘어가요. 악어는 도마뱀처럼 꼬리를 자르면 다시 자라나요. 악어는 대부분 다른 동물들을 잡아먹어요. 바다에 사는 악어는 고래를 먹는 모습이 발견되기도 했다네요. 몇몇 종류의 악어들은 가죽을 얻기 위한 사람들의 사냥으로 인해 멸종위기에 처해있어요. 악어를 지키기 위해서는 사람들이 악어 가죽으로 만든 물건을 사지 말아야해요."),
            listOf("호랑이","Tiger/model.glb","https://cdn.discordapp.com/attachments/997399980765618177/997400103532904449/tiger.jpg","동화책에 자주 등장하는 호랑이! 호랑이는 여러종류가 있어요. 하지만 여러 종류중 다섯 종류나 멸종했답니다. 이렇게 호랑이가 멸종한 이유는 무엇일까요? 호랑이가 살고 있는 곳이 파괴되거나, 사람들이 호랑이를 허락받지 않고 사냥해서 호랑이의 수가 많이 줄어들었어요. 특히나 아시아의 몇몇 나라에서는 호랑이는 부자의 상징이라서 많은 사냥이 일어나고 있어요. 호랑이를 지키기 위해서는 호랑이가 살고 있는 지역을 지켜줘야 해요.")
        )
        val SoundUrlBase = "https://storage.googleapis.com/ar-answers-in-search-models/static/"
        val animalSoundUrlList: List<String> = listOf(
            "GiantPanda/Bear_Panda_Giant_Unisex_Adult.mp3",
            "Raccoon/Raccoon_Common_Unisex_Adult.mp3",
            "WhiteTailedDeer/Deer_WhiteTailed_Male_Adult.mp3",
            "TimberWolf/Canine_Wolf_Timber_Unisex_Adult.mp3",
            "GreatWhiteShark/Shark_GreatWhite_Unisex_Adult.mp3",
            "GreenSeaTurtle/Turtle_GreenSea_Unisex_Adult.mp3",
            "Alligator/Alligatar.mp3",
            "Tiger/Tiger.mp3"
        )

        val animalARBaseUrl = "https://storage.googleapis.com/ar-answers-in-search-models/static/"
        val animalCode = intent.getStringExtra("animalCode")!!.toInt() - 1
        val animalImageUrl: String = animalDataList[animalCode][2]
        val animalName: String = animalDataList[animalCode][0]
        val animalARUrl: String = animalDataList[animalCode][1]
        val animalDetail: String = animalDataList[animalCode][3]
        val animalsound: String = SoundUrlBase + animalSoundUrlList[animalCode]

        Glide.with(this)
            .load(animalImageUrl)
            .into(binding.animalImageView)


        binding.animalName.text = animalName
        binding.animalExplanation.text = animalDetail

        binding.payButton.setOnClickListener {

                val ARIntent = Intent(this, ArWebViewActivity::class.java)
                val sceneViewerIntent = Intent(Intent.ACTION_VIEW)
                val intentUri = Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                    .appendQueryParameter("file",animalARBaseUrl+animalARUrl)
                    .appendQueryParameter("mode","ar_preferred")
                    .appendQueryParameter("sound",animalsound)
                    .appendQueryParameter("title", animalName)
                    .build()
                sceneViewerIntent.data = intentUri
                startActivity(sceneViewerIntent)
        }

        val getCall = RetrofitClass.getApiService().addDict(token, (animalCode+1).toString())
        getCall.enqueue(object : Callback<ResultData> {
            override fun onResponse(
                call: Call<ResultData>,
                response: Response<ResultData>
            ) {
                if(response.isSuccessful) {

                }
            }

            override fun onFailure(call: Call<ResultData>, t: Throwable) {
                Log.d("mini_endaged","error")
            }

        })




    }
}