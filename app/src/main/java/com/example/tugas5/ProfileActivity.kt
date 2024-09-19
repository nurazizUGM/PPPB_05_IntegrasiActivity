package com.example.tugas5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugas5.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private val binding by lazy { ActivityProfileBinding.inflate(layoutInflater) }
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
            txtFullname.text = intent.getStringExtra("EXTRA_FULLNAME")
            txtEmail.text = intent.getStringExtra("EXTRA_EMAIL")
            txtPhone.text = intent.getStringExtra("EXTRA_PHONE")
            val gender = intent.getStringExtra("EXTRA_GENDER")
            txtGender.text = gender
            if(gender.equals("Female")){
                icGender.setImageResource(R.drawable.female_24)
            } else {
                icGender.setImageResource(R.drawable.male_24)
            }
        }
    }
}