package com.taro.minesweeper

import kotlinx.coroutines.yield
import org.junit.Assert
import org.junit.Test
import kotlin.random.Random

class CellCreator {

    var level: Int = 0

    fun create(): List<Cell> {

        val mineIndex = createRandomIndexes(level)

        val list = mutableListOf<Cell>()
        (0 until level).forEach { x ->
            (0 until level).forEach { y ->
                val cell = Cell()

                val number = x * level + y
                cell.isMine = false
                if(mineIndex.filter { it == number }.isNotEmpty()){
                    cell.isMine = true
                }

                cell.status = STATUS.CLOSE
                list.add(cell)
            }
        }

        return list
    }

    private fun createRandomIndexes(cellSize: Int): MutableList<Int>{
        val mineIndexes: MutableList<Int> = mutableListOf()

        val random = Random

        while (mineIndexes.count() < cellSize * cellSize * 0.15){
            val nexInt = random.nextInt(cellSize * cellSize -1)
            if(mineIndexes.none { it == nexInt }) {
                mineIndexes.add(nexInt)
            }
        }

        return mineIndexes
    }


}