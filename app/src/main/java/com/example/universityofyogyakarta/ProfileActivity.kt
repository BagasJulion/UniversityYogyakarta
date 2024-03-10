package com.example.universityofyogyakarta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProfileActivity : AppCompatActivity() {
    private lateinit var tvName: TextView
    private lateinit var tvDes: TextView
    private lateinit var ivLogo: ImageView
    private lateinit var btnShare: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvName = findViewById(R.id.tv_name)
        tvDes = findViewById(R.id.tv_des)
        ivLogo = findViewById(R.id.iv_logo)
        btnShare = findViewById(R.id.btn_action_share)

        val name = intent.getStringExtra("EXTRA_NAME")
        val des = intent.getStringExtra("EXTRA_DES")
        val photo = intent.getStringExtra("EXTRA_PHOTO")

        tvName.text = name
        tvDes.text = des
        Glide.with(this)
            .load(photo)
            .into(ivLogo)
    }
}