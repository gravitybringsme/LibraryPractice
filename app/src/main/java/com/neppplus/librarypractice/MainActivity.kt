package com.neppplus.librarypractice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

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

        //인터넷에 있는 이미지 를 이미지뷰에 대입

        val imageView = findViewById<ImageView>(R.id.lectureImg1);


        Glide.with(this).load("https://goo.gl/gEgYUd").into(imageView);

        //전화걸기 버튼 누르면 => 권한 확인 / 전화 연결

        val callBtn = findViewById<Button>(R.id.callBtn);

        callBtn.setOnClickListener {
            //라이브러리 활용 -> 전화 권한 확인 -> 실제 전화 연결
        }
    }
}