package com.taro.minesweeper

import org.junit.Assert
import org.junit.Test

class CellCreatorTest {

    @Test
    fun createCell(){
        val cellCreator = CellCreator()
        cellCreator.level = 9
        val cells: List<Cell> = cellCreator.create()
        val closeCount = cells.count { it.status == STATUS.CLOSE }
        Assert.assertEquals(81, closeCount)
    }
}