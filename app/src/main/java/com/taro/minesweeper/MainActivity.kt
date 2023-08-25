package com.taro.minesweeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.taro.minesweeper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val mAdapter by lazy {
        MineSweeperAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initModel()


    }

    private fun initView(){



        with(binding){
            rvMineSweeper.apply {
                layoutManager = GridLayoutManager(context, 9)
                adapter = mAdapter
            }
        }
    }

    private fun initModel(){
        val cellCreator = CellCreator()
        mAdapter.setData(cellCreator.create())
    }
}