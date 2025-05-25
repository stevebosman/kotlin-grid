package uk.co.stevebosman.grid.impl.uniform.squareOctagon2

import uk.co.stevebosman.geometry.Circle
import uk.co.stevebosman.geometry.Point
import uk.co.stevebosman.grid.CellPositioner
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.grid.impl.uniform.squareOctagon2.SquareOctagon2GridHelper.isSquareCell
import java.lang.Math.toRadians
import kotlin.math.sqrt
import kotlin.math.tan

/**
 * Works out positions for a given square/octagonal grid reference.
 */
object SquareOctagon2GridCellPositioner : CellPositioner {
    private val vertex_cache = mutableMapOf<GridReference, List<Point>>()
    private val inscribed_circle_cache = mutableMapOf<GridReference, Circle>()
    private val HALF_ROOT_TWO = sqrt(2.0) / 2
    private val STEP = HALF_ROOT_TWO + 1
    private const val INCENTRE_RADIUS_SQUARE = 0.5
    private val INCENTRE_RADIUS_OCTAGON = 1 / (2.0 * tan(toRadians(180.0 / 8.0)))

    override fun getVertices(gridReference: GridReference): List<Point> =
        vertex_cache.getOrPut(gridReference) {
            if (isSquareCell(gridReference)) {
                val x0 = HALF_ROOT_TWO + STEP * gridReference.x
                val y0 = HALF_ROOT_TWO + STEP * gridReference.y
                listOf(
                    Point(x0, y0),
                    Point(x0 + 1, y0),
                    Point(x0 + 1, y0 + 1),
                    Point(x0, y0 + 1),
                )
            } else {
                val x0 = HALF_ROOT_TWO + STEP * gridReference.x
                val y0 = STEP * gridReference.y
                listOf(
                    Point(x0, y0),
                    Point(x0 - HALF_ROOT_TWO, y0 + HALF_ROOT_TWO),
                    Point(x0 - HALF_ROOT_TWO, y0 + HALF_ROOT_TWO + 1),
                    Point(x0, y0 + 2 * HALF_ROOT_TWO + 1),
                    Point(x0 + 1, y0 + 2 * HALF_ROOT_TWO + 1),
                    Point(x0 + 1 + HALF_ROOT_TWO, y0 + HALF_ROOT_TWO + 1),
                    Point(x0 + 1 + HALF_ROOT_TWO, y0 + HALF_ROOT_TWO),
                    Point(x0 + 1, y0),
                )
            }
        }

    override fun getInscribedCircle(gridReference: GridReference): Circle =
        inscribed_circle_cache.getOrPut(gridReference) {
            return Circle(
                incentre(gridReference),
                if (isSquareCell(gridReference)) INCENTRE_RADIUS_SQUARE else INCENTRE_RADIUS_OCTAGON
            )
        }

    private fun incentre(gridReference: GridReference): Point =
        Point(
            0.5 + HALF_ROOT_TWO + STEP * gridReference.x,
            0.5 + HALF_ROOT_TWO + STEP * gridReference.y
        )
}