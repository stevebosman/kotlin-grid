package uk.co.stevebosman.grid.impl.regular.square

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import uk.co.stevebosman.geometry.Circle
import uk.co.stevebosman.geometry.Point
import uk.co.stevebosman.grid.GridReference

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
            instance.getVertices(ref)
        ) { -> "Wrong vertices for $ref" }
    }

    @Test
    fun testInscribedCircleForOrigin() {
        assertEquals(
            Circle(Point(0.5, 0.5), 0.5),
            instance.getInscribedCircle(GridReference(0, 0))
        )
    }

    @Test
    fun testInscribedCircleForRandomGridReference() {
        val ref = GridReference((1..10).random(), (1..10).random())
        assertEquals(
            Circle(Point(ref.x + 0.5, ref.y + 0.5), 0.5),
            instance.getInscribedCircle(ref)
        ) { -> "Wrong inscribedCircle for $ref" }
    }

    companion object {
        val instance = SquareGridCellPositioner
    }
}