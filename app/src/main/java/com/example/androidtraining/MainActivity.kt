package com.example.androidtraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.example.androidtraining.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAnim.setOnClickListener {
            alphaAnimation()

        }

    }

    private fun alphaAnimation() {

        val anim = AlphaAnimation(1f, 0f)

        // for all animations --> from here
        anim.duration = 1000
        anim.fillAfter = true
        anim.repeatCount = 5
        anim.repeatMode = Animation.REVERSE
        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {
                Log.v("testAnimation", "Anim started!")
            }

            override fun onAnimationEnd(p0: Animation?) {
                Log.v("testAnimation", "Anim ended!")
            }

            override fun onAnimationRepeat(p0: Animation?) {
                Log.v("testAnimation", "Anim repeated!")
            }
        })
        // to here

        binding.imgAnim.startAnimation(anim)

    }
}