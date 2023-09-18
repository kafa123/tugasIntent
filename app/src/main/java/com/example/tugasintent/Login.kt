package com.example.tugasintent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.tugasintent.databinding.ActivityLoginBinding

private lateinit var binding: ActivityLoginBinding
class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            binding.login.setOnClickListener{
                val username = binding.textUsername.text.toString()
                val password = binding.textPassword.text.toString()
                val name = intent.getStringExtra(Register.EXTRA_USERNAME)
                val email = intent.getStringExtra(Register.EXTRA_EMAIL)
                val phone = intent.getStringExtra(Register.EXTRA_TELPON)

                val isAuthenticated = authenticate(username,password)

                if (isAuthenticated){
                    val intent = Intent(this@Login,HomePage::class.java)
                    intent.putExtra(Register.EXTRA_USERNAME,name)
                    intent.putExtra(Register.EXTRA_EMAIL,email)
                    intent.putExtra(Register.EXTRA_TELPON,phone)
                    startActivity(intent)
                }
                else{
                    binding.layoutPassword.error="invalid username or password"
                }
            }
            belumPunyaAkun.setOnClickListener{
                val intent =Intent (this@Login,Register::class.java)
                startActivity(intent)
            }
            btnLogin.setOnClickListener {
                binding.layoutPassword.error="kamu Tolol bangets"
            }

        }
    }

    private fun authenticate(username: String, password: String): Boolean {
        return username==intent.getStringExtra(Register.EXTRA_USERNAME) && password==intent.getStringExtra(Register.EXTRA_PASSWORD)
    }
}