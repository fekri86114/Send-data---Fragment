package com.example.androidtraining

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtraining.databinding.ActivityMain4Binding
import com.example.androidtraining.extra.BaseActivity

class MainActivity4 : BaseActivity() {
    lateinit var binding: ActivityMain4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}