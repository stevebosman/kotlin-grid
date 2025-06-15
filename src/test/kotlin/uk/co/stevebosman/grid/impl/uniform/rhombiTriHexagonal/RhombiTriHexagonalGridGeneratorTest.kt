package uk.co.stevebosman.grid.impl.uniform.rhombiTriHexagonal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.sqrt

class RhombiTriHexagonalGridGeneratorTest {
    @Test
    fun testStandardGenerated1by1grid() {
        val grid = instance.generate(1, 1)
        assertEquals(13, grid.cells.size)
        assertEquals(
            1,
            grid.cells.keys.filter { r -> RhombiTriHexagonalCellType.of(r) == RhombiTriHexagonalCellType.Hexagon }.size
        )
    }

    @Test
    fun testStandardGenerated2by2grid() {
        val grid = instance.generate(2, 2)
        assertEquals(39, grid.cells.size)
        assertEquals(
            4,
            grid.cells.keys.filter { r -> RhombiTriHexagonalCellType.of(r) == RhombiTriHexagonalCellType.Hexagon }.size
        )
    }

    @Test
    fun testStandardSkipLastGenerated2by2grid() {
        val grid = instance.generate(2, 2, RhombiTriHexagonalGridOption.STANDARD_SKIP_LAST)
        assertEquals(31, grid.cells.size)
        assertEquals(
            3,
            grid.cells.keys.filter { r -> RhombiTriHexagonalCellType.of(r) == RhombiTriHexagonalCellType.Hexagon }.size
        )
    }

    @Test
    fun testOffsetGenerated2by2grid() {
        val grid = instance.generate(2, 2, RhombiTriHexagonalGridOption.OFFSET)
        assertEquals(39, grid.cells.size)
        assertEquals(
            4,
            grid.cells.keys.filter { r -> RhombiTriHexagonalCellType.of(r) == RhombiTriHexagonalCellType.Hexagon }.size
        )
    }

    @Test
    fun testOffsetSkipLastGenerated2by2grid() {
        val grid = instance.generate(2, 2, RhombiTriHexagonalGridOption.OFFSET_SKIP_LAST)
        assertEquals(31, grid.cells.size)
        assertEquals(
            3,
            grid.cells.keys.filter { r -> RhombiTriHexagonalCellType.of(r) == RhombiTriHexagonalCellType.Hexagon }.size
        )
    }

    @Test
    fun testTriangleGenerated3by3grid() {
        val grid = instance.generate(3, 3, RhombiTriHexagonalGridOption.TRIANGLE)
        assertEquals(55, grid.cells.size)
        assertEquals(
            6,
            grid.cells.keys.filter { r -> RhombiTriHexagonalCellType.of(r) == RhombiTriHexagonalCellType.Hexagon }.size
        )
    }

    companion object {
        val instance = RhombiTriHexagonalGridGenerator
        val HALF_ROOT_THREE = sqrt(3.0) / 2
    }
}