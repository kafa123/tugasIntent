package com.example.tugasintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugasintent.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        

        with(binding){
            btnRegister.setOnClickListener{
                val intent = Intent(this@MainActivity,Register::class.java)
                startActivity(intent)
            }
            btnLogin.setOnClickListener {
                val intent = Intent(this@MainActivity,Login::class.java)
                startActivity(intent)
            }
        }

    }
}