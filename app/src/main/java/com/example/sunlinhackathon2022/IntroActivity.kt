package com.example.sunlinhackathon2022

import android.content.Intent
import android.graphics.Color.blue
import android.graphics.Color.red
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntro2
import com.github.appintro.AppIntroFragment
import com.github.appintro.AppIntroPageTransformerType

class IntroActivity : AppIntro2() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTransformer(AppIntroPageTransformerType.Fade)
        isWizardMode = true
        setImmersiveMode()
        setIndicatorColor(
            selectedIndicatorColor = getColor(R.color.purple_200),
            unselectedIndicatorColor = getColor(R.color.black)
        )
        setTransformer(
            AppIntroPageTransformerType.Parallax(
                titleParallaxFactor = 1.0,
                imageParallaxFactor = -1.0,
                descriptionParallaxFactor = 2.0
            )
        )
        isColorTransitionsEnabled = true
        addSlide(
            AppIntroFragment.createInstance(
                title = "QR코드를 찍으세요",
                titleColorRes = R.color.black,
                description = "qr코드를 찍어 멸종 위기 동물을 알아봐요",
                descriptionColorRes = R.color.black,
                imageDrawable = R.drawable.qr

                )
        )
        addSlide(
            AppIntroFragment.createInstance(
                title = "동물을 구해주세요",
                titleColorRes = R.color.black,
                description = "미니게임을 통해 멸종 위기 동물을 구해주세요",

                descriptionColorRes = R.color.black,
                imageDrawable = R.drawable.ic_resuce,
            )
        )
        addSlide(
            AppIntroFragment.createInstance(
                title = "동물을 보호해주세요",
                description = "멸종위기 동물들을 보호해 오래동안 볼 수 있도록 보호해주세요",
                imageDrawable = R.drawable.ic_protect,
                titleColorRes = R.color.black,
                descriptionColorRes = R.color.black
                //backgroundColorRes = R.color.teal_700,

                )
        )
    }


    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        // Decide what to do when the user clicks on "Skip"
        finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

    }
}