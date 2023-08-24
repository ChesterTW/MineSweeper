package com.taro.minesweeper

import org.junit.Assert
import org.junit.Test

class CellCreator {

    var level: Int = 0

    fun create(): List<Cell> {
        var list = mutableListOf<Cell>()
        (0 until level).forEach {
            (0 until level).forEach {
                val cell = Cell()
                cell.status = STATUS.CLOSE
                list.add(cell)
            }
        }

        return list
    }


}