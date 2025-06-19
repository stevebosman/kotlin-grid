package uk.co.stevebosman.grid.impl.floretPentagonal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import uk.co.stevebosman.grid.GridReference

class FloretPentagonalCellTypeTest {
    @Test
    fun testHexagon0() {
        assertEquals(FloretPentagonalCellType.Hexagon0, FloretPentagonalCellType.of(GridReference(0, 0)))
        assertEquals(FloretPentagonalCellType.Hexagon0, FloretPentagonalCellType.of(GridReference(0, 2)))
        assertEquals(FloretPentagonalCellType.Hexagon0, FloretPentagonalCellType.of(GridReference(3, 4)))
    }

    @Test
    fun testHexagon60() {
        assertEquals(FloretPentagonalCellType.Hexagon60, FloretPentagonalCellType.of(GridReference(1, 0)))
        assertEquals(FloretPentagonalCellType.Hexagon60, FloretPentagonalCellType.of(GridReference(1, 2)))
        assertEquals(FloretPentagonalCellType.Hexagon60, FloretPentagonalCellType.of(GridReference(4, 4)))
    }

    @Test
    fun testHexagon120() {
        assertEquals(FloretPentagonalCellType.Hexagon120, FloretPentagonalCellType.of(GridReference(2, 0)))
        assertEquals(FloretPentagonalCellType.Hexagon120, FloretPentagonalCellType.of(GridReference(2, 2)))
        assertEquals(FloretPentagonalCellType.Hexagon120, FloretPentagonalCellType.of(GridReference(5, 4)))
    }

    @Test
    fun testHexagon180() {
        assertEquals(FloretPentagonalCellType.Hexagon180, FloretPentagonalCellType.of(GridReference(0, 1)))
        assertEquals(FloretPentagonalCellType.Hexagon180, FloretPentagonalCellType.of(GridReference(0, 3)))
        assertEquals(FloretPentagonalCellType.Hexagon180, FloretPentagonalCellType.of(GridReference(3, 5)))
    }

    @Test
    fun testHexagon240() {
        assertEquals(FloretPentagonalCellType.Hexagon240, FloretPentagonalCellType.of(GridReference(1, 1)))
        assertEquals(FloretPentagonalCellType.Hexagon240, FloretPentagonalCellType.of(GridReference(1, 3)))
        assertEquals(FloretPentagonalCellType.Hexagon240, FloretPentagonalCellType.of(GridReference(4, 5)))
    }

    @Test
    fun testHexagon300() {
        assertEquals(FloretPentagonalCellType.Hexagon300, FloretPentagonalCellType.of(GridReference(2, 1)))
        assertEquals(FloretPentagonalCellType.Hexagon300, FloretPentagonalCellType.of(GridReference(2, 3)))
        assertEquals(FloretPentagonalCellType.Hexagon300, FloretPentagonalCellType.of(GridReference(5, 5)))
    }
}