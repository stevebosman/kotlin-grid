package uk.co.stevebosman.grid.impl.floretPentagonal

import org.junit.jupiter.api.Test
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.maths.geometry.Point
import uk.co.stevebosman.test.GridAssertions.assertEqualPoints

class FloretPentagonalGridCellPositionerTest {
    @Test
    fun testVerticesFor_0_0() {
        val actual = instance.getPolygon(GridReference(0, 0)).vertices
        println("0,0: ${actual}")
        assertEqualPoints(
            listOf(
                Point(0.03603898787606852, 1.6220355269907736),
                Point(-0.29128784747792036, 0.6771243444677055),
                Point(0.36336582323005673, -0.07880460155074909),
                Point(1.3453463292920222, 0.11017763495386423),
                Point(2.0, 2.0),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_1_0() {
        val actual = instance.getPolygon(GridReference(1, 0)).vertices
        println("1,0: ${actual}")
        assertEqualPoints(
            listOf(
                Point(1.3453463292920214, 0.11017763495386393),
                Point(2.0, -0.6457513110645907),
                Point(2.981980506061964, -0.4567690745599774),
                Point(3.309307341415953, 0.4881421079630902),
                Point(2.0, 2.0),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_2_0() {
        val actual = instance.getPolygon(GridReference(2, 0)).vertices
        println("2,0: ${actual}")
        assertEqualPoints(
            listOf(
                Point(3.3093073414159537, 0.48814210796309077),
                Point(4.2912878474779195, 0.6771243444677041),
                Point(4.618614682831908, 1.6220355269907716),
                Point(3.9639610121239324, 2.3779644730092264),
                Point(2.0, 2.0),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_0_1() {
        val actual = instance.getPolygon(GridReference(0, 1)).vertices
        println("0,1: ${actual}")
        assertEqualPoints(
            listOf(
                Point(0.6906926585840459, 3.511857892036909),
                Point(-0.2912878474779197, 3.3228756555322954),
                Point(-0.6186146828319086, 2.3779644730092273),
                Point(0.03603898787606852, 1.6220355269907727),
                Point(2.0, 2.0),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_1_1() {
        val actual = instance.getPolygon(GridReference(1, 1)).vertices
        println("1,1: ${actual}")
        assertEqualPoints(
            listOf(
                Point(2.6546536707079778, 3.889822365046136),
                Point(2.0, 4.645751311064591),
                Point(1.018019493938035, 4.456769074559977),
                Point(0.690692658584046, 3.5118578920369092),
                Point(2.0, 2.0),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_2_1() {
        val actual = instance.getPolygon(GridReference(2, 1)).vertices
        println("2,1: ${actual}")
        assertEqualPoints(
            listOf(
                Point(3.9639610121239315, 2.377964473009227),
                Point(4.29128784747792, 3.3228756555322945),
                Point(3.6366341767699444, 4.0788046015507495),
                Point(2.6546536707079786, 3.889822365046137),
                Point(2.0, 2.0),
            ), actual
        )
    }

    companion object {
        val instance = FloretPentagonalGridCellPositioner
    }
}