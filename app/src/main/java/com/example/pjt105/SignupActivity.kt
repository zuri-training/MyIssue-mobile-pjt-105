package com.example.pjt105

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.pjt105.databinding.ActivitySignupBinding
import com.example.pjt105.db.LoginRepository
import com.example.pjt105.db.entities.LoginEntity

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var loginRepository: LoginRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.alreadySignedInTv.setOnClickListener {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//        }
        dataSetUp(binding)
    }


    private fun dataSetUp(binding: ActivitySignupBinding) {
        loginRepository = LoginRepository(this)

        val firstNameEditText = binding.editFirstName
        val lastNameEditText = binding.editLastName
        val emailEditText = binding.editEmail2
        val passwordEditText = binding.editPassword2
//        confirmPasswordEditText = binding.confirmPassword


        binding.registerButton.setOnClickListener {

            if(emailEditText.text.toString().isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener //terminate onClick instruction
            }

            loginRepository.getUserByEmail(emailEditText.text.toString()).observe(this, Observer {
                Log.e("IUKCBIAUIOVPOVPVO{", it.toString())
                if (it != null) {
                    Toast.makeText(this, "Email already in use", Toast.LENGTH_SHORT).show()
                    return@Observer
                }

                val successful = insertDataIntoDb(
                    LoginEntity(
                        firstName = firstNameEditText.text.toString(),
                        lastName = lastNameEditText.text.toString(),
                        email = emailEditText.text.toString(),
                        password = passwordEditText.text.toString()
                    )
                )

                val intent = Intent(this, LoginActivity::class.java)
                if (successful) {
                    startActivity(intent)
                }
            })
        }

    }


    private fun insertDataIntoDb(loginEntity: LoginEntity): Boolean {
        if (loginEntity.firstName.isEmpty() || loginEntity.lastName.isEmpty() || loginEntity.password.isEmpty()
        ) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            return false
        }

        if (loginEntity.password != binding.confirmPassword.text.toString()){
            Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT).show()
            return false
        }

//        if (binding.checkBox2.)



        loginRepository.saveDetails(loginEntity)
        return true
    }


}