package com.example.loginpage_activity5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginpage_activity5.databinding.ActivitySignupBinding
import android.content.Intent
import android.app.Activity
import android.widget.Toast

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createAccountButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            if (username.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent().apply {
                    putExtra("username", username)
                    putExtra("password", password)
                }
                Toast.makeText(applicationContext,"Registration Complete", Toast.LENGTH_SHORT)
                    .show()
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else {
                Toast.makeText(applicationContext,"Username/Password cannot be empty",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        binding.GoBacktoMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }
}