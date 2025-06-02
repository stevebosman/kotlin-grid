package uk.co.stevebosman.grid

import org.junit.jupiter.api.Test
import uk.co.stevebosman.geometry.Circle
import uk.co.stevebosman.geometry.Point
import uk.co.stevebosman.grid.impl.regular.square.SquareGridCellPositioner
import uk.co.stevebosman.test.GridAssertions.assertEqualCircles
import uk.co.stevebosman.test.GridAssertions.assertEqualPoints

class CellTest {
    @Test
    fun canGetVerticesFromCell() {
        assertEqualPoints(
            listOf(Point(0.0, 0.0), Point(1.0, 0.0), Point(1.0, 1.0), Point(0.0, 1.0)),
            Cell(GridReference(0, 0), listOf(), SquareGridCellPositioner).getPolygon().vertices
        )
    }

    @Test
    fun canGetIncircleFromCell() {
        assertEqualCircles(
            Circle(Point(0.5, 0.5), 0.5),
            Cell(GridReference(0, 0), listOf(), SquareGridCellPositioner).getInscribedCircle()
        )
    }
}