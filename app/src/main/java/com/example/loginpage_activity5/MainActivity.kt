package com.example.loginpage_activity5

import androidx.appcompat.app.AppCompatActivity
import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import com.example.loginpage_activity5.databinding.ActivityMainBinding


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val userAccounts = ArrayList<UserAccount>()

    companion object {
        private const val SIGNUP_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUpEditTxt.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivityForResult(intent, SIGNUP_REQUEST_CODE)
        }

        binding.forgotPassEditTxt.setOnClickListener {
            Toast.makeText(applicationContext, "Forgot Password still on progress", Toast.LENGTH_SHORT).show()
        }

        binding.loginBtn.setOnClickListener {
            val usernameInput = binding.usernameEditTxt.text.toString()
            val passwordInput = binding.passwordEditTxt.text.toString()
            val matchedAccount = userAccounts.find { it.username == usernameInput && it.password == passwordInput }
            if (matchedAccount != null) {
                Toast.makeText(applicationContext, "Logging in", Toast.LENGTH_SHORT).show()
            } else if (usernameInput.isEmpty() || passwordInput.isEmpty()) {
                Toast.makeText(applicationContext, "Please Enter Username and/or Password", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Invalid Username and Password", Toast.LENGTH_SHORT).show()
            }
        }
    }
    data class UserAccount(val username: String, val password: String)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SIGNUP_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val username = data?.getStringExtra("username")
            val password = data?.getStringExtra("password")
            if (username != null && password != null) {
                userAccounts.add(UserAccount(username, password))
            }
        }
    }

}