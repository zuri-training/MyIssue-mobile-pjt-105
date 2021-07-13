package com.example.pjt105

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pjt105.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_signup)


        binding.loginText.setOnClickListener {
            val intent = Intent (this@SignupActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}