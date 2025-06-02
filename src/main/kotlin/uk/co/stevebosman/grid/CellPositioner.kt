package uk.co.stevebosman.grid

import uk.co.stevebosman.geometry.Circle
import uk.co.stevebosman.geometry.Point
import uk.co.stevebosman.geometry.Polygon

interface CellPositioner {
    fun getPolygon(gridReference: GridReference): Polygon
    fun getInscribedCircle(gridReference: GridReference): Circle
}