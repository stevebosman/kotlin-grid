package uk.co.stevebosman.grid.impl.regular.hex

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.grid.Point
import kotlin.math.sqrt

class HexGridCellPositionerTest {
    @Test
    fun testOrigin() {
        assertEquals(
            listOf(
                Point(0.0, 0.5),
                Point(HALF_ROOT_THREE, 0.0),
                Point(2 * HALF_ROOT_THREE, 0.5),
                Point(2 * HALF_ROOT_THREE, 1.5),
                Point(HALF_ROOT_THREE, 2.0),
                Point(0.0, 1.5)
            ), instance.getVertices(GridReference(0, 0))
        )
    }

    @Test
    fun testFirstRowOne() {
        assertEquals(
            listOf(
                Point(HALF_ROOT_THREE, 2.0),
                Point(2 * HALF_ROOT_THREE, 1.5),
                Point(3 * HALF_ROOT_THREE, 2.0),
                Point(3 * HALF_ROOT_THREE, 3.0),
                Point(2 * HALF_ROOT_THREE, 3.5),
                Point(HALF_ROOT_THREE, 3.0)
            ), instance.getVertices(GridReference(0, 1))
        )
    }


    @Test
    fun testEven() {
        assertEquals(
            listOf(
                Point(4 * HALF_ROOT_THREE, 8.5),
                Point(5 * HALF_ROOT_THREE, 8.0),
                Point(6 * HALF_ROOT_THREE, 8.5),
                Point(6 * HALF_ROOT_THREE, 9.5),
                Point(5 * HALF_ROOT_THREE, 10.0),
                Point(4 * HALF_ROOT_THREE, 9.5)
            ), instance.getVertices(GridReference(4, 4))
        )
    }

    @Test
    fun testOdd() {
        assertEquals(
            listOf(
                Point(7 * HALF_ROOT_THREE, 6.0),
                Point(8 * HALF_ROOT_THREE, 5.5),
                Point(9 * HALF_ROOT_THREE, 6.0),
                Point(9 * HALF_ROOT_THREE, 7.0),
                Point(8 * HALF_ROOT_THREE, 7.5),
                Point(7 * HALF_ROOT_THREE, 7.0)
            ), instance.getVertices(GridReference(6, 3))
        )
    }

    companion object {
        val instance = HexGridCellPositioner()
        val HALF_ROOT_THREE = sqrt(3.0) / 2
    }
}