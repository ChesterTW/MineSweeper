package com.taro.minesweeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.taro.minesweeper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}