package com.taro.minesweeper

import kotlinx.coroutines.yield
import org.junit.Assert
import org.junit.Test
import kotlin.math.min
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

    fun getNearbyMineCount(cells: List<Cell>, level: Int): List<Cell> {
        cells.forEachIndexed { index, cell ->
            if (!cell.isMine) {
                val row = index / level
                val col = index % level
                var mineCount = 0

                for (rowOffset in -1..1) {
                    for (colOffset in -1..1) {
                        val newRow = row + rowOffset
                        val newCol = col + colOffset
                        if (newRow in 0 until level && newCol in 0 until level) {
                            val adjacentIndex = newRow * level + newCol
                            if (cells[adjacentIndex].isMine) {
                                mineCount++
                            }
                        }
                    }
                }

                cell.nearbyMineCount = mineCount
            }
        }

        return cells
    }


}