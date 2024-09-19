package com.example.tugas5

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugas5.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding) {
            btnRegister.setOnClickListener {
                val fullname = inputFullname.text.toString()
                val email = inputEmail.text.toString()
                val phone = inputPhone.text.toString()
                val gender = findViewById<RadioButton>(inputGender.checkedRadioButtonId)
                val password = inputPassword.text.toString()

                val intent = Intent(this@MainActivity, LoginActivity::class.java)
                intent.putExtra("EXTRA_FULLNAME", fullname)
                intent.putExtra("EXTRA_EMAIL", email)
                intent.putExtra("EXTRA_PHONE", phone)
                intent.putExtra("EXTRA_GENDER", gender.text.toString())
                intent.putExtra("EXTRA_PASSWORD", password)
                startActivity(intent)
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