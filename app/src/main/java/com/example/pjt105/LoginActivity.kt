package com.example.pjt105

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val registerText: TextView = findViewById(R.id.registerText)
        registerText.setOnClickListener() {
            val intent = Intent (this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}