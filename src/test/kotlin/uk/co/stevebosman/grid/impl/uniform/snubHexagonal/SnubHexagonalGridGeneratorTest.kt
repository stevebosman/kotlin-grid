package uk.co.stevebosman.grid.impl.uniform.snubHexagonal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.sqrt

class SnubHexagonalGridGeneratorTest {
    @Test
    fun testStandardGenerated1by1grid() {
        val grid = instance.generate(1, 1)
        assertEquals(19, grid.cells.size)
        assertEquals(
            1,
            grid.cells.keys.filter { r -> SnubHexagonalCellType.of(r) == SnubHexagonalCellType.Hexagon }.size
        )
    }

    @Test
    fun testStandardGenerated2by2grid() {
        val grid = instance.generate(2, 2)
        assertEquals(58, grid.cells.size)
        assertEquals(
            4,
            grid.cells.keys.filter { r -> SnubHexagonalCellType.of(r) == SnubHexagonalCellType.Hexagon }.size
        )
    }

    @Test
    fun testStandardSkipLastGenerated2by2grid() {
        val grid = instance.generate(2, 2, SnubHexagonalGridOption.STANDARD_SKIP_LAST)
        assertEquals(46, grid.cells.size)
        assertEquals(
            3,
            grid.cells.keys.filter { r -> SnubHexagonalCellType.of(r) == SnubHexagonalCellType.Hexagon }.size
        )
    }

    @Test
    fun testOffsetGenerated2by2grid() {
        val grid = instance.generate(2, 2, SnubHexagonalGridOption.OFFSET)
        assertEquals(58, grid.cells.size)
        assertEquals(
            4,
            grid.cells.keys.filter { r -> SnubHexagonalCellType.of(r) == SnubHexagonalCellType.Hexagon }.size
        )
    }

    @Test
    fun testOffsetSkipLastGenerated2by2grid() {
        val grid = instance.generate(2, 2, SnubHexagonalGridOption.OFFSET_SKIP_LAST)
        assertEquals(46, grid.cells.size)
        assertEquals(
            3,
            grid.cells.keys.filter { r -> SnubHexagonalCellType.of(r) == SnubHexagonalCellType.Hexagon }.size
        )
    }

    @Test
    fun testTriangleGenerated3by3grid() {
        val grid = instance.generate(3, 3, SnubHexagonalGridOption.TRIANGLE)
        assertEquals(82, grid.cells.size)
        assertEquals(
            6,
            grid.cells.keys.filter { r -> SnubHexagonalCellType.of(r) == SnubHexagonalCellType.Hexagon }.size
        )
    }

    companion object {
        val instance = SnubHexagonalGridGenerator
        val HALF_ROOT_THREE = sqrt(3.0) / 2
    }
}