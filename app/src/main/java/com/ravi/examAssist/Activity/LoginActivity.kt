package com.ravi.examAssist.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import com.ravi.examAssist.Adapter.PagerAdapter
import com.ravi.examAssist.R

class LoginActivity : AppCompatActivity() {
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    var fb: FloatingActionButton? = null
    var google: FloatingActionButton? = null
    var twitter: FloatingActionButton? = null
    var v = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        fb = findViewById(R.id.fb)
        google = findViewById(R.id.google)
        twitter = findViewById(R.id.twitter)

        tabLayout!!.addTab(tabLayout!!.newTab().setText("Login"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Sign Up"))

        tabLayout!!.setTabGravity(TabLayout.GRAVITY_FILL)

        val adapter = PagerAdapter(supportFragmentManager, tabLayout!!.getTabCount())
        viewPager!!.setAdapter(adapter)
        viewPager!!.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))

        tabLayout!!.setOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.setCurrentItem(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        fb!!.setTranslationY(300f)
        google!!.setTranslationY(300f)
        twitter!!.setTranslationY(300f)
        tabLayout!!.setTranslationY(300f)

        fb!!.setAlpha(v)
        google!!.setAlpha(v)
        twitter!!.setAlpha(v)
        tabLayout!!.setAlpha(v)


        google!!.animate().translationY(0f).alpha(1f).setDuration(1000).setStartDelay(400).start()
        fb!!.animate().translationY(0f).alpha(1f).setDuration(1000).setStartDelay(600).start()
        twitter!!.animate().translationY(0f).alpha(1f).setDuration(1000).setStartDelay(800).start()
        tabLayout!!.animate().translationY(0f).alpha(1f).setDuration(1000).setStartDelay(400).start()


    }
}