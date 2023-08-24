package com.taro.minesweeper

import org.junit.Assert
import org.junit.Test

class CellCreatorTest {

    @Test
    fun createCell(){
        val cellCreator = CellCreator()
        cellCreator.level = 9
        val cells: List<Cell> = cellCreator.create()
        Assert.assertEquals(81, cells.count())
    }

    @Test
    fun cell_should_close(){
        val cellCreator = CellCreator()
        cellCreator.level = 9
        val cells: List<Cell> = cellCreator.create()
        val closeCount = cells.count { it.status == STATUS.CLOSE }
        Assert.assertEquals(81, closeCount)
    }

    @Test
    fun cell_should_have_15_percent_mine(){
        val cellCreator = CellCreator()
        cellCreator.level = 9
        val cells: List<Cell> = cellCreator.create()
        val mineCount = cells.count { it.isMine }
        Assert.assertEquals(13, mineCount)
    }
}