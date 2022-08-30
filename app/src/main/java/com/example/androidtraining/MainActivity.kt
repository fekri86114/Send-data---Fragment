package com.example.androidtraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.*
import com.example.androidtraining.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAnim.setOnClickListener {
            useMultipleAnimations()

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

    private fun translateAnimation() {

        val anim = TranslateAnimation(
            0f, 0f,
            0f, +1200f
        )
        anim.duration = 2000
        anim.repeatCount = 4
        anim.repeatMode = Animation.REVERSE
        anim.interpolator = AccelerateDecelerateInterpolator()
        binding.imgAnim.startAnimation(anim)

    }

    private fun scaleAnimation() :ScaleAnimation{
        val anim1 = ScaleAnimation(
            1f, 2f, 1f, 2f
        )
        anim1.duration = 2000

        // -----------------------------------------------

        val anim2 = ScaleAnimation(
            1f, 2f, 1f, 2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        )
        anim2.duration = 1000
        return anim2
    }

    private fun rotateAnimation() : RotateAnimation{
        val anim1 = RotateAnimation(0f, 360f)
        anim1.duration = 2000
        anim1.repeatCount = 5
        anim1.repeatMode = Animation.REVERSE

        // ----------------------------------------
        val anim2 = RotateAnimation(
            0f, 360f, Animation.RELATIVE_TO_SELF,
            0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        )
        anim2.duration = 2000
        anim2.repeatCount = 5
        anim2.repeatMode = Animation.REVERSE

        return anim2
    }

    private fun useMultipleAnimations() {

        val animSet = AnimationSet(true)
        animSet.addAnimation( rotateAnimation() )
        animSet.addAnimation( scaleAnimation() )
        animSet.duration = 2000
        animSet.repeatCount = 4

        binding.imgAnim.startAnimation( animSet )

    }
}