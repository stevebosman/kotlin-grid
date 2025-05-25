package uk.co.stevebosman.grid.impl.uniform.squareOctagon2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import uk.co.stevebosman.geometry.Circle
import uk.co.stevebosman.geometry.Point
import uk.co.stevebosman.grid.GridReference
import kotlin.math.sqrt

class SquareOctagon2GridCellPositionerTest {
    @Test
    fun testVerticesForSquareOrigin() {
        assertEquals(
            listOf(
                Point(0.0 + ROOT_HALF, 0.0 + ROOT_HALF),
                Point(1.0 + ROOT_HALF, 0.0 + ROOT_HALF),
                Point(1.0 + ROOT_HALF, 1.0 + ROOT_HALF),
                Point(0.0 + ROOT_HALF, 1.0 + ROOT_HALF)
            ), instance.getVertices(GridReference(0, 0))
        )
    }

    @Test
    fun testVerticesForSquareOneOne() {
        assertEquals(
            listOf(
                Point(1.0 + 2 * ROOT_HALF, 1.0 + 2 * ROOT_HALF),
                Point(2.0 + 2 * ROOT_HALF, 1.0 + 2 * ROOT_HALF),
                Point(2.0 + 2 * ROOT_HALF, 2.0 + 2 * ROOT_HALF),
                Point(1.0 + 2 * ROOT_HALF, 2.0 + 2 * ROOT_HALF)
            ), instance.getVertices(GridReference(1, 1))
        )
    }

    @Test
    fun testVerticesForOctagonZeroOne() {
        assertEquals(
            listOf(
                Point(ROOT_HALF, 1 + ROOT_HALF),
                Point(x = 0.0, y = 1 + 2 * ROOT_HALF),
                Point(x = 0.0, y = 2 + 2 * ROOT_HALF),
                Point(x = ROOT_HALF, y = 2 + 3 * ROOT_HALF),
                Point(x = 1 + ROOT_HALF, y = 2 + 3 * ROOT_HALF),
                Point(x = 1 + 2 * ROOT_HALF, y = 2 + 2 * ROOT_HALF),
                Point(x = 1 + 2 * ROOT_HALF, y = 1 + 2 * ROOT_HALF),
                Point(1 + ROOT_HALF, 1 + ROOT_HALF),
            ), instance.getVertices(GridReference(0, 1))
        )
    }

    @Test
    fun testVerticesForOctagonOneZero() {
        assertEquals(
            listOf(
                Point(x = 1 + 2 * ROOT_HALF, y = 0.0),
                Point(x = 1 + ROOT_HALF, y = ROOT_HALF),
                Point(x = 1 + ROOT_HALF, y = 1 + ROOT_HALF),
                Point(x = 1 + 2 * ROOT_HALF, y = 1 + 2 * ROOT_HALF),
                Point(x = 2 + 2 * ROOT_HALF, y = 1 + 2 * ROOT_HALF),
                Point(x = 2 + 3 * ROOT_HALF, y = 1 + ROOT_HALF),
                Point(x = 2 + 3 * ROOT_HALF, y = ROOT_HALF),
                Point(x = 2 + 2 * ROOT_HALF, y = 0.0)
            ), instance.getVertices(GridReference(1, 0))
        )
    }

    @Test
    fun testInscribedCircleForSquareZeroZero() {
        assertEquals(
            Circle(Point(0.5 + ROOT_HALF, 0.5 + ROOT_HALF), 0.5),
            instance.getInscribedCircle(GridReference(0, 0))
        )
    }

    @Test
    fun testInscribedCircleForSquareOneOne() {
        assertEquals(
            Circle(Point(1.5 + 2 * ROOT_HALF, 1.5 + 2 * ROOT_HALF), 0.5),
            instance.getInscribedCircle(GridReference(1, 1))
        )
    }

    @Test
    fun testInscribedCircleForOctagonOneZero() {
        assertEquals(
            Circle(Point(1.5 + 2 * ROOT_HALF, 0.5 + ROOT_HALF), 0.5 + ROOT_HALF),
            instance.getInscribedCircle(GridReference(1, 0))
        )
    }

    @Test
    fun testInscribedCircleForOctagonZeroOne() {
        assertEquals(
            Circle(Point(0.5 + ROOT_HALF, 1.5 + 2 * ROOT_HALF), 0.5 + ROOT_HALF),
            instance.getInscribedCircle(GridReference(0, 1))
        )
    }

    companion object {
        val instance = SquareOctagon2GridCellPositioner
        val ROOT_HALF = sqrt(0.5)
    }

}