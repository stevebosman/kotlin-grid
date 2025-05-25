package uk.co.stevebosman.grid.impl.regular.triangle

import uk.co.stevebosman.geometry.Circle
import uk.co.stevebosman.geometry.Point
import uk.co.stevebosman.grid.CellPositioner
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.grid.impl.regular.triangle.TriangleGridHelper.isUp
import kotlin.math.sqrt

/**
 * Works out positions for a given triangular grid reference.
 */
object TriangleGridCellPositioner : CellPositioner {
    private val vertex_cache = mutableMapOf<GridReference, List<Point>>()
    private val inscribed_circle_cache = mutableMapOf<GridReference, Circle>()
    private val HALF_ROOT_THREE = sqrt(3.0) / 2
    private val THIRD = 1 / 3.0
    private val INCENTRE_RADIUS = HALF_ROOT_THREE * THIRD

    override fun getVertices(gridReference: GridReference): List<Point> =
        vertex_cache.getOrPut(gridReference) {
            if (isUp(gridReference)) {
                listOf(
                    Point(gridReference.x.toDouble() / 2, gridReference.y * HALF_ROOT_THREE),
                    Point((gridReference.x + 2.0) / 2, gridReference.y * HALF_ROOT_THREE),
                    Point((gridReference.x + 1.0) / 2, (gridReference.y + 1) * HALF_ROOT_THREE),
                )
            } else {
                listOf(
                    Point((gridReference.x + 1.0) / 2, gridReference.y * HALF_ROOT_THREE),
                    Point((gridReference.x + 2.0) / 2, (gridReference.y + 1) * HALF_ROOT_THREE),
                    Point((gridReference.x) / 2.0, (gridReference.y + 1) * HALF_ROOT_THREE),
                )
            }
        }

    override fun getInscribedCircle(gridReference: GridReference): Circle =
        inscribed_circle_cache.getOrPut(gridReference) {
            return Circle(incentre(gridReference), INCENTRE_RADIUS)
        }

    private fun incentre(gridReference: GridReference): Point =
        Point(
            (gridReference.x + 1.0) / 2,
            HALF_ROOT_THREE * (gridReference.y + THIRD * if (isUp(gridReference)) 1 else 2)
        )
}