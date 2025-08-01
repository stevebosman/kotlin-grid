package uk.co.stevebosman.grid.impl.uniform.squareOctagon2

import uk.co.stevebosman.grid.CellPositioner
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.grid.impl.uniform.squareOctagon2.SquareOctagon2GridHelper.isSquareCell
import uk.co.stevebosman.maths.geometry.Circle
import uk.co.stevebosman.maths.geometry.Point
import uk.co.stevebosman.maths.geometry.Polygon
import uk.co.stevebosman.maths.geometry.RegularConvexPolygonBuilder
import kotlin.math.sqrt

/**
 * Works out positions for a given square/octagonal grid reference.
 */
object SquareOctagon2GridCellPositioner : CellPositioner {
    private val polygon_cache = mutableMapOf<GridReference, Polygon>()
    private val ROOT_HALF = sqrt(0.5)
    private val STEP = ROOT_HALF + 1

    override fun getPolygon(gridReference: GridReference): Polygon =
        polygon_cache.getOrPut(gridReference) {
            if (isSquareCell(gridReference)) {
                RegularConvexPolygonBuilder(4).rotationDegrees(-135.0)
                    .centre(incentre(gridReference))
                    .build()

            } else {
                RegularConvexPolygonBuilder(8).rotationDegrees(-112.5)
                    .centre(incentre(gridReference))
                    .build()
            }
        }

    override fun getInscribedCircle(gridReference: GridReference): Circle {
        val polygon = getPolygon(gridReference)
        return Circle(polygon.centre, polygon.apothem)
    }

    private fun incentre(gridReference: GridReference): Point =
        Point(
            0.5 + ROOT_HALF + STEP * gridReference.x,
            0.5 + ROOT_HALF + STEP * gridReference.y
        )
}