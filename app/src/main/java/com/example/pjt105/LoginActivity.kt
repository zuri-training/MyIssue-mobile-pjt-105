package com.example.pjt105

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.pjt105.databinding.ActivityLoginBinding
import com.example.pjt105.db.LoginRepository
import com.example.pjt105.fragments.HomeFragment

class LoginActivity : AppCompatActivity() {


    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginRepository: LoginRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginRepository = LoginRepository(this)

        binding.loginButton.setOnClickListener {
            logMeIn()
        }
    }


    private fun logMeIn() {
        val email = binding.editLoginEmail
        val password = binding.editLoginPassword

        loginRepository.getUserByEmail(email.text.toString()).observe(this, Observer {
            if (it == null) {
                Toast.makeText(this, "User not found, please sign-up", Toast.LENGTH_SHORT).show()
                return@Observer
            }
            val passwordMatch = password.text.toString() == it.password

            if (!passwordMatch) {
                Toast.makeText(this, "Incorrect password", Toast.LENGTH_SHORT).show()
                return@Observer
            }


            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

    }
}