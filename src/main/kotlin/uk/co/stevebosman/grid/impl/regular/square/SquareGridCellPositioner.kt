package uk.co.stevebosman.grid.impl.regular.square

import uk.co.stevebosman.maths.geometry.Circle
import uk.co.stevebosman.maths.geometry.Point
import uk.co.stevebosman.maths.geometry.Polygon
import uk.co.stevebosman.maths.geometry.RegularConvexPolygonBuilder
import uk.co.stevebosman.grid.CellPositioner
import uk.co.stevebosman.grid.GridReference

object SquareGridCellPositioner : CellPositioner {
    private val polygon_cache = mutableMapOf<GridReference, Polygon>()

    override fun getPolygon(gridReference: GridReference): Polygon =
        polygon_cache.getOrPut(gridReference) {
            RegularConvexPolygonBuilder(4).rotationDegrees(-135.0)
                .centre(Point(gridReference.x + 0.5, gridReference.y + 0.5))
                .build()
        }

    override fun getInscribedCircle(gridReference: GridReference): Circle {
        val polygon = getPolygon(gridReference)
        return Circle(polygon.centre, polygon.apothem)
    }
}