package uk.co.stevebosman.grid.impl.uniform.rhombiTriHexagonal

import uk.co.stevebosman.grid.CellPositioner
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.maths.geometry.Circle
import uk.co.stevebosman.maths.geometry.Point
import uk.co.stevebosman.maths.geometry.Polygon
import uk.co.stevebosman.maths.geometry.RegularConvexPolygonBuilder
import kotlin.math.sqrt

/**
 * Works out positions for a given square/octagonal grid reference.
 */
object RhombiTriHexagonalGridCellPositioner : CellPositioner {
    private val polygon_cache = mutableMapOf<GridReference, Polygon>()
    private val ROOT_THREE = sqrt(3.0)
    private val HALF_ROOT_THREE = ROOT_THREE / 2
    private val QUARTER_ROOT_THREE = ROOT_THREE / 4
    private val REPETITION_X = ROOT_THREE + 1
    private val REPETITION_Y = ROOT_THREE + 3

    override fun getPolygon(gridReference: GridReference): Polygon = polygon_cache.getOrPut(gridReference) {
        when (RhombiTriHexagonalCellType.of(gridReference)) {
            RhombiTriHexagonalCellType.Hexagon -> RegularConvexPolygonBuilder(6).rotationDegrees(-90.0)
                .centre(incentre(gridReference)).build()

            RhombiTriHexagonalCellType.TriangleDown -> RegularConvexPolygonBuilder(3).rotationDegrees(-150.0)
                .centre(incentre(gridReference)).build()

            RhombiTriHexagonalCellType.TriangleUp -> RegularConvexPolygonBuilder(3).rotationDegrees(-90.0)
                .centre(incentre(gridReference)).build()

            RhombiTriHexagonalCellType.Square0 -> RegularConvexPolygonBuilder(4).rotationDegrees(-135.0)
                .centre(incentre(gridReference)).build()

            RhombiTriHexagonalCellType.Square30 -> RegularConvexPolygonBuilder(4).rotationDegrees(-105.0)
                .centre(incentre(gridReference)).build()

            RhombiTriHexagonalCellType.Square60 -> RegularConvexPolygonBuilder(4).rotationDegrees(-75.0)
                .centre(incentre(gridReference)).build()
        }
    }

    override fun getInscribedCircle(gridReference: GridReference): Circle {
        val polygon = getPolygon(gridReference)
        return Circle(polygon.centre, polygon.apothem)
    }

    private fun incentre(gridReference: GridReference): Point = when (RhombiTriHexagonalCellType.of(gridReference)) {
        RhombiTriHexagonalCellType.Hexagon -> incentreHexagon(gridReference)
        RhombiTriHexagonalCellType.TriangleUp -> incentreTriangleUp(gridReference)
        RhombiTriHexagonalCellType.TriangleDown -> incentreTriangleDown(gridReference)
        RhombiTriHexagonalCellType.Square0 -> incentreSquare0(gridReference)
        RhombiTriHexagonalCellType.Square30 -> incentreSquare30(gridReference)
        RhombiTriHexagonalCellType.Square60 -> incentreSquare60(gridReference)
    }

    private fun incentreHexagon(gridReference: GridReference): Point = Point(
        (if (gridReference.y % 4 == 1) 1 + HALF_ROOT_THREE else 1.5 + ROOT_THREE) + (gridReference.x / 4) * REPETITION_X,
        (if (gridReference.y % 4 == 1) 1 + HALF_ROOT_THREE else 2.5 + ROOT_THREE) + (gridReference.y / 4) * REPETITION_Y
    )

    private fun incentreTriangleUp(gridReference: GridReference): Point = Point(
        (if (gridReference.y % 4 == 0) 0.5 else 1 + HALF_ROOT_THREE) + (gridReference.x / 4) * REPETITION_X,
        (if (gridReference.y % 4 == 0) 0.5 else 2 + HALF_ROOT_THREE) + HALF_ROOT_THREE * 2 / 3 + (gridReference.y / 4) * REPETITION_Y
    )

    private fun incentreTriangleDown(gridReference: GridReference): Point = Point(
        (if (gridReference.y % 4 == 2) 0.5 else 1 + HALF_ROOT_THREE) + (gridReference.x / 4) * REPETITION_X,
        (if (gridReference.y % 4 == 2) 1.5 + HALF_ROOT_THREE else 0.0) + HALF_ROOT_THREE / 3 + (gridReference.y / 4) * REPETITION_Y
    )

    private fun incentreSquare0(gridReference: GridReference): Point = Point(
        (if (gridReference.y % 4 == 1) 0.5 else 1 + HALF_ROOT_THREE) + (gridReference.x / 4) * REPETITION_X,
        (if (gridReference.y % 4 == 1) 1 + HALF_ROOT_THREE else 2.5 + ROOT_THREE) + (gridReference.y / 4) * REPETITION_Y
    )

    private fun incentreSquare60(gridReference: GridReference): Point = Point(
        (if (gridReference.y % 4 == 0) 0.75 + QUARTER_ROOT_THREE else 1.25 + 3 * QUARTER_ROOT_THREE) + (gridReference.x / 4) * REPETITION_X,
        (if (gridReference.y % 4 == 0) 0.0 else 1.5 + HALF_ROOT_THREE) + 0.25 + QUARTER_ROOT_THREE + (gridReference.y / 4) * REPETITION_Y
    )

    private fun incentreSquare30(gridReference: GridReference): Point {
        return Point(
            (if (gridReference.y % 4 == 0) 1.25 + QUARTER_ROOT_THREE * 3 else 0.75 + QUARTER_ROOT_THREE) + (gridReference.x / 4) * REPETITION_X,
            (if (gridReference.y % 4 == 0) 0.0 else 1.5 + HALF_ROOT_THREE) + 0.25 + QUARTER_ROOT_THREE + (gridReference.y / 4) * REPETITION_Y
        )
    }
}