package uk.co.stevebosman.grid.impl.regular.square

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.geometry.Point

class SquareGridCellPositionerTest {
    @Test
    fun testVerticesForOrigin() {
        assertEquals(
            listOf(
                Point(0.0, 0.0),
                Point(1.0, 0.0),
                Point(1.0, 1.0),
                Point(0.0, 1.0)
            ), instance.getVertices(GridReference(0, 0))
        )
    }

    @Test
    fun testVerticesForRandomGridReference() {
        val ref = GridReference((1..10).random(), (1..10).random())
        assertEquals(
            listOf(
                Point(ref.x.toDouble(), ref.y.toDouble()),
                Point(ref.x + 1.0, ref.y.toDouble()),
                Point(ref.x + 1.0, ref.y + 1.0),
                Point(ref.x.toDouble(), ref.y + 1.0)
            ),
            instance.getVertices(ref),
            { -> "Wrong vertices for $ref" })
    }

    companion object {
        val instance = SquareGridCellPositioner
    }
}