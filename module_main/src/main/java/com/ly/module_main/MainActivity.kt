package com.ly.module_main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ly.module_main.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.name.text = "this is test";

    }


}