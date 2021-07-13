package com.example.pjt105

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.pjt105.databinding.ActivityLandingPageBinding
import com.example.pjt105.databinding.LandingPageMainBinding
import com.google.android.material.navigation.NavigationView


class LandingPage : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityLandingPageBinding
    private lateinit var binding1: LandingPageMainBinding
    private lateinit var homeFragment:Home2
    private lateinit var contactUsFragment : ContactUs_

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding1.toolbar)
        val actionBar = supportActionBar
        actionBar?.title = null

        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding1.toolbar, R.string.open, R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)
        homeFragment = Home2()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.home -> {
                homeFragment = Home2()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, homeFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.contact_us_menu -> {
                contactUsFragment = ContactUs_()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, contactUsFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
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

}