package com.neppplus.librarypractice

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val profileImg = findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.profileImg)

        profileImg.setOnClickListener {
            // 프로필 크게 보는 액티비티
            val myIntent = Intent(this, ViewProfilePhotoActivity::class.java)
            startActivity(myIntent)
        }
    }
}