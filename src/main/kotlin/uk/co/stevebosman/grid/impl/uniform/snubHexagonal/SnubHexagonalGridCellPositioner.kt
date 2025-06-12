package uk.co.stevebosman.grid.impl.uniform.snubHexagonal

import uk.co.stevebosman.geometry.Circle
import uk.co.stevebosman.geometry.Point
import uk.co.stevebosman.geometry.Polygon
import uk.co.stevebosman.geometry.RegularConvexPolygonBuilder
import uk.co.stevebosman.grid.CellPositioner
import uk.co.stevebosman.grid.GridReference
import kotlin.math.PI
import kotlin.math.asin
import kotlin.math.sqrt

/**
 * Works out positions for a given square/octagonal grid reference.
 */
object SnubHexagonalGridCellPositioner : CellPositioner {
    private val polygon_cache = mutableMapOf<GridReference, Polygon>()
    private val ROOT_THREE = sqrt(3.0)
    private val HALF_ROOT_THREE = ROOT_THREE / 2
    private val REPETITION_X = ROOT_THREE + 1
    private val REPETITION_Y = ROOT_THREE + 3
    private val HORIZONTAL_OFFSET = sqrt(3.0 / 7.0)
    private val ROTATE = asin(HORIZONTAL_OFFSET / 2) * 180 / PI

    override fun getPolygon(gridReference: GridReference): Polygon = polygon_cache.getOrPut(gridReference) {
        when (SnubHexagonalCellType.of(gridReference)) {
            SnubHexagonalCellType.Hexagon -> RegularConvexPolygonBuilder(6).rotationDegrees(-90.0 + ROTATE)
                .centre(incentre(gridReference)).build()

            SnubHexagonalCellType.TriangleRight -> RegularConvexPolygonBuilder(3).rotationDegrees(-60.0 + ROTATE)
                .centre(incentre(gridReference)).build()

            SnubHexagonalCellType.TriangleLeft -> RegularConvexPolygonBuilder(3).rotationDegrees(-0.0 + ROTATE)
                .centre(incentre(gridReference)).build()
        }
    }

    override fun getInscribedCircle(gridReference: GridReference): Circle {
        val polygon = getPolygon(gridReference)
        return Circle(polygon.centre, polygon.apothem)
    }

    private fun incentre(gridReference: GridReference): Point = when (SnubHexagonalCellType.of(gridReference)) {
        SnubHexagonalCellType.Hexagon -> incentreHexagon(gridReference)
        SnubHexagonalCellType.TriangleRight -> incentreTriangleRight(gridReference)
        SnubHexagonalCellType.TriangleLeft -> incentreTriangleLeft(gridReference)
    }

    private fun incentreHexagon(gridReference: GridReference): Point = Point(
        (if (gridReference.y % 6 == 2) 1 + HALF_ROOT_THREE else 1.5 + ROOT_THREE) + (gridReference.x / 4) * REPETITION_X,
        (if (gridReference.y % 4 == 1) 1 + HALF_ROOT_THREE else 2.5 + ROOT_THREE) + (gridReference.y / 4) * REPETITION_Y
    )

    private fun incentreTriangleRight(gridReference: GridReference): Point =
        when (gridReference.y % 4) {
            0 -> Point(gridReference.x.toDouble(), gridReference.y.toDouble())
            1 -> Point(gridReference.x.toDouble(), gridReference.y.toDouble())
            2 -> Point(gridReference.x.toDouble(), gridReference.y.toDouble())
            else -> Point(gridReference.x.toDouble(), gridReference.y.toDouble())
        }


    private fun incentreTriangleLeft(gridReference: GridReference): Point =
        when (gridReference.y % 4) {
            0 -> Point(gridReference.x.toDouble(), gridReference.y.toDouble())
            1 -> Point(gridReference.x.toDouble(), gridReference.y.toDouble())
            2 -> Point(gridReference.x.toDouble(), gridReference.y.toDouble())
            else -> Point(gridReference.x.toDouble(), gridReference.y.toDouble())
        }

}