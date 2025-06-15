package uk.co.stevebosman.grid.impl.uniform.snubHexagonal

import org.junit.jupiter.api.Test
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.maths.geometry.Point
import uk.co.stevebosman.test.GridAssertions.assertEqualPoints
import kotlin.math.sqrt
import kotlin.test.assertFailsWith

class SnubHexagonalGridCellPositionerTest {
    @Test
    fun testVerticesFor_0_0() {
        val actual = instance.getPolygon(GridReference(0, 0)).vertices
        println("0,0: ${actual}")
        assertEqualPoints(
            listOf(
                Point(0.9449111825230683, 1.6366341767699428),
                Point(0.0, 1.3093073414159546),
                Point(0.7559289460184544, 0.654653670707977),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_1_0() {
        val actual = instance.getPolygon(GridReference(1, 0)).vertices
        println("1,0: ${actual}")
        assertEqualPoints(
            listOf(
                Point(0.7559289460184544, 0.6546536707079773),
                Point(1.7008401285415227, 0.9819805060619656),
                Point(0.9449111825230684, 1.636634176769943),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_2_0() {
        val actual = instance.getPolygon(GridReference(2, 0)).vertices
        println("2,0: ${actual}")
        assertEqualPoints(
            listOf(
                Point(1.7008401285415224, 0.9819805060619657),
                Point(0.7559289460184543, 0.6546536707079775),
                Point(1.5118578920369086, 0.0),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_3_0() {
        val actual = instance.getPolygon(GridReference(3, 0)).vertices
        println("3,0: ${actual}")
        assertEqualPoints(
            listOf(
                Point(1.5118578920369088, 0.0),
                Point(2.456769074559977, 0.3273268353539882),
                Point(1.7008401285415227, 0.9819805060619657),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_4_0() {
        val actual = instance.getPolygon(GridReference(4, 0)).vertices
        println("4,0: ${actual}")
        assertEqualPoints(
            listOf(
                Point(2.6457513110645907, 1.309307341415954),
                Point(1.7008401285415227, 0.9819805060619657),
                Point(2.456769074559977, 0.3273268353539881),
            ), actual
        )
    }


    @Test
    fun testVerticesFor_5_0() {
        val actual = instance.getPolygon(GridReference(5, 0)).vertices
        println("5,0: ${actual}")
        assertEqualPoints(
            listOf(
                Point(2.456769074559977, 0.3273268353539884),
                Point(3.401680257083045, 0.6546536707079768),
                Point(2.6457513110645907, 1.3093073414159542),
            ), actual
        )
    }


    @Test
    fun testVerticesFor_6_0() {
        val actual = instance.getPolygon(GridReference(6, 0)).vertices
        println("6,0: ${actual}")
        assertEqualPoints(
            listOf(
                Point(3.5906624935876588, 1.6366341767699428),
                Point(2.6457513110645907, 1.3093073414159546),
                Point(3.401680257083045, 0.654653670707977),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_0_1() {
        val actual = instance.getPolygon(GridReference(0, 1)).vertices
        println("0,1: ${actual}")
        assertEqualPoints(
            listOf(
                Point(0.0, 1.3093073414159542),
                Point(0.9449111825230683, 1.6366341767699426),
                Point(0.18898223650461404, 2.29128784747792),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_1_1() {
        val actual = instance.getPolygon(GridReference(1, 1)).vertices
        println("1,1: ${actual}")
        assertEqualPoints(
            listOf(
                Point(1.1338934190276821, 2.6186146828319083),
                Point(0.18898223650461388, 2.29128784747792),
                Point(0.9449111825230683, 1.6366341767699426),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_2_1() {
        val actual = instance.getPolygon(GridReference(2, 1)).vertices
        println("2,1: ${actual}")
        assertEqualPoints(
            listOf(
                Point(1.7008401285415227, 0.9819805060619655),
                Point(2.6457513110645907, 1.3093073414159542),
                Point(2.834733547569204, 2.2912878474779195),
                Point(2.07880460155075, 2.945941518185897),
                Point(1.133893419027682, 2.618614682831909),
                Point(0.9449111825230679, 1.6366341767699428),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_3_1() {
        assertFailsWith<IllegalStateException> { instance.getPolygon(GridReference(3, 1)) }
    }

    @Test
    fun testVerticesFor_4_1() {
        assertFailsWith<IllegalStateException> { instance.getPolygon(GridReference(4, 1)) }
    }

    @Test
    fun testVerticesFor_5_1() {
        assertFailsWith<IllegalStateException> { instance.getPolygon(GridReference(5, 1)) }
    }

    @Test
    fun testVerticesFor_6_1() {
        val actual = instance.getPolygon(GridReference(6, 1)).vertices
        println("6,1: ${actual}")
        assertEqualPoints(
            listOf(
                Point(2.6457513110645907, 1.3093073414159542),
                Point(3.5906624935876588, 1.6366341767699426),
                Point(2.8347335475692046, 2.29128784747792),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_0_2() {
        val actual = instance.getPolygon(GridReference(0, 2)).vertices
        println("0,2: ${actual}")
        assertEqualPoints(
            listOf(
                Point(0.18898223650461254, 2.2912878474779195),
                Point(1.1338934190276806, 2.618614682831908),
                Point(0.37796447300922653, 3.273268353539885),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_1_2() {
        val actual = instance.getPolygon(GridReference(1, 2)).vertices
        println("1,2: ${actual}")
        assertEqualPoints(
            listOf(
                Point(1.3228756555322945, 3.6005951888938736),
                Point(0.3779644730092263, 3.273268353539885),
                Point(1.1338934190276806, 2.618614682831908),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_2_2() {
        val actual = instance.getPolygon(GridReference(2, 2)).vertices
        println("2,2: ${actual}")
        assertEqualPoints(
            listOf(
                Point(1.133893419027681, 2.618614682831908),
                Point(2.078804601550749, 2.9459415181858963),
                Point(1.322875655532295, 3.6005951888938736),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_3_2() {
        val actual = instance.getPolygon(GridReference(3, 2)).vertices
        println("3,2: ${actual}")
        assertEqualPoints(
            listOf(
                Point(2.2677868380553625, 3.9279220242478625),
                Point(1.3228756555322945, 3.600595188893874),
                Point(2.0788046015507486, 2.945941518185897),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_4_2() {
        val actual = instance.getPolygon(GridReference(4, 2)).vertices
        println("4,2: ${actual}")
        assertEqualPoints(
            listOf(
                Point(2.078804601550749, 2.945941518185897),
                Point(3.023715784073817, 3.273268353539885),
                Point(2.267786838055363, 3.9279220242478625),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_5_2() {
        val actual = instance.getPolygon(GridReference(5, 2)).vertices
        println("5,2: ${actual}")
        assertEqualPoints(
            listOf(
                Point(3.023715784073817, 3.273268353539885),
                Point(2.078804601550749, 2.945941518185897),
                Point(2.8347335475692033, 2.2912878474779195),
            ), actual
        )
    }

    @Test
    fun testVerticesFor_6_2() {
        val actual = instance.getPolygon(GridReference(6, 2)).vertices
        println("6,2: ${actual}")
        assertEqualPoints(
            listOf(
                Point(2.8347335475692033, 2.2912878474779195),
                Point(3.7796447300922713, 2.618614682831908),
                Point(3.023715784073817, 3.273268353539885),
            ), actual
        )
    }

    companion object {
        val instance = SnubHexagonalGridCellPositioner
        val ROOT_THREE = sqrt(3.0)
        val HALF_ROOT_THREE = ROOT_THREE / 2
    }

}