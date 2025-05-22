package uk.co.stevebosman.grid.impl.regular.hex

import uk.co.stevebosman.grid.CellPositioner
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.geometry.Point
import kotlin.math.sqrt

/**
 * Works out positions for a given hexagonal grid reference.
 */
object HexGridCellPositioner : CellPositioner {
    private val cache = mutableMapOf<GridReference, List<Point>>()
    private val HALF_ROOT_THREE = sqrt(3.0) / 2

    override fun getVertices(gridReference: GridReference): List<Point> =
        cache.getOrPut(gridReference) {
            if (gridReference.y % 2 == 0) {
                listOf(
                    Point(gridReference.x * HALF_ROOT_THREE, 0.5 + 2 * gridReference.y),
                    Point((gridReference.x + 1) * HALF_ROOT_THREE, 0.0 + 2 * gridReference.y),
                    Point((gridReference.x + 2) * HALF_ROOT_THREE, 0.5 + 2 * gridReference.y),
                    Point((gridReference.x + 2) * HALF_ROOT_THREE, 1.5 + 2 * gridReference.y),
                    Point((gridReference.x + 1) * HALF_ROOT_THREE, 2.0 + 2 * gridReference.y),
                    Point(gridReference.x * HALF_ROOT_THREE, 1.5 + 2 * gridReference.y),
                )
            } else {
                listOf(
                    Point((gridReference.x + 1) * HALF_ROOT_THREE, 0.0 + 2 * gridReference.y),
                    Point((gridReference.x + 2) * HALF_ROOT_THREE, -0.5 + 2 * gridReference.y),
                    Point((gridReference.x + 3) * HALF_ROOT_THREE, 0.0 + 2 * gridReference.y),
                    Point((gridReference.x + 3) * HALF_ROOT_THREE, 1.0 + 2 * gridReference.y),
                    Point((gridReference.x + 2) * HALF_ROOT_THREE, 1.5 + 2 * gridReference.y),
                    Point((gridReference.x + 1) * HALF_ROOT_THREE, 1.0 + 2 * gridReference.y)
                )
            }
        }
}