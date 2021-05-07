package com.ravi.examAssist

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ravi.examAssist.Activity.BaseActivity
import com.ravi.examAssist.Fragments.ProfileFragment
import com.ravi.examAssist.Fragments.SettingsFragment
import com.ravi.examAssist.ui.dashboard.DashboardFragment
import com.ravi.examAssist.ui.home.HomeFragment
import com.ravi.examAssist.ui.notifications.NotificationsFragment

class MainActivity : BaseActivity() {
    //private lateinit var appBarConfiguration: AppBarConfiguration

    var bottomNavigationView: BottomNavigationView? = null
    var mainFramLayout: FrameLayout? = null
    var fab: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutInflater.inflate(R.layout.activity_main, frameLayout)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        mainFramLayout = findViewById(R.id.mainFramLayout)
        fab = findViewById(R.id.fab)
        bottomNavigationView!!.setBackground(null)
        bottomNavigationView!!.getMenu().getItem(2).isEnabled = false
        bottomNavigationView!!.setOnNavigationItemSelectedListener(bottomNavMethod)

        loadFragments(HomeFragment())

        fab!!.setOnClickListener(View.OnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainFramLayout, ProfileFragment()).commit()
            bottomNavigationView!!.selectedItemId = R.id.navigation_profile
        })

//        setSupportActionBar(toolbar)
//        val navView: BottomNavigationView = findViewById(R.id.nav_view)
//        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
//        val navController = findNavController(R.id.nav_host_fragment)
//        appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications), drawerLayout)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)

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
                .replace(R.id.mainFramLayout, fragment)
                .commit()
        }
        return true
    }




//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment)
//        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//    }


}