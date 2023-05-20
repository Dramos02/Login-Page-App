package com.example.loginpage_activity5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginpage_activity5.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var defaultUsername:String = "admin123"
        var defaultPassword:String = "adminpass123"

        binding.loginBtn.setOnClickListener(){
            // this statement check if the user's input is equal to the defaultusername and defaultpassword
            if(binding.usernameEditTxt.text.toString() == defaultUsername && binding.passwordEditTxt.text.toString() == defaultPassword){
                Toast.makeText(applicationContext, "Logging in", Toast.LENGTH_SHORT).show()
            // this statement validates if the user doesnt put any input
            }else if (binding.usernameEditTxt.text.toString().isEmpty() || binding.passwordEditTxt.text.toString().isEmpty()){
                Toast.makeText(applicationContext, "Please Enter Username and/or Password", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(applicationContext, "Invalid Username and Password", Toast.LENGTH_SHORT).show()
            }
        }
        //  I added this functionality if ever need into the future development
        binding.signUpEditTxt.setOnClickListener(){
            Toast.makeText(applicationContext, "This is still on beta", Toast.LENGTH_SHORT).show()
        }
        // I added this functionality if ever need into the future development
        binding.forgotPassEditTxt.setOnClickListener(){
            Toast.makeText(applicationContext, "username $defaultUsername password $defaultPassword", Toast.LENGTH_SHORT).show()
        }

        //submitted by: Dominic O. Ramos 2BSIT2
        //Copyrights © https://github.com/Dramos02
    }
}
