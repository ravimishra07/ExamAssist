package com.ravi.examAssist.Activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.ravi.examAssist.MainActivity
import com.ravi.examAssist.R
import com.ravi.examAssist.ui.dashboard.DashboardFragment
import com.ravi.examAssist.ui.notifications.NotificationsFragment


open class BaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var drawerLayout: DrawerLayout? = null
    var toolbar: Toolbar? = null
    var frameLayout: FrameLayout? = null
    var navigationView: NavigationView? = null
    var userLoginImg: ImageView? = null
    var userName: TextView? = null
    var userEmail: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        init()
    }

    private fun init() {
        toolbar = findViewById(R.id.toolbar)
        toolbar!!.setTitleTextColor(resources.getColor(R.color.white))
        setSupportActionBar(toolbar)
        frameLayout = findViewById(R.id.content_frame)
        drawerLayout = findViewById(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout!!.setDrawerListener(toggle)
        //        toggle.setHomeAsUpIndicator(R.drawable.ic_setting);
        toggle.syncState()
        navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        val header = navigationView!!.getHeaderView(0)
        userLoginImg = header.findViewById(R.id.userLoginImg)
        userName = header.findViewById(R.id.userName)
        userEmail = header.findViewById(R.id.userEmail)

//        Glide.with(getApplicationContext()).load(sharedPreference_main.getUserImage()).placeholder(R.drawable.user_icon).into(userLoginImg);
//        userName.setText(sharedPreference_main.getUsername());
//        userEmail.setText(sharedPreference_main.getUserEmail());

        navigationView!!.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.isChecked) {
            drawerLayout!!.closeDrawer(GravityCompat.START)
            return true
        }
        when (item.itemId) {
            R.id.navigation_home -> {
                val intent = Intent(applicationContext, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }

            else -> drawerLayout!!.closeDrawer(GravityCompat.START)
        }
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
            drawerLayout!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}