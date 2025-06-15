package uk.co.stevebosman.grid.impl.uniform.rhombiTriHexagonal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.test.GridAssertions.assertContains
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
    fun testStandardGenerated1by2grid() {
        val grid = instance.generate(1, 2)
        assertEquals(23, grid.cells.size)
        assertEquals(
            2,
            grid.cells.keys.filter { r -> RhombiTriHexagonalCellType.of(r) == RhombiTriHexagonalCellType.Hexagon }.size
        )
        assertAll({
            assertContains(
                grid.cells, GridReference(0, 0), listOf(GridReference(1, 0), GridReference(0, 1))
            )
        }, {
            assertContains(
                grid.cells, GridReference(1, 0), listOf(GridReference(0, 0), GridReference(2, 0), GridReference(1, 1))
            )
        }, {
            assertContains(
                grid.cells, GridReference(2, 0), listOf(GridReference(1, 0), GridReference(3, 0))
            )
        }, {
            assertContains(
                grid.cells, GridReference(3, 0), listOf(GridReference(2, 0), GridReference(4, 0), GridReference(1, 1))
            )
        }, {
            assertContains(
                grid.cells, GridReference(4, 0), listOf(GridReference(3, 0), GridReference(4, 1))
            )
        }, {
            assertContains(
                grid.cells, GridReference(0, 1), listOf(GridReference(0, 0), GridReference(1, 1), GridReference(0, 2))
            )
        }, {
            assertContains(
                grid.cells, GridReference(1, 1), listOf(GridReference(1, 0), GridReference(3, 0), GridReference(0, 1), GridReference(4, 1), GridReference(1, 2), GridReference(3, 2))
            )
        }, {
            assertContains(
                grid.cells, GridReference(4, 1), listOf(GridReference(4, 0), GridReference(1, 1), GridReference(4, 2))
            )
        }, {
            assertContains(
                grid.cells, GridReference(0, 2), listOf(GridReference(0, 1), GridReference(1, 2))
            )
        }, {
            assertContains(
                grid.cells, GridReference(1, 2), listOf(GridReference(1, 1), GridReference(0, 2), GridReference(2, 2))
            )
        }, {
            assertContains(
                grid.cells, GridReference(2, 2), listOf(GridReference(1, 2), GridReference(3, 2), GridReference(2, 3))
            )
        }, {
            assertContains(
                grid.cells, GridReference(3, 2), listOf(GridReference(1, 1), GridReference(2, 2), GridReference(4, 2), GridReference(3, 3))
            )
        }, {
            assertContains(
                grid.cells, GridReference(4, 2), listOf(GridReference(4, 1), GridReference(3, 2), GridReference(5, 2))
            )
        }, {
            assertContains(
                grid.cells, GridReference(5, 2), listOf(GridReference(4, 2), GridReference(6, 2), GridReference(3, 3))
            )
        }, {
            assertContains(
                grid.cells, GridReference(6, 2), listOf(GridReference(5, 2), GridReference(6, 3))
            )
        }, {
            assertContains(
                grid.cells, GridReference(2, 3), listOf(GridReference(2, 2), GridReference(3, 3), GridReference(2, 4))
            )
        }, {
            assertContains(
                grid.cells, GridReference(3, 3), listOf(GridReference(3, 2), GridReference(5, 2), GridReference(2, 3), GridReference(6, 3), GridReference(3, 4), GridReference(5, 4))
            )
        }, {
            assertContains(
                grid.cells, GridReference(6, 3), listOf(GridReference(6, 2), GridReference(3, 3), GridReference(6, 4))
            )
        }, {
            assertContains(
                grid.cells, GridReference(2, 4), listOf(GridReference(2, 3), GridReference(3, 4))
            )
        }, {
            assertContains(
                grid.cells, GridReference(3, 4), listOf(GridReference(3, 3), GridReference(2, 4), GridReference(4, 4))
            )
        }, {
            assertContains(
                grid.cells, GridReference(4, 4), listOf(GridReference(3, 4), GridReference(5, 4))
            )
        }, {
            assertContains(
                grid.cells, GridReference(5, 4), listOf(GridReference(3, 3), GridReference(4, 4), GridReference(6, 4))
            )
        }, {
            assertContains(
                grid.cells, GridReference(6, 4), listOf(GridReference(6, 3), GridReference(5, 4))
            )
        })
    }

    @Test
    fun testStandardGenerated2by2grid() {
        val grid = instance.generate(2, 2)
        assertEquals(39, grid.cells.size, "Unexpected cells: ${grid.cells.keys}")
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