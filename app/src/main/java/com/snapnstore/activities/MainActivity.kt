package com.snapnstore.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.snapnstore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cameraLL.setOnClickListener {
            Intent(this, AllowCameraActivity::class.java).also { intent ->
                startActivity(intent)
            }
        }

        binding.galleryLL.setOnClickListener {
            Intent(this, AllowGalleryActivity::class.java).also { intent ->
                startActivity(intent)

            }
        }
    }
}