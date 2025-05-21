package uk.co.stevebosman.grid.impl.regular.square

import uk.co.stevebosman.grid.CellPositioner
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.geometry.Point

object SquareGridCellPositioner : CellPositioner {
    private val cache = mutableMapOf<GridReference, List<Point>>()

    override fun getVertices(gridReference: GridReference): List<Point> =
        cache.getOrPut(gridReference) {
            listOf(
                Point(gridReference.x.toDouble(), gridReference.y.toDouble()),
                Point(gridReference.x + 1.0, gridReference.y.toDouble()),
                Point(gridReference.x + 1.0, gridReference.y + 1.0),
                Point(gridReference.x.toDouble(), gridReference.y + 1.0)
            )
        }
}