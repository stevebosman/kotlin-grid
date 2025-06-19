package uk.co.stevebosman.grid.impl.floretPentagonal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.test.GridAssertions.assertContains
import kotlin.math.sqrt

class FloretPentagonalGridGeneratorTest {
    @Test
    fun testStandardGenerated1by1grid() {
        val grid = instance.generate(1, 1)
        assertEquals(6, grid.cells.size)
        assertEquals(
            1,
            grid.cells.keys.filter { r -> FloretPentagonalCellType.of(r) == FloretPentagonalCellType.Hexagon0 }.size
        )
    }

    @Test
    fun testStandardGenerated1by2grid() {
        val grid = instance.generate(1, 2)
        assertEquals(12, grid.cells.size, "Unexpected cells: ${grid.cells.keys}")
        assertEquals(
            2,
            grid.cells.keys.filter { r -> FloretPentagonalCellType.of(r) == FloretPentagonalCellType.Hexagon0 }.size
        )
        assertAll({
            assertContains(
                grid.cells, GridReference(0, 0), listOf(GridReference(1, 0), GridReference(0, 1))
            )
        }, {
            assertContains(
                grid.cells, GridReference(1, 0), listOf(GridReference(0, 0), GridReference(2, 0))
            )
        }, {
            assertContains(
                grid.cells, GridReference(2, 0), listOf(GridReference(1, 0), GridReference(2, 1))
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
                grid.cells,
                GridReference(2, 1),
                listOf(GridReference(2, 0), GridReference(1, 1), GridReference(0, 2), GridReference(1, 2))
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(0, 2),
                listOf(GridReference(1, 1), GridReference(2, 1), GridReference(1, 2), GridReference(0, 3))
            )
        }, {
            assertContains(
                grid.cells, GridReference(1, 2), listOf(GridReference(2, 1), GridReference(0, 2), GridReference(2, 2))
            )
        }, {
            assertContains(
                grid.cells, GridReference(2, 2), listOf(GridReference(1, 2), GridReference(2, 3))
            )
        }, {
            assertContains(
                grid.cells, GridReference(0, 3), listOf(GridReference(0, 2), GridReference(1, 3))
            )
        }, {
            assertContains(
                grid.cells, GridReference(1, 3), listOf(GridReference(0, 3), GridReference(2, 3))
            )
        }, {
            assertContains(
                grid.cells, GridReference(2, 3), listOf(GridReference(2, 2), GridReference(1, 3))
            )
        })
    }

    @Test
    fun testInnerNeighbours() {
        val grid = instance.generate(4, 4)
        assertAll({
            assertContains(
                grid.cells,
                GridReference(3, 2),
                listOf(
                    GridReference(4, 1),
                    GridReference(5, 1),
                    GridReference(2, 2),
                    GridReference(4, 2),
                    GridReference(3, 3)
                )
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(4, 2),
                listOf(
                    GridReference(5, 1),
                    GridReference(6, 1),
                    GridReference(7, 1),
                    GridReference(3, 2),
                    GridReference(5, 2)
                )
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(5, 2),
                listOf(
                    GridReference(7, 1),
                    GridReference(4, 2),
                    GridReference(6, 2),
                    GridReference(5, 3),
                    GridReference(6, 3)
                )
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(3, 3),
                listOf(
                    GridReference(2, 2),
                    GridReference(3, 2),
                    GridReference(2, 3),
                    GridReference(4, 3),
                    GridReference(4, 4)
                )
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(4, 3),
                listOf(
                    GridReference(3, 3),
                    GridReference(5, 3),
                    GridReference(4, 4),
                    GridReference(5, 4),
                    GridReference(6, 4)
                )
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(5, 3),
                listOf(
                    GridReference(5, 2),
                    GridReference(4, 3),
                    GridReference(6, 3),
                    GridReference(6, 4),
                    GridReference(7, 4)
                )
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(3, 4),
                listOf(
                    GridReference(1, 3),
                    GridReference(2, 3),
                    GridReference(2, 4),
                    GridReference(4, 4),
                    GridReference(3, 5)
                )
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(4, 4),
                listOf(
                    GridReference(2, 3),
                    GridReference(3, 3),
                    GridReference(4, 3),
                    GridReference(3, 4),
                    GridReference(5, 4)
                )
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(5, 4),
                listOf(
                    GridReference(4, 3),
                    GridReference(4, 4),
                    GridReference(6, 4),
                    GridReference(5, 5),
                    GridReference(6, 5)
                )
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(3, 5),
                listOf(
                    GridReference(2, 4),
                    GridReference(3, 4),
                    GridReference(2, 5),
                    GridReference(4, 5),
                    GridReference(1, 6)
                )
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(4, 5),
                listOf(
                    GridReference(3, 5),
                    GridReference(5, 5),
                    GridReference(1, 6),
                    GridReference(2, 6),
                    GridReference(3, 6)
                )
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(5, 5),
                listOf(
                    GridReference(5, 4),
                    GridReference(4, 5),
                    GridReference(6, 5),
                    GridReference(3, 6),
                    GridReference(4, 6)
                )
            )
        })
    }

    @Test
    fun testStandardGenerated2by2grid() {
        val grid = instance.generate(2, 2)
        assertEquals(24, grid.cells.size)
        assertEquals(
            4,
            grid.cells.keys.filter { r -> FloretPentagonalCellType.of(r) == FloretPentagonalCellType.Hexagon0 }.size
        )
    }

    @Test
    fun testStandardSkipLastGenerated2by2grid() {
        val grid = instance.generate(2, 2, FloretPentagonalGridOption.STANDARD_SKIP_LAST)
        assertEquals(18, grid.cells.size)
        assertEquals(
            3,
            grid.cells.keys.filter { r -> FloretPentagonalCellType.of(r) == FloretPentagonalCellType.Hexagon0 }.size
        )
    }

    @Test
    fun testOffsetGenerated2by2grid() {
        val grid = instance.generate(2, 2, FloretPentagonalGridOption.OFFSET)
        assertEquals(24, grid.cells.size)
        assertEquals(
            4,
            grid.cells.keys.filter { r -> FloretPentagonalCellType.of(r) == FloretPentagonalCellType.Hexagon0 }.size
        )
    }

    @Test
    fun testOffsetSkipLastGenerated2by2grid() {
        val grid = instance.generate(2, 2, FloretPentagonalGridOption.OFFSET_SKIP_LAST)
        assertEquals(18, grid.cells.size)
        assertEquals(
            3,
            grid.cells.keys.filter { r -> FloretPentagonalCellType.of(r) == FloretPentagonalCellType.Hexagon0 }.size
        )
    }

    @Test
    fun testTriangleGenerated3by3grid() {
        val grid = instance.generate(3, 3, FloretPentagonalGridOption.TRIANGLE)
        assertEquals(36, grid.cells.size)
        assertEquals(
            6,
            grid.cells.keys.filter { r -> FloretPentagonalCellType.of(r) == FloretPentagonalCellType.Hexagon0 }.size
        )
    }

    companion object {
        val instance = FloretPentagonalGridGenerator
        val HALF_ROOT_THREE = sqrt(3.0) / 2
    }
}