package com.example.pjt105

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pjt105.databinding.ActivityMainBinding
import com.example.pjt105.fragments.HomeFragment
import com.example.pjt105.fragments.PostFragment
import com.example.pjt105.fragments.SavedFragment
import com.example.pjt105.fragments.TagsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val homeFragment = HomeFragment()
    private val postFragment = PostFragment()
    private val savedFragment = SavedFragment()
    private val tagsFragment = TagsFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        makeFragment(homeFragment)

        }


    private fun makeFragment(fragment: Fragment){
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }

        //this block is responsible for switching fragments
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home_icon -> makeFragment(homeFragment)
                R.id.add_icon -> makeFragment(postFragment)
                R.id.saved_icon -> makeFragment(savedFragment)
                R.id.tags_icon -> makeFragment(tagsFragment)
            }
            true
        }
    }



}







//supportFragmentManager.beginTransaction().apply {
//    replace(R.id.fragment_container, homeFragment)
//    commit()