package uk.co.stevebosman.grid.impl.regular.triangle

import uk.co.stevebosman.maths.geometry.Circle
import uk.co.stevebosman.maths.geometry.Point
import uk.co.stevebosman.maths.geometry.Polygon
import uk.co.stevebosman.maths.geometry.RegularConvexPolygonBuilder
import uk.co.stevebosman.grid.CellPositioner
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.grid.impl.regular.triangle.TriangleGridHelper.isUp
import kotlin.math.sqrt

/**
 * Works out positions for a given triangular grid reference.
 */
object TriangleGridCellPositioner : CellPositioner {
    private val polygon_cache = mutableMapOf<GridReference, Polygon>()
    private val HALF_ROOT_THREE = sqrt(3.0) / 2
    private const val THIRD = 1 / 3.0

    override fun getPolygon(gridReference: GridReference): Polygon =
        polygon_cache.getOrPut(gridReference) {
            RegularConvexPolygonBuilder(3).rotationDegrees(if (isUp(gridReference)) -150.0 else -90.0)
                .centre(incentre(gridReference))
                .build()
        }

    private fun incentre(gridReference: GridReference): Point = Point(
        (gridReference.x + 1.0) / 2,
        HALF_ROOT_THREE * (gridReference.y + THIRD * if (isUp(gridReference)) 1 else 2)
    )

    override fun getInscribedCircle(gridReference: GridReference): Circle {
        val polygon = getPolygon(gridReference)
        return Circle(polygon.centre, polygon.apothem)
    }
}