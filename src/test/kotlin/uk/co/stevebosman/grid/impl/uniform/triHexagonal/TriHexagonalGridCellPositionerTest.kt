package uk.co.stevebosman.grid.impl.uniform.triHexagonal

import org.junit.jupiter.api.Test
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.maths.geometry.Point
import uk.co.stevebosman.test.GridAssertions.assertEqualPoints
import kotlin.math.sqrt

class TriHexagonalGridCellPositionerTest {
    @Test
    fun testVerticesForHexagonZeroZero() {
        assertEqualPoints(
            listOf(
                Point(0.5, 0.0 * HALF_ROOT_THREE),
                Point(1.5, 0.0 * HALF_ROOT_THREE),
                Point(2.0, 1.0 * HALF_ROOT_THREE),
                Point(1.5, 2.0 * HALF_ROOT_THREE),
                Point(0.5, 2.0 * HALF_ROOT_THREE),
                Point(0.0, 1.0 * HALF_ROOT_THREE)
            ), instance.getPolygon(GridReference(0, 0)).vertices
        )
    }

    @Test
    fun testVerticesForTriangleOneZero() {
        assertEqualPoints(
            listOf(
                Point(1.5, 0.0),
                Point(2.5, 0.0),
                Point(2.0, HALF_ROOT_THREE),
            ), instance.getPolygon(GridReference(1, 0)).vertices
        )
    }

    @Test
    fun testVerticesForTriangleTwoZero() {
        assertEqualPoints(
            listOf(
                Point(2.0, HALF_ROOT_THREE),
                Point(2.5, 2 * HALF_ROOT_THREE),
                Point(1.5, 2 * HALF_ROOT_THREE),
            ), instance.getPolygon(GridReference(2, 0)).vertices
        )
    }

    @Test
    fun testVerticesForTriangleZeroOne() {
        assertEqualPoints(
            listOf(
                Point(0.5, 2 * HALF_ROOT_THREE),
                Point(1.5, 2 * HALF_ROOT_THREE),
                Point(1.0, 3 * HALF_ROOT_THREE),
            ), instance.getPolygon(GridReference(0, 1)).vertices
        )
    }

    @Test
    fun testVerticesForTriangleOneOne() {
        assertEqualPoints(
            listOf(
                Point(1.0, 3 * HALF_ROOT_THREE),
                Point(1.5, 4 * HALF_ROOT_THREE),
                Point(0.5, 4 * HALF_ROOT_THREE),
            ), instance.getPolygon(GridReference(1, 1)).vertices
        )
    }

    @Test
    fun testVerticesForHexagonTwoOne() {
        assertEqualPoints(
            listOf(
                Point(1.5, 2.0 * HALF_ROOT_THREE),
                Point(2.5, 2.0 * HALF_ROOT_THREE),
                Point(3.0, 3.0 * HALF_ROOT_THREE),
                Point(2.5, 4.0 * HALF_ROOT_THREE),
                Point(1.5, 4.0 * HALF_ROOT_THREE),
                Point(1.0, 3.0 * HALF_ROOT_THREE)
            ), instance.getPolygon(GridReference(2, 1)).vertices
        )
    }

    companion object {
        val instance = TriHexagonalGridCellPositioner
        val HALF_ROOT_THREE = sqrt(3.0) / 2
    }

}