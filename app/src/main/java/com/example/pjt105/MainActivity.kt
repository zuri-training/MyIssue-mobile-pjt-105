package com.example.pjt105

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pjt105.databinding.ActivityMainBinding
import com.example.pjt105.fragments.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    //bottom nav fragments instantiation
    private val homeFragment = HomeFragment()
    private val postFragment = PostFragment()
    private val savedFragment = SavedFragment()
    private val tagsFragment = TagsFragment()

    //drawer nav fragments instantiation
    private val groupFragment = GroupFragment()
    private val eventsFragment = EventsFragment()
    private val notificationFragment = NotificationFragment()
    private val lifeStreamingFragment = LiveStreamingFragment()
    private val settingsFragment = SettingsFragment()
    private val historyFragment = HistoryFragment()
    private val blogFragment = BlogFragment()
    private val findFriendsFragment = FindFriendsFragment()
    private val privacyFragment = PrivacyFragment()
    private val helpsFragment = HelpsFragment()

    lateinit var toggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeFragment(homeFragment)

    }


    private fun changeFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()

        //this block is responsible for switching bottom navigation fragments
        binding.bottomNavigation.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.home_icon -> changeFragment(homeFragment)
                R.id.add_icon -> changeFragment(postFragment)
                R.id.saved_icon -> changeFragment(savedFragment)
                R.id.tags_icon -> changeFragment(tagsFragment)
            }
            true
        }


        binding.navView.setNavigationItemSelectedListener {

            it.isCheckable = true

            //this block is responsible for switching drawer navigation fragments
            when(it.itemId){
                R.id.menu_home_icon -> replaceFragment(homeFragment, it.title.toString())
                R.id.group_icon -> replaceFragment(groupFragment, it.title.toString())
                R.id.events_icon -> replaceFragment(eventsFragment, it.title.toString())
                R.id.notification_icon -> replaceFragment(notificationFragment, it.title.toString())
                R.id.live_streaming_icon -> replaceFragment(lifeStreamingFragment, it.title.toString())
                R.id.settings_icon -> replaceFragment(settingsFragment, it.title.toString())
                R.id.history_icon -> replaceFragment(historyFragment, it.title.toString())
                R.id.blog_icon -> replaceFragment(blogFragment, it.title.toString())
                R.id.find_friends_icon -> replaceFragment(findFriendsFragment, it.title.toString())
                R.id.privacy_icon -> replaceFragment(privacyFragment, it.title.toString())
                R.id.helps_icon -> replaceFragment(helpsFragment, it.title.toString())
            }
            true
        }


    }


    private fun replaceFragment(fragment: Fragment, title: String){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
        binding.drawerLayout.closeDrawers()
        setTitle(title)
    }



}

