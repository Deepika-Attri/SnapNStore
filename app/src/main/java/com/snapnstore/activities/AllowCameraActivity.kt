package com.snapnstore.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.snapnstore.databinding.ActivityAllowCameraBinding

class AllowCameraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAllowCameraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAllowCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.writeImagesLL.setOnClickListener {
            Intent(this, StoreImageActivity::class.java).also { intent ->
                startActivity(intent)
            }
        }

        binding.writeVideosLL.setOnClickListener {
            Intent(this, StoreVideoActivity::class.java).also { intent ->
                startActivity(intent)
            }
        }

        binding.backIv.setOnClickListener {
            finish()
        }
    }
}