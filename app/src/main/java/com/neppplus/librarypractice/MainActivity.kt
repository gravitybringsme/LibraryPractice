package com.neppplus.librarypractice

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.coroutine.TedPermission
import kotlinx.coroutines.launch

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
            // 라이브러리 활용 -> 전화 권한 확인 -> 실제 전화 연결
            val permissionListener = object:PermissionListener{
                override fun onPermissionGranted() {
                    //                // 권한이 허용된 경우 수행할 작업
                val myUri = Uri.parse("tel:010-6592-3201")
                val myIntent = Intent(Intent.ACTION_CALL, myUri)
                startActivity(myIntent)
                }

                override fun onPermissionDenied(p0: MutableList<String>?) {
                    //                // 권한이 거부된 경우 수행할 작업
                Toast.makeText(this@MainActivity, "권한이 없어서 전화연결 실패", Toast.LENGTH_SHORT).show()
                }
            }

            checkPermissionsAndMakeCall()

//            val result = TedPermission.create()
//                .setDeniedMessage("권한이 필요합니다. [설정] > [권한]에서 권한을 허용할 수 있습니다.")
//                .setPermissions(android.Manifest.permission.CALL_PHONE)
//                .check()
        }


    }
    private fun checkPermissionsAndMakeCall() {
        lifecycleScope.launch {
            val result = TedPermission.create()
                .setDeniedMessage("권한이 필요합니다. [설정] > [권한]에서 권한을 허용할 수 있습니다.")
                .setPermissions(android.Manifest.permission.CALL_PHONE)
                .check()

            if (result.isGranted) {
                // 권한이 허용된 경우 수행할 작업
                val myUri = Uri.parse("tel:010-6592-3201")
                val myIntent = Intent(Intent.ACTION_CALL, myUri)
                startActivity(myIntent)
            } else {
                // 권한이 거부된 경우 수행할 작업
                Toast.makeText(this@MainActivity, "권한이 없어서 전화연결 실패", Toast.LENGTH_SHORT).show()
            }
        }
    }
}