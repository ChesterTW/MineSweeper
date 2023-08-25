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
    fun cell_should_open(){
        val cellCreator = CellCreator()
        cellCreator.level = 3
        var cells: List<Cell> = cellCreator.create()
        for (element in cells){
            element.isMine = false
        }

        cells[2].isMine = true

        cells = cellCreator.open(cells, 6)

        val openCount = cells.count { it.status == STATUS.OPEN }
        Assert.assertEquals(5, openCount)
    }

    @Test
    fun cell_should_have_15_percent_mine(){
        val cellCreator = CellCreator()
        cellCreator.level = 9
        val cells: List<Cell> = cellCreator.create()
        val mineCount = cells.count { it.isMine }
        Assert.assertEquals(13, mineCount)
    }

    @Test
    fun cell_1_have_nearby_mine_count(){
        val cellCreator = CellCreator()
        cellCreator.level = 3
        var cells: List<Cell> = cellCreator.create()
        for (element in cells){
            element.isMine = false
        }
        cells[0].isMine = true
        cells[2].isMine = true
        cells[7].isMine = true


        cells = CellCreator().getNearbyMineCount(cells, cellCreator.level)

        Assert.assertEquals(2, cells[1].nearbyMineCount)
    }

    @Test
    fun cell_3_have_nearby_mine_count(){
        val cellCreator = CellCreator()
        cellCreator.level = 3
        var cells: List<Cell> = cellCreator.create()
        for (element in cells){
            element.isMine = false
        }
        cells[0].isMine = true
        cells[2].isMine = true
        cells[7].isMine = true


        cells = CellCreator().getNearbyMineCount(cells, cellCreator.level)

        Assert.assertEquals(2, cells[3].nearbyMineCount)
    }

    @Test
    fun cell_4_have_nearby_mine_count(){
        val cellCreator = CellCreator()
        cellCreator.level = 3
        var cells: List<Cell> = cellCreator.create()
        for (element in cells){
            element.isMine = false
        }
        cells[0].isMine = true
        cells[2].isMine = true
        cells[7].isMine = true


        cells = CellCreator().getNearbyMineCount(cells, cellCreator.level)

        Assert.assertEquals(3, cells[4].nearbyMineCount)
    }

    @Test
    fun cell_5_have_nearby_mine_count(){
        val cellCreator = CellCreator()
        cellCreator.level = 3
        var cells: List<Cell> = cellCreator.create()
        for (element in cells){
            element.isMine = false
        }
        cells[0].isMine = true
        cells[2].isMine = true
        cells[7].isMine = true


        cells = CellCreator().getNearbyMineCount(cells, cellCreator.level)

        Assert.assertEquals(2, cells[5].nearbyMineCount)
    }

    @Test
    fun cell_6_have_nearby_mine_count(){
        val cellCreator = CellCreator()
        cellCreator.level = 3
        var cells: List<Cell> = cellCreator.create()
        for (element in cells){
            element.isMine = false
        }
        cells[0].isMine = true
        cells[2].isMine = true
        cells[7].isMine = true


        cells = CellCreator().getNearbyMineCount(cells, cellCreator.level)

        Assert.assertEquals(1, cells[6].nearbyMineCount)
    }

    @Test
    fun cell_8_have_nearby_mine_count(){
        val cellCreator = CellCreator()
        cellCreator.level = 3
        var cells: List<Cell> = cellCreator.create()
        for (element in cells){
            element.isMine = false
        }
        cells[0].isMine = true
        cells[2].isMine = true
        cells[7].isMine = true


        cells = CellCreator().getNearbyMineCount(cells, cellCreator.level)

        Assert.assertEquals(1, cells[8].nearbyMineCount)
    }
}