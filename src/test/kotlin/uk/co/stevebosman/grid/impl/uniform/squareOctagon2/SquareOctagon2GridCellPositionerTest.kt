package uk.co.stevebosman.grid.impl.uniform.squareOctagon2

import org.junit.jupiter.api.Test
import uk.co.stevebosman.geometry.Circle
import uk.co.stevebosman.geometry.Point
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.test.GridAssertions.assertEqualCircles
import uk.co.stevebosman.test.GridAssertions.assertEqualPoints
import kotlin.math.sqrt

class SquareOctagon2GridCellPositionerTest {
    @Test
    fun testVerticesForSquareOrigin() {
        assertEqualPoints(
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
        assertEqualPoints(
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
        assertEqualPoints(
            listOf(
                Point(ROOT_HALF, 1 + ROOT_HALF),
                Point(1 + ROOT_HALF, 1 + ROOT_HALF),
                Point(x = 1 + 2 * ROOT_HALF, y = 1 + 2 * ROOT_HALF),
                Point(x = 1 + 2 * ROOT_HALF, y = 2 + 2 * ROOT_HALF),
                Point(x = 1 + ROOT_HALF, y = 2 + 3 * ROOT_HALF),
                Point(x = ROOT_HALF, y = 2 + 3 * ROOT_HALF),
                Point(x = 0.0, y = 2 + 2 * ROOT_HALF),
                Point(x = 0.0, y = 1 + 2 * ROOT_HALF),
            ), instance.getVertices(GridReference(0, 1))
        )
    }

    @Test
    fun testVerticesForOctagonOneZero() {
        assertEqualPoints(
            listOf(
                Point(x = 1 + 2 * ROOT_HALF, y = 0.0),
                Point(x = 2 + 2 * ROOT_HALF, y = 0.0),
                Point(x = 2 + 3 * ROOT_HALF, y = ROOT_HALF),
                Point(x = 2 + 3 * ROOT_HALF, y = 1 + ROOT_HALF),
                Point(x = 2 + 2 * ROOT_HALF, y = 1 + 2 * ROOT_HALF),
                Point(x = 1 + 2 * ROOT_HALF, y = 1 + 2 * ROOT_HALF),
                Point(x = 1 + ROOT_HALF, y = 1 + ROOT_HALF),
                Point(x = 1 + ROOT_HALF, y = ROOT_HALF),
            ), instance.getVertices(GridReference(1, 0))
        )
    }

    @Test
    fun testInscribedCircleForSquareZeroZero() {
        assertEqualCircles(
            Circle(Point(0.5 + ROOT_HALF, 0.5 + ROOT_HALF), 0.5),
            instance.getInscribedCircle(GridReference(0, 0))
        )
    }

    @Test
    fun testInscribedCircleForSquareOneOne() {
        assertEqualCircles(
            Circle(Point(1.5 + 2 * ROOT_HALF, 1.5 + 2 * ROOT_HALF), 0.5),
            instance.getInscribedCircle(GridReference(1, 1))
        )
    }

    @Test
    fun testInscribedCircleForOctagonOneZero() {
        assertEqualCircles(
            Circle(Point(1.5 + 2 * ROOT_HALF, 0.5 + ROOT_HALF), 0.5 + ROOT_HALF),
            instance.getInscribedCircle(GridReference(1, 0))
        )
    }

    @Test
    fun testInscribedCircleForOctagonZeroOne() {
        assertEqualCircles(
            Circle(Point(0.5 + ROOT_HALF, 1.5 + 2 * ROOT_HALF), 0.5 + ROOT_HALF),
            instance.getInscribedCircle(GridReference(0, 1))
        )
    }

    companion object {
        val instance = SquareOctagon2GridCellPositioner
        val ROOT_HALF = sqrt(0.5)
    }

}