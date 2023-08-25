package com.taro.minesweeper


import android.util.Log
import kotlin.random.Random

class CellCreator {

    var level: Int = 9

    fun create(): List<Cell> {

        val mineIndex = createRandomIndexes(level)

        val list = mutableListOf<Cell>()
        (0 until level).forEach { x ->
            (0 until level).forEach { y ->
                val cell = Cell()

                val number = x * level + y
                cell.isMine = false
                if(mineIndex.any { it == number }){
                    cell.isMine = true
                }

                cell.status = STATUS.CLOSE
                list.add(cell)
            }
        }

        return getNearbyMineCount(list, level)
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

    fun open(cells: List<Cell>, openIndex: Int): List<Cell> {
        val adjacentOffsets = listOf(
            -level - 1, -level, -level + 1,
            -1, +1,
            level - 1, level, level + 1
        )

        val clickedCell = cells[openIndex]

        var Newcell = cells

        // 如果点击的单元格有地雷或已经打开，直接返回
        if (clickedCell.isMine || clickedCell.status == STATUS.OPEN) {
            return Newcell
        } else {
            Newcell[openIndex].status = STATUS.OPEN

            val shouldOpenAdjacentCells = clickedCell.nearbyMineCount == 0

            if (shouldOpenAdjacentCells) {
                for (offset in adjacentOffsets) {
                    val neighborIndex = openIndex + offset
                    if (isValidIndex(neighborIndex) && Newcell[neighborIndex].status != STATUS.OPEN) {
                        Newcell = open(Newcell, neighborIndex)  // 直接递归调用 open() 函数
                    }
                }
            }
        }

        return Newcell
    }


    private fun isValidIndex(index: Int): Boolean {
        return index >= 0 && index < level * level
    }

}