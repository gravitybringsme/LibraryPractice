package com.neppplus.librarypractice

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.neppplus.librarypractice.databinding.ActivityViewProfilePhotoBinding

class ViewProfilePhotoActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
private lateinit var binding: ActivityViewProfilePhotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivityViewProfilePhotoBinding.inflate(layoutInflater)
     setContentView(binding.root)

//        setSupportActionBar(binding.toolbar)
//
//        val navController = findNavController(R.id.nav_host_fragment_content_view_profile_photo)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//
//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null)
//                    .setAnchorView(R.id.fab).show()
//        }
    }
//
//    override fun onSupportNavigateUp(): Boolean {
//    val navController = findNavController(R.id.nav_host_fragment_content_view_profile_photo)
//    return navController.navigateUp(appBarConfiguration)
//            || super.onSupportNavigateUp()
//    }
}