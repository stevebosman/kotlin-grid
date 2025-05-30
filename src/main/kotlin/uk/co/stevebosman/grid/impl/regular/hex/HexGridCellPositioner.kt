package uk.co.stevebosman.grid.impl.regular.hex

import uk.co.stevebosman.geometry.Circle
import uk.co.stevebosman.geometry.Point
import uk.co.stevebosman.geometry.Polygon
import uk.co.stevebosman.geometry.RegularConvexPolygonBuilder
import uk.co.stevebosman.grid.CellPositioner
import uk.co.stevebosman.grid.GridReference
import kotlin.math.sqrt

/**
 * Works out positions for a given hexagonal grid reference.
 */
object HexGridCellPositioner : CellPositioner {
    private val polygon_cache = mutableMapOf<GridReference, Polygon>()
    private val HALF_ROOT_THREE = sqrt(3.0) / 2

    override fun getPolygon(gridReference: GridReference): Polygon =
        polygon_cache.getOrPut(gridReference) {
            RegularConvexPolygonBuilder(6).rotationDegrees(-90.0)
                .centre(incentre(gridReference))
                .build()
        }

    override fun getVertices(gridReference: GridReference): List<Point> =
        getPolygon(gridReference).vertices

    override fun getInscribedCircle(gridReference: GridReference): Circle {
        val polygon = getPolygon(gridReference)
        return Circle(polygon.centre, polygon.apothem)
    }

    private fun incentre(gridReference: GridReference): Point =
        if (gridReference.y % 2 == 0) {
            Point(HALF_ROOT_THREE + gridReference.x * 2 * HALF_ROOT_THREE, 1.0 + 1.5 * gridReference.y)
        } else {
            Point((gridReference.x + 1) * 2 * HALF_ROOT_THREE, 1 + 1.5 * gridReference.y)
        }

}