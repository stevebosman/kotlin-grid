package uk.co.stevebosman.grid.impl.regular.triangle

import org.junit.jupiter.api.Test
import uk.co.stevebosman.maths.geometry.Circle
import uk.co.stevebosman.maths.geometry.Point
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.test.GridAssertions.assertEqualCircles
import uk.co.stevebosman.test.GridAssertions.assertEqualPoints
import kotlin.math.sqrt

class TriangleGridCellPositionerTest {
    @Test
    fun testVerticesOrigin() {
        assertEqualPoints(
            listOf(
                Point(0.0, 0.0),
                Point(1.0, 0.0),
                Point(0.5, HALF_ROOT_THREE)
            ), instance.getPolygon(GridReference(0, 0)).vertices
        )
    }

    @Test
    fun testVerticesInnerUp() {
        assertEqualPoints(
            listOf(
                Point(5.0, HALF_ROOT_THREE * 6),
                Point(6.0, HALF_ROOT_THREE * 6),
                Point(5.5, HALF_ROOT_THREE * 7)
            ), instance.getPolygon(GridReference(10, 6)).vertices
        )
    }

    @Test
    fun testVerticesFirstDown() {
        assertEqualPoints(
            listOf(
                Point(1.0, 0.0),
                Point(1.5, HALF_ROOT_THREE),
                Point(0.5, HALF_ROOT_THREE)
            ), instance.getPolygon(GridReference(1, 0)).vertices
        )
    }

    @Test
    fun testVerticesInnerDown() {
        assertEqualPoints(
            listOf(
                Point(2.5, HALF_ROOT_THREE * 3),
                Point(3.0, HALF_ROOT_THREE * 4),
                Point(2.0, HALF_ROOT_THREE * 4)
            ), instance.getPolygon(GridReference(4, 3)).vertices
        )
    }

    @Test
    fun testInscribedCircleOrigin() {
        assertEqualCircles(
            Circle(Point(0.5, HALF_ROOT_THREE / 3), HALF_ROOT_THREE / 3),
            instance.getInscribedCircle(GridReference(0, 0))
        )
    }

    @Test
    fun testInscribedCircleInnerUp() {
        assertEqualCircles(
            Circle(Point(5.5, (6 + 1.0 / 3.0) * HALF_ROOT_THREE), HALF_ROOT_THREE / 3),
            instance.getInscribedCircle(GridReference(10, 6))
        )
    }

    @Test
    fun testInscribedCircleFirstDown() {
        assertEqualCircles(
            Circle(Point(1.0, HALF_ROOT_THREE * 2.0 / 3.0), HALF_ROOT_THREE / 3),
            instance.getInscribedCircle(GridReference(1, 0))
        )
    }

    @Test
    fun testInscribedCircleInnerDown() {
        assertEqualCircles(
            Circle(Point(2.5, (3 + 2.0 / 3.0) * HALF_ROOT_THREE), HALF_ROOT_THREE / 3),
            instance.getInscribedCircle(GridReference(4, 3))
        )
    }

    companion object {
        val instance = TriangleGridCellPositioner
        val HALF_ROOT_THREE = sqrt(3.0) / 2
    }
}