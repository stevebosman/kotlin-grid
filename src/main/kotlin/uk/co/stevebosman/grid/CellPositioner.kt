package uk.co.stevebosman.grid

import uk.co.stevebosman.geometry.Circle
import uk.co.stevebosman.geometry.Point

interface CellPositioner {
    fun getVertices(gridReference: GridReference): List<Point>
    fun getInscribedCircle(gridReference: GridReference): Circle
}