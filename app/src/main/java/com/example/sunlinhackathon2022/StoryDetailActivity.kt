package com.example.sunlinhackathon2022

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sunlinhackathon2022.databinding.ActivityStoryDetailBinding

class StoryDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStoryDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener {
            finish()
        }
        val animalARBaseUrl = "https://storage.googleapis.com/ar-answers-in-search-models/static/"
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
        val animal = intent.getStringExtra("animal")
        when (animal) {
            "tiger" -> {
                binding.arBtn.setOnClickListener {
//                    val ARIntent = Intent(this, ArWebViewActivity::class.java)
//                    ARIntent.putExtra("arUrl",animalARBaseUrl+"Tiger/model.glb")
//                    startActivity(ARIntent)

                    val ARIntent = Intent(this, ArWebViewActivity::class.java)
                    val sceneViewerIntent = Intent(Intent.ACTION_VIEW)
                    val intentUri = Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                        .appendQueryParameter("file",animalARBaseUrl+"Tiger/model.glb")
                        .appendQueryParameter("mode","ar_preferred")
                        .appendQueryParameter("sound",SoundUrlBase+animalSoundUrlList[7])
                        .appendQueryParameter("title", "호랑이")
                        .build()
                    sceneViewerIntent.data = intentUri
                    startActivity(sceneViewerIntent)


                }
                binding.title.text = "호랑이의 이야기"
                binding.animalName.text = "호랑이"
                binding.animalImageView.setImageResource(R.drawable.tiger_story)
                binding.animalInfo.text = """안녕!
나는 방글라데시에서 사는 호랑이야.

요즘 고민이 하나 생겼어ㅠ...
점점 친구 호랑이들이 어디 갔는지 안보이더라고.
근데 내 친구 호랑이들만 그런 게 아니더라.
저 옆에 내 친척 벵골호랑이는
10가족밖에 남지 않았대.

나도 곧 사라지는 걸까?"""
                binding.text2.text = "호랑이를 살리려면?"
                binding.animalHelp.text = """나를 살리기 위해서는 우선 우리 집을 지켜줘야 해.
우리 집은 숲속에 숨겨져 있는데 요즘 인간들이
침입해서 파괴하고 있어.
팜유 농장을 세운다나? 

요즘 듣기로는 우리 집을 파괴하지 않고
만들 수 있는 팜유가 있다고 들었어.
그 팜유를 주로 사용해준다면 우릴 살릴 수 있어!"""
            }
            "wolf"->{
                binding.arBtn.setOnClickListener {
//                    val ARIntent = Intent(this, ArWebViewActivity::class.java)
//                    ARIntent.putExtra("arUrl",animalARBaseUrl+"TimberWolf/model.glb")
//                    startActivity(ARIntent)

                    val ARIntent = Intent(this, ArWebViewActivity::class.java)
                    val sceneViewerIntent = Intent(Intent.ACTION_VIEW)
                    val intentUri = Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                        .appendQueryParameter("file",animalARBaseUrl+"TimberWolf/model.glb")
                        .appendQueryParameter("mode","ar_preferred")
                        .appendQueryParameter("sound",SoundUrlBase+animalSoundUrlList[3])
                        .appendQueryParameter("title", "늑대")
                        .build()
                    sceneViewerIntent.data = intentUri
                    startActivity(sceneViewerIntent)
                }
                binding.title.text = "늑대의 이야기"
                binding.animalName.text = "늑대"
                binding.animalImageView.setImageResource(R.drawable.wolf_story)
                binding.animalInfo.text = """..안녕
나는 늑대다.

최근 내 반려자..., 아내가 하늘나라로 떠났지...
먼저 떠난 아내를 위해서라도 남은 아이들은
지켜내야 해.

제발 우리 아이들을 지켜줘, 부탁이다."""
                binding.text2.text = "늑대를 살리려면?"
                binding.animalHelp.text = """너희 인간 중 사냥꾼이란 직업이 문제다.
그 녀석들은 몰래 우리 서식지로 들어온 거 같더군.
그리곤 내 아내를..., 잡아갔지.

그 녀석들을 너희 세계의 규칙으로 막고 신고를
해주면 도움이 될 것 같다.
 """
            }

            "tortoise"->{
                binding.arBtn.setOnClickListener {
//                    val ARIntent = Intent(this, ArWebViewActivity::class.java)
//                    ARIntent.putExtra("arUrl",animalARBaseUrl+"GreenSeaTurtle/model.glb")
//                    startActivity(ARIntent)
                    val ARIntent = Intent(this, ArWebViewActivity::class.java)
                    val sceneViewerIntent = Intent(Intent.ACTION_VIEW)
                    val intentUri = Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                        .appendQueryParameter("file",animalARBaseUrl+"GreenSeaTurtle/model.glb")
                        .appendQueryParameter("mode","ar_preferred")
                        .appendQueryParameter("sound",SoundUrlBase+animalSoundUrlList[5])
                        .appendQueryParameter("title", "바다거북")
                        .build()
                    sceneViewerIntent.data = intentUri
                    startActivity(sceneViewerIntent)
                }
                binding.title.text = "바다거북의 이야기"
                binding.animalName.text = "바다거북"
                binding.animalImageView.setImageResource(R.drawable.tortoise_story)
                binding.animalInfo.text = """거북~
나는 거북이야 바다에서 살고 있지.

요즘 바다에 헤엄치면 쓰레기들이 내 앞을 가려서
놀러 가는 게 쉽지 않아.
다른 친구들은 쓰레기들 때문에 다친 적도 있어.

헤엄칠 때마다 다치게 될까 무서워..."""
                binding.text2.text = "거북이를 살리려면?"
                binding.animalHelp.text = """너무 바다에 쓰레기가 많은 것이 가장 큰 문제야.
우리가 헤엄치는 바다에 들어오는 쓰레기를 
줄여주면 좋을 거 같아.

너희가 바닷가에 놀러 가면 보이는 쓰레기들을 
주워준다면 도움이 될 거 같아!
 """
            }
            "panda"->{
                binding.arBtn.setOnClickListener {
//                    val ARIntent = Intent(this, ArWebViewActivity::class.java)
//                    ARIntent.putExtra("arUrl",animalARBaseUrl+"GiantPanda/model.glb")
//                    startActivity(ARIntent)
                    val ARIntent = Intent(this, ArWebViewActivity::class.java)
                    val sceneViewerIntent = Intent(Intent.ACTION_VIEW)
                    val intentUri = Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                        .appendQueryParameter("file",animalARBaseUrl+"GiantPanda/model.glb")
                        .appendQueryParameter("mode","ar_preferred")
                        .appendQueryParameter("sound",SoundUrlBase+animalSoundUrlList[0])
                        .appendQueryParameter("title", "대왕판다")
                        .build()
                    sceneViewerIntent.data = intentUri
                    startActivity(sceneViewerIntent)
                }
                binding.title.text = "판다의 이야기"
                binding.animalName.text = "판다"
                binding.animalImageView.setImageResource(R.drawable.panda_story)
                binding.animalInfo.text = """안녕?
나는 대나무를 정말로 좋아하는 대왕판다야

난 중국에 있는 쓰촨성 지역에서 살고 있어.

너희들이 태어나기도 전 아주 옛날에는,
나는 중국 중 남쪽에 많이 살았어. 하지만 지금은 중국 쓰촨성 지역에 대략 1,800마리가 모여 살고 있지. 내 친구인 친링판다는 야생에 200마리밖에 없어. 이마저도 중국에서 우리 판다를 잘 관리하고 있어서 이만큼 있는 거야."""
                binding.text2.text = "판다를 살리려면?"
                binding.animalHelp.text = """우리 판다들이 줄어든 이유는 우리의 서식지를 인간들이 파괴해서야.
                  
우리의 수가 늘어나기 위해서는 우리의 집을 너희 인간들이 보호해줘야 해.
그러니까 너희들이 산을 지켜줘야 해. 난 네가 할 수 있다고 생각해!"""
            }

        }
    }
}