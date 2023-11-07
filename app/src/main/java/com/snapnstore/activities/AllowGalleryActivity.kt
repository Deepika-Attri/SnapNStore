package com.snapnstore.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.snapnstore.databinding.ActivityAllowGalleryBinding

class AllowGalleryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAllowGalleryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAllowGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.readImagesLL.setOnClickListener {
            Intent(this, SelectImageActivity::class.java).also { intent ->
                startActivity(intent)
            }
        }

        binding.readVideosLL.setOnClickListener {
            Intent(this, SelectVideoActivity::class.java).also { intent ->
                startActivity(intent)
            }
        }

        binding.backIv.setOnClickListener {
            finish()
        }
    }
}