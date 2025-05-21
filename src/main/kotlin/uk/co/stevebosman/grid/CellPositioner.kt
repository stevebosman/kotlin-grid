package uk.co.stevebosman.grid

import uk.co.stevebosman.geometry.Point

interface CellPositioner {
    fun getVertices(gridReference: GridReference): List<Point>
}