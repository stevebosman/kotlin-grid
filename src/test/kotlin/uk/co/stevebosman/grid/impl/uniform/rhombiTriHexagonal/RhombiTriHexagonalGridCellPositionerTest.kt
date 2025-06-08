package uk.co.stevebosman.grid.impl.uniform.rhombiTriHexagonal

import org.junit.jupiter.api.Test
import uk.co.stevebosman.geometry.Point
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.test.GridAssertions.assertEqualPoints
import kotlin.math.sqrt
import kotlin.test.assertFailsWith

class RhombiTriHexagonalGridCellPositionerTest {
    @Test
    fun testVerticesFor_0_0() {
        val actual = instance.getPolygon(GridReference(0, 0)).vertices
        println("0,0: ${actual}")
        assertEqualPoints(
            listOf(
                Point(0.5, 0.5),
                Point(1.0, HALF_ROOT_THREE + 0.5),
                Point(0.0, HALF_ROOT_THREE + 0.5),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_1_0() {
        val actual = instance.getPolygon(GridReference(1, 0)).vertices
        println("1,0: ${actual}")
        assertEqualPoints(
            listOf(
                Point(0.5 + HALF_ROOT_THREE, 0.0),
                Point(1 + HALF_ROOT_THREE, HALF_ROOT_THREE),
                Point(1.0, 0.5 + HALF_ROOT_THREE),
                Point(0.5, 0.5),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_2_0() {
        val actual = instance.getPolygon(GridReference(2, 0)).vertices
        println("2,0: ${actual}")
        assertEqualPoints(
            listOf(
                Point(0.5 + HALF_ROOT_THREE, 0.0),
                Point(1.5 + HALF_ROOT_THREE, 0.0),
                Point(1.0 + HALF_ROOT_THREE, HALF_ROOT_THREE),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_3_0() {
        val actual = instance.getPolygon(GridReference(3, 0)).vertices
        println("3,0: ${actual}")
        assertEqualPoints(
            listOf(
                Point(1.5 + HALF_ROOT_THREE, 0.0),
                Point(1.5 + ROOT_THREE, 0.5),
                Point(1.0 + ROOT_THREE, 0.5 + HALF_ROOT_THREE),
                Point(1.0 + HALF_ROOT_THREE, HALF_ROOT_THREE),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_4_0() {
        val actual = instance.getPolygon(GridReference(4, 0)).vertices
        println("4,0: ${actual}")
        assertEqualPoints(
            listOf(
                Point(1.5 + ROOT_THREE, 0.5),
                Point(2.0 + ROOT_THREE, HALF_ROOT_THREE + 0.5),
                Point(1.0 + ROOT_THREE, HALF_ROOT_THREE + 0.5),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_0_1() {
        val actual = instance.getPolygon(GridReference(0, 1)).vertices
        println("0,1: ${actual}")
        assertEqualPoints(
            listOf(
                Point(0.0, HALF_ROOT_THREE + 0.5),
                Point(1.0, HALF_ROOT_THREE + 0.5),
                Point(1.0, HALF_ROOT_THREE + 1.5),
                Point(0.0, HALF_ROOT_THREE + 1.5),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_1_1() {
        val actual = instance.getPolygon(GridReference(1, 1)).vertices
        println("1,1: ${actual}")
        assertEqualPoints(
            listOf(
                Point(1.0 + HALF_ROOT_THREE, HALF_ROOT_THREE),
                Point(1.0 + ROOT_THREE, 0.5 + HALF_ROOT_THREE),
                Point(1 + ROOT_THREE, 1.5 + HALF_ROOT_THREE),
                Point(1 + HALF_ROOT_THREE, 2 + HALF_ROOT_THREE),
                Point(1.0, 1.5 + HALF_ROOT_THREE),
                Point(1.0, 0.5 + HALF_ROOT_THREE)
            ), actual
        )
    }

    @Test
    fun testVerticesFor_2_1() {
        assertFailsWith<IllegalStateException> { instance.getPolygon(GridReference(2, 1)) }
    }

    @Test
    fun testVerticesFor_3_1() {
        assertFailsWith<IllegalStateException> { instance.getPolygon(GridReference(3, 1)) }
    }

    @Test
    fun testVerticesFor_4_1() {
        val actual = instance.getPolygon(GridReference(4, 1)).vertices
        println("4,1: ${actual}")
        assertEqualPoints(
            listOf(
                Point(1.0 + ROOT_THREE, HALF_ROOT_THREE + 0.5),
                Point(2.0 + ROOT_THREE, HALF_ROOT_THREE + 0.5),
                Point(2.0 + ROOT_THREE, HALF_ROOT_THREE + 1.5),
                Point(1.0 + ROOT_THREE, HALF_ROOT_THREE + 1.5),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_0_2() {
        val actual = instance.getPolygon(GridReference(0, 2)).vertices
        println("0,2: ${actual}")
        assertEqualPoints(
            listOf(
                Point(0.0, HALF_ROOT_THREE + 1.5),
                Point(1.0, HALF_ROOT_THREE + 1.5),
                Point(0.5, ROOT_THREE + 1.5),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_1_2() {
        val actual = instance.getPolygon(GridReference(1, 2)).vertices
        println("1,2: ${actual}")
        assertEqualPoints(
            listOf(
                Point(1.0, 1.5 + HALF_ROOT_THREE),
                Point(1 + HALF_ROOT_THREE, 2.0 + HALF_ROOT_THREE),
                Point(0.5 + HALF_ROOT_THREE, 2.0 + ROOT_THREE),
                Point(0.5, 1.5 + ROOT_THREE),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_2_2() {
        val actual = instance.getPolygon(GridReference(2, 2)).vertices
        println("2,2: ${actual}")
        assertEqualPoints(
            listOf(
                Point(1.0 + HALF_ROOT_THREE, 2.0 + HALF_ROOT_THREE),
                Point(1.5 + HALF_ROOT_THREE, 2.0 + ROOT_THREE),
                Point(0.5 + HALF_ROOT_THREE, 2.0 + ROOT_THREE),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_3_2() {
        val actual = instance.getPolygon(GridReference(3, 2)).vertices
        println("3,2: ${actual}")
        assertEqualPoints(
            listOf(
                Point(1 + ROOT_THREE, 1.5 + HALF_ROOT_THREE),
                Point(1.5 + ROOT_THREE, 1.5 + ROOT_THREE),
                Point(1.5 + HALF_ROOT_THREE, 2.0 + ROOT_THREE),
                Point(1.0 + HALF_ROOT_THREE, 2.0 + HALF_ROOT_THREE),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_4_2() {
        val actual = instance.getPolygon(GridReference(4, 2)).vertices
        println("4,2: ${actual}")
        assertEqualPoints(
            listOf(
                Point(1 + ROOT_THREE, HALF_ROOT_THREE + 1.5),
                Point(2 + ROOT_THREE, HALF_ROOT_THREE + 1.5),
                Point(1.5 + ROOT_THREE, ROOT_THREE + 1.5),
            ), actual
        )
    }

    companion object {
        val instance = RhombiTriHexagonalGridCellPositioner
        val ROOT_THREE = sqrt(3.0)
        val HALF_ROOT_THREE = ROOT_THREE / 2
    }

}