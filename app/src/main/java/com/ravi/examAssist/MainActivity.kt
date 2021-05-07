package com.ravi.examAssist

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ravi.examAssist.Activity.BaseActivity
import com.ravi.examAssist.Fragments.ProfileFragment
import com.ravi.examAssist.Fragments.SettingsFragment
import com.ravi.examAssist.ui.dashboard.DashboardFragment
import com.ravi.examAssist.ui.home.HomeFragment
import com.ravi.examAssist.ui.notifications.NotificationsFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.base_layout.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutInflater.inflate(R.layout.activity_main,content_frame)

        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(2).isEnabled = false
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod)

        loadFragments(HomeFragment())
        fab.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainFrameLayout, ProfileFragment()).commit()
            bottomNavigationView.selectedItemId = R.id.navigation_profile
        }
    }
    private val bottomNavMethod =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            var fragment: Fragment? = null
            when (menuItem.itemId) {
                R.id.navigation_home -> fragment = HomeFragment()
                R.id.navigation_dashboard -> fragment = DashboardFragment()
                R.id.navigation_notifications -> fragment = NotificationsFragment()
                R.id.navigation_setting -> fragment = SettingsFragment()
            }
            loadFragments(fragment)
        }

    override fun onBackPressed() {
        if (bottomNavigationView!!.selectedItemId == R.id.navigation_home) {
            super.onBackPressed()
            finish()
        } else {
            bottomNavigationView!!.selectedItemId = R.id.navigation_home
        }
    }

    private fun loadFragments(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainFrameLayout, fragment)
                .commit()
        }
        return true
    }
}