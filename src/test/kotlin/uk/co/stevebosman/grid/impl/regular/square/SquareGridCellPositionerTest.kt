package uk.co.stevebosman.grid.impl.regular.square

import org.junit.jupiter.api.Test
import uk.co.stevebosman.geometry.Circle
import uk.co.stevebosman.geometry.Point
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.test.GridAssertions.assertEqualCircles
import uk.co.stevebosman.test.GridAssertions.assertEqualPoints

class SquareGridCellPositionerTest {
    @Test
    fun testVerticesForOrigin() {
        assertEqualPoints(
            listOf(
                Point(0.0, 0.0),
                Point(1.0, 0.0),
                Point(1.0, 1.0),
                Point(0.0, 1.0)
            ), instance.getPolygon(GridReference(0, 0)).vertices
        )
    }

    @Test
    fun testVerticesForRandomGridReference() {
        val ref = GridReference((1..10).random(), (1..10).random())
        assertEqualPoints(
            listOf(
                Point(ref.x.toDouble(), ref.y.toDouble()),
                Point(ref.x + 1.0, ref.y.toDouble()),
                Point(ref.x + 1.0, ref.y + 1.0),
                Point(ref.x.toDouble(), ref.y + 1.0)
            ),
            instance.getPolygon(ref).vertices
        )
    }

    @Test
    fun testInscribedCircleForOrigin() {
        assertEqualCircles(
            Circle(Point(0.5, 0.5), 0.5),
            instance.getInscribedCircle(GridReference(0, 0))
        )
    }

    @Test
    fun testInscribedCircleForRandomGridReference() {
        val ref = GridReference((1..10).random(), (1..10).random())
        assertEqualCircles(
            Circle(Point(ref.x + 0.5, ref.y + 0.5), 0.5),
            instance.getInscribedCircle(ref)
        )
    }

    companion object {
        val instance = SquareGridCellPositioner
    }
}