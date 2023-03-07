package com.example.listview.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.example.listview.R
import de.hdodenhof.circleimageview.CircleImageView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val iceCreamLogo=findViewById<CircleImageView>(R.id.img_logo)
        val fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_animation)
        iceCreamLogo.startAnimation(fadeAnimation)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2500)
    }
}