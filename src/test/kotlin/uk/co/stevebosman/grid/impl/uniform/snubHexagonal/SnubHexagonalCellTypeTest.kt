package uk.co.stevebosman.grid.impl.uniform.snubHexagonal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import uk.co.stevebosman.grid.GridReference

class SnubHexagonalCellTypeTest {
    @Test
    fun testHexagon() {
        assertEquals(SnubHexagonalCellType.Hexagon, SnubHexagonalCellType.of(GridReference(2, 1)))
        assertEquals(SnubHexagonalCellType.Hexagon, SnubHexagonalCellType.of(GridReference(8, 1)))
        assertEquals(SnubHexagonalCellType.Hexagon, SnubHexagonalCellType.of(GridReference(5, 3)))
        assertEquals(SnubHexagonalCellType.Hexagon, SnubHexagonalCellType.of(GridReference(11, 3)))
    }

    @Test
    fun testTriangleLeft() {
        assertEquals(SnubHexagonalCellType.TriangleLeft, SnubHexagonalCellType.of(GridReference(0, 0)))
        assertEquals(SnubHexagonalCellType.TriangleLeft, SnubHexagonalCellType.of(GridReference(2, 0)))
        assertEquals(SnubHexagonalCellType.TriangleLeft, SnubHexagonalCellType.of(GridReference(4, 0)))
        assertEquals(SnubHexagonalCellType.TriangleLeft, SnubHexagonalCellType.of(GridReference(1, 2)))
        assertEquals(SnubHexagonalCellType.TriangleLeft, SnubHexagonalCellType.of(GridReference(3, 2)))
    }

    @Test
    fun testTriangleRight() {
        assertEquals(SnubHexagonalCellType.TriangleRight, SnubHexagonalCellType.of(GridReference(1, 0)))
        assertEquals(SnubHexagonalCellType.TriangleRight, SnubHexagonalCellType.of(GridReference(3, 0)))
        assertEquals(SnubHexagonalCellType.TriangleRight, SnubHexagonalCellType.of(GridReference(5, 0)))
        assertEquals(SnubHexagonalCellType.TriangleRight, SnubHexagonalCellType.of(GridReference(7, 0)))
        assertEquals(SnubHexagonalCellType.TriangleRight, SnubHexagonalCellType.of(GridReference(0, 2)))
        assertEquals(SnubHexagonalCellType.TriangleRight, SnubHexagonalCellType.of(GridReference(2, 2)))
    }
}