package com.example.androidtraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidtraining.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOpenFirstFragment.setOnClickListener {

            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.frame_main_container, FirstFragment())
            transaction.addToBackStack(null)
            transaction.commit()

        }

    }
}