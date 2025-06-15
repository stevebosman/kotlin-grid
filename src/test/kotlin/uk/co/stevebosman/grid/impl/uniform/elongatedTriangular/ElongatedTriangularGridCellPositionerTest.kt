package uk.co.stevebosman.grid.impl.uniform.elongatedTriangular

import org.junit.jupiter.api.Test
import uk.co.stevebosman.maths.geometry.Circle
import uk.co.stevebosman.maths.geometry.Point
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.test.GridAssertions.assertEqualCircles
import uk.co.stevebosman.test.GridAssertions.assertEqualPoints
import kotlin.math.sqrt

class ElongatedTriangularGridCellPositionerTest {
    @Test
    fun testVerticesOrigin() {
        assertEqualPoints(
            listOf(
                Point(0.5, 0.0), Point(1.0, HALF_ROOT_THREE), Point(0.0, HALF_ROOT_THREE)
            ), instance.getPolygon(GridReference(0, 0)).vertices
        )
    }

    @Test
    fun testVerticesInnerSquare() {
        assertEqualPoints(
            listOf(
                Point(3.0, 3 + 3 * HALF_ROOT_THREE),
                Point(2.0, 3 + 3 * HALF_ROOT_THREE),
                Point(2.0, 2 + 3 * HALF_ROOT_THREE),
                Point(3.0, 2 + 3 * HALF_ROOT_THREE)
            ), instance.getPolygon(GridReference(4, 5)).vertices
        )
    }

    @Test
    fun testVerticesInnerUp() {
        assertEqualPoints(
            listOf(
                Point(1.5, 2 + HALF_ROOT_THREE * 2),
                Point(2.0, 2 + HALF_ROOT_THREE * 3),
                Point(1.0, 2 + HALF_ROOT_THREE * 3)
            ), instance.getPolygon(GridReference(2, 4)).vertices
        )
    }

    @Test
    fun testVerticesFirstDown() {
        assertEqualPoints(
            listOf(
                Point(0.5, 0.0), Point(1.5, 0.0), Point(1.0, HALF_ROOT_THREE)
            ), instance.getPolygon(GridReference(1, 0)).vertices
        )
    }

    @Test
    fun testVerticesInnerDown() {
        assertEqualPoints(
            listOf(
                Point(2.0, 1 + HALF_ROOT_THREE), Point(3.0, 1 + HALF_ROOT_THREE), Point(2.5, 1 + HALF_ROOT_THREE * 2)
            ), instance.getPolygon(GridReference(4, 2)).vertices
        )
    }

    @Test
    fun testInscribedCircleOrigin() {
        assertEqualCircles(
            Circle(Point(0.5, 2 * HALF_ROOT_THREE / 3), HALF_ROOT_THREE / 3),
            instance.getInscribedCircle(GridReference(0, 0))
        )
    }

    @Test
    fun testInscribedCircleInnerSquare() {
        assertEqualCircles(
            Circle(Point(2.5, 2.5 + 3 * HALF_ROOT_THREE), 0.5), instance.getInscribedCircle(GridReference(4, 5))
        )
    }

    @Test
    fun testInscribedCircleInnerUp() {
        assertEqualCircles(
            Circle(Point(1.5, 2 + (2 + 2.0 / 3.0) * HALF_ROOT_THREE), HALF_ROOT_THREE / 3),
            instance.getInscribedCircle(GridReference(2, 4))
        )
    }

    @Test
    fun testInscribedCircleFirstDown() {
        assertEqualCircles(
            Circle(Point(1.0, HALF_ROOT_THREE * 1.0 / 3.0), HALF_ROOT_THREE / 3),
            instance.getInscribedCircle(GridReference(1, 0))
        )
    }

    @Test
    fun testInscribedCircleInnerDown() {
        assertEqualCircles(
            Circle(Point(2.5, 1 + (1 + 1.0 / 3.0) * HALF_ROOT_THREE), HALF_ROOT_THREE / 3),
            instance.getInscribedCircle(GridReference(4, 2))
        )
    }

    companion object {
        val instance = ElongatedTriangularGridCellPositioner
        val HALF_ROOT_THREE = sqrt(3.0) / 2
    }
}