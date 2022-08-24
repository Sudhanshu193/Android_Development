package com.example.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginpage.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
      //  var newUser = findViewById<TextView>(R.id.gotoRegister)
        binding.Register.setOnClickListener {
        val intent = Intent( this, register:: class.java)
            startActivity(intent)
        }
        binding.forgotPass.setOnClickListener {
            val intent = Intent(this, PasswordForgot::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener {
            val email = binding.inputEmail.text.toString()
            val password = binding.TextPassword.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty())
            {

                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful) {
                        val intent = Intent(this, homePage::class.java)
                        startActivity(intent)
                    }else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this, "Enter the Field", Toast.LENGTH_SHORT).show()
            }
        }


    }
}