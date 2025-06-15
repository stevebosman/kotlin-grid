package uk.co.stevebosman.grid

import uk.co.stevebosman.maths.geometry.Circle
import uk.co.stevebosman.maths.geometry.Polygon

interface CellPositioner {
    fun getPolygon(gridReference: GridReference): Polygon
    fun getInscribedCircle(gridReference: GridReference): Circle
}