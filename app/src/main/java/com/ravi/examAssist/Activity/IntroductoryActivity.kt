package com.ravi.examAssist.Activity

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.airbnb.lottie.LottieAnimationView
import com.ravi.examAssist.Fragments.OnBoardingFragment1
import com.ravi.examAssist.Fragments.OnBoardingFragment2
import com.ravi.examAssist.Fragments.OnBoardingFragment3
import com.ravi.examAssist.R

class IntroductoryActivity : AppCompatActivity() {

    var logo: ImageView? = null
    var appName: TextView? = null
    var splashImg: ImageView? = null
    var lottieAnimationView: LottieAnimationView? = null

    private var viewPager: ViewPager? = null
    private var pagerAdapter: ScreenSliderPagerAdapter? = null
    private var anim: Animation? = null
    private val NUM_PAGER = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introductory)

        logo = findViewById(R.id.logo)
        splashImg = findViewById(R.id.img)
        appName = findViewById(R.id.app_name)
        lottieAnimationView = findViewById(R.id.lottie)


        viewPager = findViewById(R.id.pager)
        pagerAdapter = ScreenSliderPagerAdapter(supportFragmentManager)
        viewPager!!.setAdapter(pagerAdapter)

        anim = AnimationUtils.loadAnimation(applicationContext, R.anim.o_b_anim)
        viewPager!!.startAnimation(anim)

        splashImg!!.animate().translationY(-1600f).setDuration(2000).setStartDelay(4000)
        logo!!.animate().translationY(1400f).setDuration(2000).setStartDelay(4000)
        appName!!.animate().translationY(1400f).setDuration(2000).setStartDelay(4000)
        lottieAnimationView!!.animate().translationY(1400f).setDuration(2000).setStartDelay(4000)

    }

    private class ScreenSliderPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> {
                    return OnBoardingFragment1()
                }
                1 -> {
                    return OnBoardingFragment2()
                }
                2 -> {
                    return OnBoardingFragment3()
                }
            }
            return OnBoardingFragment1()
        }

        override fun getCount(): Int {
            return 3
        }
    }
}