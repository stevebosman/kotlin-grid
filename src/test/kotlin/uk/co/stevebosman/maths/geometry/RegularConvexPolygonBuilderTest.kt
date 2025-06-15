package uk.co.stevebosman.maths.geometry

import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.math.sqrt
import kotlin.test.Test

class RegularConvexPolygonBuilderTest {
    @Test
    fun canCreateUnitSquare() {
        val n = 4
        val actual = RegularConvexPolygonBuilder(n).build()
        assertAll(
            { assertEquals(n, actual.sideCount) { -> "sideCount" } },
            { assertEquals(ROOT_HALF, actual.circumradius, 1e-15) { -> "circumradius" } },
            { assertEquals(0.5, actual.apothem, 1e-15) { -> "apothem" } },
            { assertEquals(0.0, actual.centre.x, 1e-15) { -> "centre.x" } },
            { assertEquals(0.0, actual.centre.y, 1e-15) { -> "centre.x" } },
            {
                assertEquals(n, actual.vertices.size) { -> "number of vertices: ${actual.vertices}" }
                assertAll(
                    { assertEquals(ROOT_HALF, actual.vertices[0].x, 1e-15) { -> "vertex[0}.x" } },
                    { assertEquals(0.0, actual.vertices[0].y, 1e-15) { -> "vertex[0}.y" } },
                    { assertEquals(0.0, actual.vertices[1].x, 1e-15) { -> "vertex[1}.x" } },
                    { assertEquals(ROOT_HALF, actual.vertices[1].y, 1e-15) { -> "vertex[1}.y" } },
                    { assertEquals(-ROOT_HALF, actual.vertices[2].x, 1e-15) { -> "vertex[2}.x" } },
                    { assertEquals(0.0, actual.vertices[2].y, 1e-15) { -> "vertex[2}.y" } },
                    { assertEquals(0.0, actual.vertices[3].x, 1e-15) { -> "vertex[3}.x" } },
                    { assertEquals(-ROOT_HALF, actual.vertices[3].y, 1e-15) { -> "vertex[3}.y" } }
                )
            }
        )
    }

    @Test
    fun canCreateSquareLength3() {
        val n = 4
        val actual = RegularConvexPolygonBuilder(n).size(3.0).build()
        assertAll(
            { assertEquals(n, actual.sideCount) { -> "sideCount" } },
            { assertEquals(3 * ROOT_HALF, actual.circumradius, 1e-15) { -> "circumradius" } },
            { assertEquals(1.5, actual.apothem, 1e-15) { -> "apothem" } },
            { assertEquals(0.0, actual.centre.x, 1e-15) { -> "centre.x" } },
            { assertEquals(0.0, actual.centre.y, 1e-15) { -> "centre.x" } },
            {
                assertEquals(n, actual.vertices.size) { -> "number of vertices: ${actual.vertices}" }
                assertAll(
                    { assertEquals(3.0 * ROOT_HALF, actual.vertices[0].x, 1e-15) { -> "vertex[0}.x" } },
                    { assertEquals(0.0, actual.vertices[0].y, 1e-15) { -> "vertex[0}.y" } },
                    { assertEquals(0.0, actual.vertices[1].x, 1e-15) { -> "vertex[1}.x" } },
                    { assertEquals(3.0 * ROOT_HALF, actual.vertices[1].y, 1e-15) { -> "vertex[1}.y" } },
                    { assertEquals(-3.0 * ROOT_HALF, actual.vertices[2].x, 1e-15) { -> "vertex[2}.x" } },
                    { assertEquals(0.0, actual.vertices[2].y, 1e-15) { -> "vertex[2}.y" } },
                    { assertEquals(0.0, actual.vertices[3].x, 1e-15) { -> "vertex[3}.x" } },
                    { assertEquals(-3.0 * ROOT_HALF, actual.vertices[3].y, 1e-15) { -> "vertex[3}.y" } }
                )
            }
        )
    }

    @Test
    fun canCreateOffsetScaledSquare() {
        val n = 4
        val actual = RegularConvexPolygonBuilder(n).size(3.0).centre(Point(2.0, 3.0)).build()
        assertAll(
            { assertEquals(n, actual.sideCount) { -> "sideCount" } },
            { assertEquals(3 * ROOT_HALF, actual.circumradius, 1e-15) { -> "circumradius" } },
            { assertEquals(1.5, actual.apothem, 1e-15) { -> "apothem" } },
            { assertEquals(2.0, actual.centre.x, 1e-15) { -> "centre.x" } },
            { assertEquals(3.0, actual.centre.y, 1e-15) { -> "centre.x" } },
            {
                assertEquals(n, actual.vertices.size) { -> "number of vertices: ${actual.vertices}" }
                assertAll(
                    { assertEquals(2.0 + 3.0 * ROOT_HALF, actual.vertices[0].x, 1e-15) { -> "vertex[0}.x" } },
                    { assertEquals(3.0, actual.vertices[0].y, 1e-15) { -> "vertex[0}.y" } },
                    { assertEquals(2.0, actual.vertices[1].x, 1e-15) { -> "vertex[1}.x" } },
                    { assertEquals(3.0 + 3.0 * ROOT_HALF, actual.vertices[1].y, 1e-15) { -> "vertex[1}.y" } },
                    { assertEquals(2.0 - 3.0 * ROOT_HALF, actual.vertices[2].x, 1e-15) { -> "vertex[2}.x" } },
                    { assertEquals(3.0, actual.vertices[2].y, 1e-15) { -> "vertex[2}.y" } },
                    { assertEquals(2.0, actual.vertices[3].x, 1e-15) { -> "vertex[3}.x" } },
                    { assertEquals(3.0 - 3.0 * ROOT_HALF, actual.vertices[3].y, 1e-15) { -> "vertex[3}.y" } }
                )
            }
        )
    }

    @Test
    fun canCreateOffsetRotatedUnitSquare() {
        val n = 4
        val actual = RegularConvexPolygonBuilder(n)
            .rotationDegrees(45.0)
            .centre(Point(2.0, 3.0))
            .build()
        assertAll(
            { assertEquals(n, actual.sideCount) { -> "sideCount" } },
            { assertEquals(ROOT_HALF, actual.circumradius, 1e-15) { -> "circumradius" } },
            { assertEquals(0.5, actual.apothem, 1e-15) { -> "apothem" } },
            { assertEquals(2.0, actual.centre.x, 1e-15) { -> "centre.x" } },
            { assertEquals(3.0, actual.centre.y, 1e-15) { -> "centre.x" } },
            {
                assertEquals(n, actual.vertices.size) { -> "number of vertices: ${actual.vertices}" }
                assertAll(
                    { assertEquals(2.5, actual.vertices[0].x, 1e-15) { -> "vertex[0}.x" } },
                    { assertEquals(3.5, actual.vertices[0].y, 1e-15) { -> "vertex[0}.y" } },
                    { assertEquals(1.5, actual.vertices[1].x, 1e-15) { -> "vertex[1}.x" } },
                    { assertEquals(3.5, actual.vertices[1].y, 1e-15) { -> "vertex[1}.y" } },
                    { assertEquals(1.5, actual.vertices[2].x, 1e-15) { -> "vertex[2}.x" } },
                    { assertEquals(2.5, actual.vertices[2].y, 1e-15) { -> "vertex[2}.y" } },
                    { assertEquals(2.5, actual.vertices[3].x, 1e-15) { -> "vertex[3}.x" } },
                    { assertEquals(2.5, actual.vertices[3].y, 1e-15) { -> "vertex[3}.y" } }
                )
            }
        )
    }

    @Test
    fun canCreateUnitTriangle() {
        val n = 3
        val actual = RegularConvexPolygonBuilder(n).build()
        assertAll(
            { assertEquals(n, actual.sideCount) { -> "sideCount" } },
            { assertEquals(HALF_ROOT_THREE * 2.0 / 3.0, actual.circumradius, 1e-15) { -> "circumradius" } },
            { assertEquals(HALF_ROOT_THREE / 3.0, actual.apothem, 1e-15) { -> "apothem" } },
            { assertEquals(0.0, actual.centre.x, 1e-15) { -> "centre.x" } },
            { assertEquals(0.0, actual.centre.y, 1e-15) { -> "centre.x" } },
            {
                assertEquals(n, actual.vertices.size) { -> "number of vertices: ${actual.vertices}" }
                assertAll(
                    { assertEquals(HALF_ROOT_THREE * 2.0 / 3.0, actual.vertices[0].x, 1e-15) { -> "vertex[0}.x" } },
                    { assertEquals(0.0, actual.vertices[0].y, 1e-15) { -> "vertex[0}.y" } },
                    { assertEquals(-HALF_ROOT_THREE / 3.0, actual.vertices[1].x, 1e-15) { -> "vertex[1}.x" } },
                    { assertEquals(0.5, actual.vertices[1].y, 1e-15) { -> "vertex[1}.y" } },
                    { assertEquals(-HALF_ROOT_THREE / 3.0, actual.vertices[2].x, 1e-15) { -> "vertex[2}.x" } },
                    { assertEquals(-0.5, actual.vertices[2].y, 1e-15) { -> "vertex[2}.y" } },
                )
            }
        )
    }

    companion object {
        private val ROOT_HALF = sqrt(0.5)
        private val HALF_ROOT_THREE = sqrt(3.0) / 2
    }
}
