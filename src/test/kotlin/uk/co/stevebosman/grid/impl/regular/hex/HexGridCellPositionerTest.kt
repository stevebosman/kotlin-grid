package uk.co.stevebosman.grid.impl.regular.hex

import org.junit.jupiter.api.Test
import uk.co.stevebosman.geometry.Circle
import uk.co.stevebosman.geometry.Point
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.test.GridAssertions.assertEqualCircles
import uk.co.stevebosman.test.GridAssertions.assertEqualPoints
import kotlin.math.sqrt

class HexGridCellPositionerTest {
    @Test
    fun testVerticesZeroZero() {
        assertEqualPoints(
            listOf(
                Point(HALF_ROOT_THREE, 0.0),
                Point(2 * HALF_ROOT_THREE, 0.5),
                Point(2 * HALF_ROOT_THREE, 1.5),
                Point(HALF_ROOT_THREE, 2.0),
                Point(0.0, 1.5),
                Point(0.0, 0.5),
            ), instance.getPolygon(GridReference(0, 0)).vertices
        )
    }

    @Test
    fun testVerticesOneZero() {
        assertEqualPoints(
            listOf(
                Point(3 * HALF_ROOT_THREE, 0.0),
                Point(4 * HALF_ROOT_THREE, 0.5),
                Point(4 * HALF_ROOT_THREE, 1.5),
                Point(3 * HALF_ROOT_THREE, 2.0),
                Point(2 * HALF_ROOT_THREE, 1.5),
                Point(2 * HALF_ROOT_THREE, 0.5),
            ), instance.getPolygon(GridReference(1, 0)).vertices
        )
    }

    @Test
    fun testVerticesZeroOne() {
        assertEqualPoints(
            listOf(
                Point(2 * HALF_ROOT_THREE, 1.5),
                Point(3 * HALF_ROOT_THREE, 2.0),
                Point(3 * HALF_ROOT_THREE, 3.0),
                Point(2 * HALF_ROOT_THREE, 3.5),
                Point(HALF_ROOT_THREE, 3.0),
                Point(HALF_ROOT_THREE, 2.0),
            ), instance.getPolygon(GridReference(0, 1)).vertices
        )
    }


    @Test
    fun testVerticesEven() {
        assertEqualPoints(
            listOf(
                Point(9 * HALF_ROOT_THREE, 6.0),
                Point(10 * HALF_ROOT_THREE, 6.5),
                Point(10 * HALF_ROOT_THREE, 7.5),
                Point(9 * HALF_ROOT_THREE, 8.0),
                Point(8 * HALF_ROOT_THREE, 7.5),
                Point(8 * HALF_ROOT_THREE, 6.5),
            ), instance.getPolygon(GridReference(4, 4)).vertices
        )
    }

    @Test
    fun testVerticesOdd() {
        assertEqualPoints(
            listOf(
                Point(14 * HALF_ROOT_THREE, 4.5),
                Point( 15* HALF_ROOT_THREE, 5.0),
                Point(15 * HALF_ROOT_THREE, 6.0),
                Point(14 * HALF_ROOT_THREE, 6.5),
                Point(13 * HALF_ROOT_THREE, 6.0),
                Point(13 * HALF_ROOT_THREE, 5.0),
            ), instance.getPolygon(GridReference(6, 3)).vertices
        )
    }

    @Test
    fun testInscribedCircleOrigin() {
        assertEqualCircles(
            Circle(Point(HALF_ROOT_THREE, 1.0), HALF_ROOT_THREE),
            instance.getInscribedCircle(GridReference(0, 0))
        )
    }

    @Test
    fun testInscribedCircleFirstRowOne() {
        assertEqualCircles(
            Circle(Point(2 * HALF_ROOT_THREE, 2.5), HALF_ROOT_THREE),
            instance.getInscribedCircle(GridReference(0, 1))
        )
    }


    @Test
    fun testInscribedCircleEven() {
        assertEqualCircles(
            Circle(Point(9 * HALF_ROOT_THREE, 7.0), HALF_ROOT_THREE),
            instance.getInscribedCircle(GridReference(4, 4))
        )
    }

    @Test
    fun testInscribedCircleOdd() {
        assertEqualCircles(
            Circle(Point(14 * HALF_ROOT_THREE, 5.5), HALF_ROOT_THREE),
            instance.getInscribedCircle(GridReference(6, 3))
        )
    }

    companion object {
        val instance = HexGridCellPositioner
        val HALF_ROOT_THREE = sqrt(3.0) / 2
    }
}