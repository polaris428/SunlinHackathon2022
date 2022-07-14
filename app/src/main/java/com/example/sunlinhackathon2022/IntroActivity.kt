package com.example.sunlinhackathon2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment
import com.github.appintro.AppIntroPageTransformerType

class IntroActivity  : AppIntro() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTransformer(AppIntroPageTransformerType.Fade)
        setTransformer(
            AppIntroPageTransformerType.Parallax(
            titleParallaxFactor = 1.0,
            imageParallaxFactor = -1.0,
            descriptionParallaxFactor = 2.0
        ))
        isColorTransitionsEnabled = true
        addSlide(
            AppIntroFragment.createInstance(
                title = "Welcome...",
                titleColorRes = R.color.black,
                description = "This is the first slide of the example"

            )
        )
        addSlide(
            AppIntroFragment.createInstance(
                title = "...Let's get started!",
                titleColorRes = R.color.black,
                description = "This is the last slide, I won't annoy you more :)"
            )
        )
        addSlide(
            AppIntroFragment.createInstance(
                title = "The title of your slide",
                description = "A description that will be shown on the bottom",
                imageDrawable = R.drawable.ic_launcher_foreground,
                backgroundDrawable = R.drawable.ic_launcher_background,
                titleColorRes = R.color.black,
                descriptionColorRes = R.color.purple_700,
                backgroundColorRes = R.color.teal_700,

                )
        )
    }


    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        // Decide what to do when the user clicks on "Skip"
        finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        // Decide what to do when the user clicks on "Done"
        finish()

    }
}