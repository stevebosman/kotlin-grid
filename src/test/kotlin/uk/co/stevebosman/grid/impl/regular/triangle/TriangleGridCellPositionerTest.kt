package uk.co.stevebosman.grid.impl.regular.triangle

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.grid.Point
import kotlin.math.sqrt

class TriangleGridCellPositionerTest {
    @Test
    fun testOrigin() {
        assertEquals(
            listOf(
                Point(0.0, 0.0),
                Point(1.0, 0.0),
                Point(0.5, HALF_ROOT_THREE)
            ), instance.getVertices(GridReference(0, 0))
        )
    }

    @Test
    fun testInnerUp() {
        assertEquals(
            listOf(
                Point(5.0, HALF_ROOT_THREE * 6),
                Point(6.0, HALF_ROOT_THREE * 6),
                Point(5.5, HALF_ROOT_THREE * 7)
            ), instance.getVertices(GridReference(10, 6))
        )
    }

    @Test
    fun testFirstDown() {
        assertEquals(
            listOf(
                Point(1.0, 0.0),
                Point(1.5, HALF_ROOT_THREE),
                Point(0.5, HALF_ROOT_THREE)
            ), instance.getVertices(GridReference(1, 0))
        )
    }

    @Test
    fun testInnerDown() {
        assertEquals(
            listOf(
                Point(2.5, HALF_ROOT_THREE * 3),
                Point(3.0, HALF_ROOT_THREE * 4),
                Point(2.0, HALF_ROOT_THREE * 4)
            ), instance.getVertices(GridReference(4, 3))
        )
    }

    companion object {
        val instance = TriangleGridCellPositioner()
        val HALF_ROOT_THREE = sqrt(3.0) / 2
    }
}