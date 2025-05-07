package uk.co.stevebosman.grid.regular_square

import uk.co.stevebosman.grid.CellPositioner
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.grid.Point

class SquareGridCellPositioner : CellPositioner {
    companion object {
        private val CACHE = mutableMapOf<GridReference, List<Point>>()
    }
    override fun getVertices(gridReference: GridReference): List<Point> =
        CACHE.getOrPut(gridReference) {
            listOf(
                Point(gridReference.x.toDouble(), gridReference.y.toDouble()),
                Point(gridReference.x + 1.0, gridReference.y.toDouble()),
                Point(gridReference.x + 1.0, gridReference.y + 1.0),
                Point(gridReference.x.toDouble(), gridReference.y + 1.0)
            )
        }
}