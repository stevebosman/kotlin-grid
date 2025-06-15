package uk.co.stevebosman.grid.impl.uniform.rhombiTriHexagonal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import uk.co.stevebosman.grid.GridReference

class RhombiTriHexagonalCellTypeTest {
    @Test
    fun testHexagon() {
        assertEquals(RhombiTriHexagonalCellType.Hexagon, RhombiTriHexagonalCellType.of(GridReference(1, 1)))
        assertEquals(RhombiTriHexagonalCellType.Hexagon, RhombiTriHexagonalCellType.of(GridReference(5, 1)))
        assertEquals(RhombiTriHexagonalCellType.Hexagon, RhombiTriHexagonalCellType.of(GridReference(3, 3)))
        assertEquals(RhombiTriHexagonalCellType.Hexagon, RhombiTriHexagonalCellType.of(GridReference(7, 3)))
    }

    @Test
    fun testSquare0() {
        assertEquals(RhombiTriHexagonalCellType.Square0, RhombiTriHexagonalCellType.of(GridReference(0, 1)))
        assertEquals(RhombiTriHexagonalCellType.Square0, RhombiTriHexagonalCellType.of(GridReference(4, 1)))
        assertEquals(RhombiTriHexagonalCellType.Square0, RhombiTriHexagonalCellType.of(GridReference(2, 3)))
        assertEquals(RhombiTriHexagonalCellType.Square0, RhombiTriHexagonalCellType.of(GridReference(6, 3)))
    }

    @Test
    fun testSquare30() {
        assertEquals(RhombiTriHexagonalCellType.Square30, RhombiTriHexagonalCellType.of(GridReference(3, 0)))
        assertEquals(RhombiTriHexagonalCellType.Square30, RhombiTriHexagonalCellType.of(GridReference(7, 0)))
        assertEquals(RhombiTriHexagonalCellType.Square30, RhombiTriHexagonalCellType.of(GridReference(1, 2)))
        assertEquals(RhombiTriHexagonalCellType.Square30, RhombiTriHexagonalCellType.of(GridReference(5, 2)))
    }

    @Test
    fun testSquare60() {
        assertEquals(RhombiTriHexagonalCellType.Square60, RhombiTriHexagonalCellType.of(GridReference(1, 0)))
        assertEquals(RhombiTriHexagonalCellType.Square60, RhombiTriHexagonalCellType.of(GridReference(5, 0)))
        assertEquals(RhombiTriHexagonalCellType.Square60, RhombiTriHexagonalCellType.of(GridReference(3, 2)))
        assertEquals(RhombiTriHexagonalCellType.Square60, RhombiTriHexagonalCellType.of(GridReference(7, 2)))
    }

    @Test
    fun testTriangleUp() {
        assertEquals(RhombiTriHexagonalCellType.TriangleUp, RhombiTriHexagonalCellType.of(GridReference(0, 0)))
        assertEquals(RhombiTriHexagonalCellType.TriangleUp, RhombiTriHexagonalCellType.of(GridReference(4, 0)))
        assertEquals(RhombiTriHexagonalCellType.TriangleUp, RhombiTriHexagonalCellType.of(GridReference(2, 2)))
        assertEquals(RhombiTriHexagonalCellType.TriangleUp, RhombiTriHexagonalCellType.of(GridReference(6, 2)))
    }

    @Test
    fun testTriangleDown() {
        assertEquals(RhombiTriHexagonalCellType.TriangleDown, RhombiTriHexagonalCellType.of(GridReference(2, 0)))
        assertEquals(RhombiTriHexagonalCellType.TriangleDown, RhombiTriHexagonalCellType.of(GridReference(6, 0)))
        assertEquals(RhombiTriHexagonalCellType.TriangleDown, RhombiTriHexagonalCellType.of(GridReference(0, 2)))
        assertEquals(RhombiTriHexagonalCellType.TriangleDown, RhombiTriHexagonalCellType.of(GridReference(4, 2)))
    }
}