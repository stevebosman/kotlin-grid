package uk.co.stevebosman.grid.impl.uniform.triHexagonal

import uk.co.stevebosman.geometry.Circle
import uk.co.stevebosman.geometry.Point
import uk.co.stevebosman.geometry.Polygon
import uk.co.stevebosman.geometry.RegularConvexPolygonBuilder
import uk.co.stevebosman.grid.CellPositioner
import uk.co.stevebosman.grid.GridReference
import kotlin.math.sqrt

/**
 * Works out positions for a given square/octagonal grid reference.
 */
object TriHexagonalGridCellPositioner : CellPositioner {
    private val polygon_cache = mutableMapOf<GridReference, Polygon>()
    private val HALF_ROOT_THREE = sqrt(3.0) / 2
    private const val THIRD = 1 / 3.0

    override fun getPolygon(gridReference: GridReference): Polygon =
        polygon_cache.getOrPut(gridReference) {
            when (TriHexagonalCellType.of(gridReference)) {
                TriHexagonalCellType.Hexagon ->
                    RegularConvexPolygonBuilder(6).rotationDegrees(-120.0)
                        .centre(incentre(gridReference))
                        .build()

                TriHexagonalCellType.TriangleUp ->
                    RegularConvexPolygonBuilder(3).rotationDegrees(-150.0)
                        .centre(incentre(gridReference))
                        .build()

                TriHexagonalCellType.TriangleDown ->
                    RegularConvexPolygonBuilder(3).rotationDegrees(-90.0)
                        .centre(incentre(gridReference))
                        .build()
            }
        }

    override fun getVertices(gridReference: GridReference): List<Point> =
        getPolygon(gridReference).vertices

    override fun getInscribedCircle(gridReference: GridReference): Circle {
        val polygon = getPolygon(gridReference)
        return Circle(polygon.centre, polygon.apothem)
    }

    private fun incentre(gridReference: GridReference): Point =
        when (TriHexagonalCellType.of(gridReference)) {
            TriHexagonalCellType.Hexagon -> incentreHexagon(gridReference)
            TriHexagonalCellType.TriangleDown -> incentreTriangleDown(gridReference)
            TriHexagonalCellType.TriangleUp -> incentreTriangleUp(gridReference)
        }

    private fun incentreHexagon(gridReference: GridReference): Point =
        Point(
            (if (gridReference.y % 2 == 0) 1.0 else 2.0) + (gridReference.x / 3) * 2.0,
            HALF_ROOT_THREE + 2 * HALF_ROOT_THREE * gridReference.y
        )

    private fun incentreTriangleUp(gridReference: GridReference): Point =
        Point(
            (if (gridReference.y % 2 == 0) 2.0 else 1.0) + (gridReference.x / 3) * 2.0,
            HALF_ROOT_THREE * (2 * gridReference.y + THIRD)
        )

    private fun incentreTriangleDown(gridReference: GridReference): Point =
        Point(
            (if (gridReference.y % 2 == 0) 2.0 else 1.0) + (gridReference.x / 3) * 2.0,
            HALF_ROOT_THREE * (2 * gridReference.y + 1.0 + 2 * THIRD)
        )
}