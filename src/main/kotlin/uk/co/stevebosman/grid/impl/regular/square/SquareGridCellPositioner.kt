package uk.co.stevebosman.grid.impl.regular.square

import uk.co.stevebosman.geometry.Circle
import uk.co.stevebosman.geometry.Point
import uk.co.stevebosman.grid.CellPositioner
import uk.co.stevebosman.grid.GridReference

object SquareGridCellPositioner : CellPositioner {
    private val vertex_cache = mutableMapOf<GridReference, List<Point>>()
    private val inscribed_circle_cache = mutableMapOf<GridReference, Circle>()

    override fun getVertices(gridReference: GridReference): List<Point> =
        vertex_cache.getOrPut(gridReference) {
            listOf(
                Point(gridReference.x.toDouble(), gridReference.y.toDouble()),
                Point(gridReference.x + 1.0, gridReference.y.toDouble()),
                Point(gridReference.x + 1.0, gridReference.y + 1.0),
                Point(gridReference.x.toDouble(), gridReference.y + 1.0)
            )
        }

    override fun getInscribedCircle(gridReference: GridReference): Circle =
        inscribed_circle_cache.getOrPut(gridReference) {
            return Circle(Point(gridReference.x + 0.5, gridReference.y + 0.5), 0.5)
        }
}