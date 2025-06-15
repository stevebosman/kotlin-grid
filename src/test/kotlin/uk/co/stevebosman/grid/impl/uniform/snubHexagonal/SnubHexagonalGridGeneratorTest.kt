package uk.co.stevebosman.grid.impl.uniform.snubHexagonal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.test.GridAssertions.assertContains
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
    fun testStandardGenerated1by2grid() {
        val grid = instance.generate(1, 2)
        assertEquals(34, grid.cells.size, "Unexpected cells: ${grid.cells.keys}")
        assertEquals(
            2,
            grid.cells.keys.filter { r -> SnubHexagonalCellType.of(r) == SnubHexagonalCellType.Hexagon }.size
        )
        assertAll({
            assertContains(
                grid.cells, GridReference(0, 0), listOf(GridReference(x=1, y=0), GridReference(x=0, y=1))
            )
        }, {
            assertContains(
                grid.cells, GridReference(1, 0), listOf(GridReference(x=0, y=0), GridReference(x=2, y=0), GridReference(x=2, y=1))
            )
        }, {
            assertContains(
                grid.cells, GridReference(2, 0), listOf(GridReference(x=1, y=0), GridReference(x=3, y=0))
            )
        }, {
            assertContains(
                grid.cells, GridReference(3, 0), listOf(GridReference(x=2, y=0), GridReference(x=4, y=0))
            )
        }, {
            assertContains(
                grid.cells, GridReference(4, 0), listOf(GridReference(x=3, y=0), GridReference(x=5, y=0), GridReference(x=2, y=1))
            )
        }, {
            assertContains(
                grid.cells, GridReference(5, 0), listOf(GridReference(x=4, y=0), GridReference(x=6, y=0))
            )
        }, {
            assertContains(
                grid.cells, GridReference(6, 0), listOf(GridReference(x=5, y=0), GridReference(x=6, y=1))
            )
        }, {
            assertContains(
                grid.cells, GridReference(0, 1), listOf(GridReference(0, 0), GridReference(1, 1))
            )
        }, {
            assertContains(
                grid.cells, GridReference(1, 1), listOf(GridReference(0, 1), GridReference(2, 1), GridReference(0, 2))
            )
        }, {
            assertContains(
                grid.cells, GridReference(2, 1), listOf(GridReference(1, 0), GridReference(4, 0), GridReference(1, 1), GridReference(6, 1), GridReference(2, 2), GridReference(5, 2))
            )
        }, {
            assertContains(
                grid.cells, GridReference(6, 1), listOf(GridReference(6, 0),GridReference(2, 1),GridReference(7, 1))
            )
        }, {
            assertContains(
                grid.cells, GridReference(7, 1), listOf(GridReference(6, 1),GridReference(6, 2))
            )
        }, {
            assertContains(
                grid.cells, GridReference(0, 2), listOf(GridReference(1, 1),GridReference(1, 2))
            )
        }, {
            assertContains(
                grid.cells, GridReference(2, 2), listOf(GridReference(2, 1), GridReference(1, 2), GridReference(3, 2))
            )
        }, {
            assertContains(
                grid.cells, GridReference(3, 2), listOf(GridReference(2, 2), GridReference(4, 2), GridReference(3, 3))
            )
        }, {
            assertContains(
                grid.cells, GridReference(4, 2), listOf(GridReference(3, 2), GridReference(5, 2), GridReference(5, 3))
            )
        }, {
            assertContains(
                grid.cells, GridReference(5, 2), listOf(GridReference(2, 1), GridReference(4, 2), GridReference(6, 2))
            )
        }, {
            assertContains(
                grid.cells, GridReference(6, 2), listOf(GridReference(7, 1), GridReference(5, 2), GridReference(7, 2))
            )
        }, {
            assertContains(
                grid.cells, GridReference(7, 2), listOf(GridReference(6, 2), GridReference(8, 2), GridReference(5, 3))
            )
        }, {
            assertContains(
                grid.cells, GridReference(8, 2), listOf(GridReference(7, 2), GridReference(9, 2))
            )
        }, {
            assertContains(
                grid.cells, GridReference(9, 2), listOf(GridReference(8, 2), GridReference(9, 3))
            )
        }, {
            assertContains(
                grid.cells, GridReference(3, 3), listOf(GridReference(3, 2), GridReference(4, 3))
            )
        }, {
            assertContains(
                grid.cells, GridReference(4, 3), listOf(GridReference(3, 3), GridReference(5, 3), GridReference(3,4))
            )
        }, {
            assertContains(
                grid.cells, GridReference(5, 3), listOf(GridReference(4, 2), GridReference(7, 2), GridReference(4, 3), GridReference(9, 3), GridReference(5, 4), GridReference(8, 4))
            )
        }, {
            assertContains(
                grid.cells, GridReference(9, 3), listOf(GridReference(9, 2), GridReference(5, 3), GridReference(10, 3))
            )
        }, {
            assertContains(
                grid.cells, GridReference(10, 3), listOf(GridReference(9, 3), GridReference(9, 4))
            )
        }, {
            assertContains(
                grid.cells, GridReference(3, 4), listOf(GridReference(4, 3), GridReference(4, 4))
            )
        }, {
            assertContains(
                grid.cells, GridReference(4, 4), listOf(GridReference(3, 4), GridReference(5, 4))
            )
        }, {
            assertContains(
                grid.cells, GridReference(5, 4), listOf(GridReference(5, 3), GridReference(4, 4), GridReference(6, 4))
            )
        }, {
            assertContains(
                grid.cells, GridReference(6, 4), listOf(GridReference(5, 4), GridReference(7, 4))
            )
        }, {
            assertContains(
                grid.cells, GridReference(7, 4), listOf(GridReference(6, 4), GridReference(8, 4))
            )
        }, {
            assertContains(
                grid.cells, GridReference(8, 4), listOf(GridReference(5, 3), GridReference(7, 4), GridReference(9, 4))
            )
        }, {
            assertContains(
                grid.cells, GridReference(9, 4), listOf(GridReference(10, 3), GridReference(8, 4))
            )
        })
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