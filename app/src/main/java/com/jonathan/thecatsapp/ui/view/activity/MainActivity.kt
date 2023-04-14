package com.jonathan.thecatsapp.ui.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jonathan.thecatsapp.R
import com.jonathan.thecatsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}