package uk.co.stevebosman.grid.impl.uniform.snubHexagonal

import uk.co.stevebosman.maths.geometry.Circle
import uk.co.stevebosman.maths.geometry.Point
import uk.co.stevebosman.maths.geometry.Polygon
import uk.co.stevebosman.maths.geometry.RegularConvexPolygonBuilder
import uk.co.stevebosman.grid.CellPositioner
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.maths.trigonometry.AngleSideAngleSolver
import uk.co.stevebosman.maths.trigonometry.SideAngleSideSolver
import uk.co.stevebosman.maths.trigonometry.degrees.Cos
import uk.co.stevebosman.maths.trigonometry.degrees.Tan
import kotlin.math.*

/**
 * Works out positions for a given square/octagonal grid reference.
 */
object SnubHexagonalGridCellPositioner : CellPositioner {
    private val polygon_cache = mutableMapOf<GridReference, Polygon>()
    private val ROOT_THREE = sqrt(3.0)
    private val HALF_ROOT_THREE = ROOT_THREE / 2
    val REPETITION_X = ROOT_THREE + 3
    val DELTA_Y = sqrt(3.0 / 7.0)
    val OPPOSITE = asin(DELTA_Y) * 180 / PI
    val ROTATE = asin(DELTA_Y / 2) * 180 / PI
    val DELTA_X = Cos.of(OPPOSITE)
//    private val SLOPE_Y = sin(OPPOSITE)
//    private val SLOPE_X = cos(OPPOSITE)
    val TRIANGLEP= ROOT_THREE*Tan.of(OPPOSITE)/6
    val VERTICAL_REPEAT = SideAngleSideSolver.solve(1.0, 120.0, 4.0)
    val HORIZONTAL_REPEAT = SideAngleSideSolver.solve(1.0, 120.0, 2.0)
    val ORIGIN_TRIANGLE = AngleSideAngleSolver.solve(HORIZONTAL_REPEAT.angleC, 2.0, VERTICAL_REPEAT.angleC)

    override fun getPolygon(gridReference: GridReference): Polygon = polygon_cache.getOrPut(gridReference) {
        when (SnubHexagonalCellType.of(gridReference)) {
            SnubHexagonalCellType.Hexagon -> RegularConvexPolygonBuilder(6).rotationDegrees(-90.0 - ROTATE)
                .centre(incentre(gridReference)).build()

            SnubHexagonalCellType.TriangleRight -> RegularConvexPolygonBuilder(3).rotationDegrees(-120.0 - ROTATE)
                .centre(incentre(gridReference)).build()

            SnubHexagonalCellType.TriangleLeft -> RegularConvexPolygonBuilder(3).rotationDegrees(-60.0 - ROTATE)
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
        (if (gridReference.y % 4 == 1) 1 + HALF_ROOT_THREE else 2.5 + ROOT_THREE) + (gridReference.y / 4) * DELTA_Y
    )

    private fun incentreTriangleRight(gridReference: GridReference): Point =
        Point(-1.0,0.0)


    private fun incentreTriangleLeft(gridReference: GridReference): Point =
        when (gridReference.y % 4) {
            0 -> Point(
                if (gridReference.x % 6 == 4) 2.0 else (gridReference.x+1)/2 * DELTA_X,
                when (gridReference.x % 6) {
                    0 -> 3*DELTA_Y/2
                    2 -> DELTA_Y/2
                    else -> DELTA_Y / 2
                }
            )

            1 -> Point(-1.0,-1.0)

            2 -> Point(-1.0,-1.0)
            else -> Point(-1.0,-1.0)
        }

}