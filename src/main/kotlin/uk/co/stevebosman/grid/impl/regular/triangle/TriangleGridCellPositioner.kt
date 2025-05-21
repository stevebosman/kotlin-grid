package uk.co.stevebosman.grid.impl.regular.triangle

import uk.co.stevebosman.grid.CellPositioner
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.geometry.Point
import kotlin.math.sqrt

/**
 * Works out positions for a given triangular grid reference.
 */
object TriangleGridCellPositioner : CellPositioner {
    private val cache = mutableMapOf<GridReference, List<Point>>()
    private val HALF_ROOT_THREE = sqrt(3.0) / 2

    override fun getVertices(gridReference: GridReference): List<Point> =
        cache.getOrPut(gridReference) {
            if ((gridReference.x + gridReference.y) % 2 == 0) {
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
}