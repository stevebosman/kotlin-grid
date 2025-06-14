package uk.co.stevebosman.grid.impl.uniform.elongatedTriangular

import uk.co.stevebosman.maths.geometry.Circle
import uk.co.stevebosman.maths.geometry.Point
import uk.co.stevebosman.maths.geometry.Polygon
import uk.co.stevebosman.maths.geometry.RegularConvexPolygonBuilder
import uk.co.stevebosman.grid.CellPositioner
import uk.co.stevebosman.grid.GridReference
import kotlin.math.sqrt

/**
 * Works out positions for a given triangular grid reference.
 */
object ElongatedTriangularGridCellPositioner : CellPositioner {
    private val polygon_cache = mutableMapOf<GridReference, Polygon>()
    private val HALF_ROOT_THREE = sqrt(3.0) / 2
    private const val THIRD = 1 / 3.0

    override fun getPolygon(gridReference: GridReference): Polygon =
        polygon_cache.getOrPut(gridReference) {
            when (ElongatedTriangularCellType.of(gridReference)) {
                ElongatedTriangularCellType.Square ->
                    RegularConvexPolygonBuilder(4).rotationDegrees(45.0)

                ElongatedTriangularCellType.TriangleUp ->
                    RegularConvexPolygonBuilder(3).rotationDegrees(-90.0)

                ElongatedTriangularCellType.TriangleDown ->
                    RegularConvexPolygonBuilder(3).rotationDegrees(-150.0)
            }.centre(incentre(gridReference)).build()
        }

    private fun incentre(gridReference: GridReference): Point =
        when (ElongatedTriangularCellType.of(gridReference)) {
            ElongatedTriangularCellType.Square -> {
                Point(
                    (gridReference.x + if (gridReference.y%4==1) 1.0 else 2.0) / 2,
                    dy(gridReference) + HALF_ROOT_THREE / 2
                )
            }

            ElongatedTriangularCellType.TriangleDown ->
                Point(
                    (gridReference.x + 1.0) / 2,
                    dy(gridReference) + HALF_ROOT_THREE * THIRD
                )

            ElongatedTriangularCellType.TriangleUp ->
                Point(
                    (gridReference.x + 1.0) / 2,
                    dy(gridReference) + HALF_ROOT_THREE * THIRD * 2
                )
        }

    private fun dy(gridReference: GridReference) =
        (1 + HALF_ROOT_THREE) * gridReference.y/2

    override fun getInscribedCircle(gridReference: GridReference): Circle {
        val polygon = getPolygon(gridReference)
        return Circle(polygon.centre, polygon.apothem)
    }
}