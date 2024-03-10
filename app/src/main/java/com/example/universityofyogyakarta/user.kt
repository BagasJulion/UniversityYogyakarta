package com.example.universityofyogyakarta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class user : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)


        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("User Profile")
    }

}