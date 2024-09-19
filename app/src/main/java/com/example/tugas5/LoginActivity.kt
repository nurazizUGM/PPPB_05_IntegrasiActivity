package com.example.tugas5

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugas5.databinding.ActivityLoginBinding
import com.example.tugas5.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fullname = intent.getStringExtra("EXTRA_FULLNAME")
        val email = intent.getStringExtra("EXTRA_EMAIL")
        val phone = intent.getStringExtra("EXTRA_PHONE")
        val gender = intent.getStringExtra("EXTRA_GENDER")
        val password = intent.getStringExtra("EXTRA_PASSWORD")

        with(binding) {
            btnLogin.setOnClickListener {
                val inputEmail = inputEmail.text.toString()
                val inputPassword = inputPassword.text.toString()
                if (inputEmail == email && inputPassword == password) {
                    Toast.makeText(this@LoginActivity, "Login Berhasil", Toast.LENGTH_SHORT).show()
                    Intent(this@LoginActivity, ProfileActivity::class.java).apply {
                        putExtra("EXTRA_FULLNAME", fullname)
                        putExtra("EXTRA_EMAIL", email)
                        putExtra("EXTRA_PHONE", phone)
                        putExtra("EXTRA_GENDER", gender)
                        startActivity(this)
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "Login Gagal", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun showPassword(view: View) {
        val inputPassword = binding.inputPassword
        if (inputPassword.transformationMethod == null) {
            inputPassword.transformationMethod =
                android.text.method.PasswordTransformationMethod.getInstance()
        } else {
            inputPassword.transformationMethod = null
        }
    }
}