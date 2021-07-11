package com.example.pjt105

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_landing_page.*
import kotlinx.android.synthetic.main.landing_page_main.*

class LandingPage : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        nav_menu.setNavigationItemSelectedListener(this)

        changeFragment(Home())
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START)

        when(item.itemId) {
            R.id.home -> {
                changeFragment(Home())
            }
            R.id.contact_us_menu -> {
                changeFragment(ContactUs_())
            }
            R.id.login_menu -> {
                val intent = Intent (this, LoginActivity::class.java)
                startActivity(intent)
            }
            R.id.get_started_menu -> {
                val intent = Intent (this, SignupActivity::class.java)
                startActivity(intent)
            }
        }
        return true
    }

    fun changeFragment(frag: Fragment) {
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.fragment_container, frag).commit()
    }
}