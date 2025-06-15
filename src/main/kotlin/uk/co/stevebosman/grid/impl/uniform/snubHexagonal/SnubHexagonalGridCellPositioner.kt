package uk.co.stevebosman.grid.impl.uniform.snubHexagonal

import uk.co.stevebosman.grid.CellPositioner
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.maths.geometry.Circle
import uk.co.stevebosman.maths.geometry.Point
import uk.co.stevebosman.maths.geometry.Polygon
import uk.co.stevebosman.maths.geometry.RegularConvexPolygonBuilder
import uk.co.stevebosman.maths.trigonometry.AngleAngleSideSolver
import uk.co.stevebosman.maths.trigonometry.AngleSideAngleSolver
import uk.co.stevebosman.maths.trigonometry.SideAngleSideSolver
import kotlin.math.sqrt

/**
 * Works out positions for a given square/octagonal grid reference.
 */
object SnubHexagonalGridCellPositioner : CellPositioner {
    private val polygon_cache = mutableMapOf<GridReference, Polygon>()
    private val ROOT_THREE = sqrt(3.0)
    private val VERTICAL_REPEAT = SideAngleSideSolver.solve(1.0, 120.0, 4.0)
    private val HORIZONTAL_REPEAT = SideAngleSideSolver.solve(1.0, 120.0, 2.0)
    private val ORIGIN_TRIANGLE = AngleSideAngleSolver.solve(HORIZONTAL_REPEAT.angleC, 2.0, VERTICAL_REPEAT.angleC)
    private val FIRST_HEX_ROW_0_TRIANGLE = AngleAngleSideSolver.solve(HORIZONTAL_REPEAT.angleB + 60.0, 90.0, 2.0)
    private val FIRST_HEX_ROW_0_LOCATION =
        Point(ORIGIN_TRIANGLE.sideC + FIRST_HEX_ROW_0_TRIANGLE.sideB, FIRST_HEX_ROW_0_TRIANGLE.sideA)

    // triangle under (3,0)
    private val NIBLET_TRIANGLE_UNDER_3_0 = AngleSideAngleSolver.solve(HORIZONTAL_REPEAT.angleB, 1.0, 60.0)
    private val RIGHT_NIBLET_TRIANGLE_UNDER_3_0 =
        AngleAngleSideSolver.solve(HORIZONTAL_REPEAT.angleB, 90.0, 1.0)
    private val FIRST_HEX_ROW_2_TRIANGLE =
        AngleAngleSideSolver.solve(180 - NIBLET_TRIANGLE_UNDER_3_0.angleA, 90.0, 4.0 + NIBLET_TRIANGLE_UNDER_3_0.sideB)
    private val FIRST_HEX_ROW_2_LOCATION = Point(
        ORIGIN_TRIANGLE.sideC + NIBLET_TRIANGLE_UNDER_3_0.sideC + FIRST_HEX_ROW_2_TRIANGLE.sideB,
        FIRST_HEX_ROW_2_TRIANGLE.sideA
    )

    private val NIBLET_TRIANGLE_UNDER_4_0 =
        AngleAngleSideSolver.solve(30 + HORIZONTAL_REPEAT.angleB, 90.0, ROOT_THREE * 2.0 / 3.0)

    private val ROW_0_TO_2_DELTA = FIRST_HEX_ROW_2_LOCATION.minus(FIRST_HEX_ROW_0_LOCATION)

    private val ROTATE = FIRST_HEX_ROW_0_TRIANGLE.angleB

    private val ROW_0_POSITIONS = listOf(
        Point(
            ORIGIN_TRIANGLE.sideC * 0.25 + ORIGIN_TRIANGLE.sideB * ROOT_THREE / 12.0,
            ORIGIN_TRIANGLE.sideB * 0.75 + ORIGIN_TRIANGLE.sideC * ROOT_THREE / 12.0
        ),
        Point(
            ORIGIN_TRIANGLE.sideC / 2 + ORIGIN_TRIANGLE.sideB * ROOT_THREE / 6.0,
            ORIGIN_TRIANGLE.sideB / 2 + ORIGIN_TRIANGLE.sideC * ROOT_THREE / 6.0
        ),
        Point(
            ORIGIN_TRIANGLE.sideC * 0.75 + ORIGIN_TRIANGLE.sideB * ROOT_THREE / 12.0,
            ORIGIN_TRIANGLE.sideB * 0.25 + ORIGIN_TRIANGLE.sideC * ROOT_THREE / 12.0
        ),
        Point(
            ORIGIN_TRIANGLE.sideC + NIBLET_TRIANGLE_UNDER_4_0.sideB / 2,
            NIBLET_TRIANGLE_UNDER_4_0.sideA / 2
        ),
        Point(
            ORIGIN_TRIANGLE.sideC + NIBLET_TRIANGLE_UNDER_4_0.sideB,
            NIBLET_TRIANGLE_UNDER_4_0.sideA
        ),
        Point(
            ORIGIN_TRIANGLE.sideC + RIGHT_NIBLET_TRIANGLE_UNDER_3_0.sideB + NIBLET_TRIANGLE_UNDER_4_0.sideB / 2,
            RIGHT_NIBLET_TRIANGLE_UNDER_3_0.sideA + NIBLET_TRIANGLE_UNDER_4_0.sideA / 2
        ),
    )
    private val ROW_1_POSITIONS = listOf(
        Point(
            NIBLET_TRIANGLE_UNDER_4_0.sideB / 2,
            ORIGIN_TRIANGLE.sideB + NIBLET_TRIANGLE_UNDER_4_0.sideA / 2
        ),
        Point(
            NIBLET_TRIANGLE_UNDER_4_0.sideB,
            ORIGIN_TRIANGLE.sideB + NIBLET_TRIANGLE_UNDER_4_0.sideA
        ),
        Point(
            ORIGIN_TRIANGLE.sideC + NIBLET_TRIANGLE_UNDER_3_0.sideC + FIRST_HEX_ROW_2_TRIANGLE.sideB,
            FIRST_HEX_ROW_2_TRIANGLE.sideA
        ),
        Point(-1.0, -1.0),
        Point(-1.0, -1.0),
        Point(-1.0, -1.0),
    )
    private val ROW_2_POSITIONS = listOf(
        ROW_0_POSITIONS[3].translate(ROW_0_TO_2_DELTA).translate(Point(-HORIZONTAL_REPEAT.sideA, 0.0)),
        ROW_0_POSITIONS[4].translate(ROW_0_TO_2_DELTA).translate(Point(-HORIZONTAL_REPEAT.sideA, 0.0)),
        ROW_0_POSITIONS[5].translate(ROW_0_TO_2_DELTA).translate(Point(-HORIZONTAL_REPEAT.sideA, 0.0)),
        ROW_0_POSITIONS[0].translate(ROW_0_TO_2_DELTA),
        ROW_0_POSITIONS[1].translate(ROW_0_TO_2_DELTA),
        ROW_0_POSITIONS[2].translate(ROW_0_TO_2_DELTA),
    )
    private val ROW_3_POSITIONS = listOf(
        Point(-1.0, -1.0),
        Point(-1.0, -1.0),
        Point(-1.0, -1.0),
        ROW_1_POSITIONS[0].translate(ROW_0_TO_2_DELTA),
        ROW_1_POSITIONS[1].translate(ROW_0_TO_2_DELTA),
        ROW_1_POSITIONS[2].translate(ROW_0_TO_2_DELTA),
    )


    override fun getPolygon(gridReference: GridReference): Polygon = polygon_cache.getOrPut(gridReference) {
        when (SnubHexagonalCellType.of(gridReference)) {
            SnubHexagonalCellType.Hexagon -> RegularConvexPolygonBuilder(6).rotationDegrees(-90.0 - ROTATE)
                .centre(incentre(gridReference)).build()

            SnubHexagonalCellType.TriangleRight -> RegularConvexPolygonBuilder(3).rotationDegrees(-120.0 - ROTATE)
                .centre(incentre(gridReference)).build()

            SnubHexagonalCellType.TriangleLeft -> RegularConvexPolygonBuilder(3).rotationDegrees(60 - ROTATE)
                .centre(incentre(gridReference)).build()
        }
    }

    override fun getInscribedCircle(gridReference: GridReference): Circle {
        val polygon = getPolygon(gridReference)
        return Circle(polygon.centre, polygon.apothem)
    }

    private fun incentre(gridReference: GridReference): Point = when (SnubHexagonalCellType.of(gridReference)) {
        SnubHexagonalCellType.Hexagon -> incentreHexagon(gridReference)
        SnubHexagonalCellType.TriangleRight, SnubHexagonalCellType.TriangleLeft -> incentreTriangle(gridReference)
    }

    private fun incentreHexagon(gridReference: GridReference): Point = Point(
        (if (gridReference.y % 4 == 1) FIRST_HEX_ROW_0_LOCATION.x else FIRST_HEX_ROW_2_LOCATION.x) + (gridReference.x / 6) * HORIZONTAL_REPEAT.sideA,
        (if (gridReference.y % 4 == 1) FIRST_HEX_ROW_0_LOCATION.y else FIRST_HEX_ROW_2_LOCATION.y) + (gridReference.y / 4) * VERTICAL_REPEAT.sideA
    )

    private fun incentreTriangle(gridReference: GridReference): Point =
        when (gridReference.y % 4) {
            0 -> Point(
                ROW_0_POSITIONS[gridReference.x % 6].x + (gridReference.x / 6) * HORIZONTAL_REPEAT.sideA,
                ROW_0_POSITIONS[gridReference.x % 6].y + (gridReference.y / 4) * VERTICAL_REPEAT.sideA
            )

            1 -> Point(
                ROW_1_POSITIONS[gridReference.x % 6].x + (gridReference.x / 6) * HORIZONTAL_REPEAT.sideA,
                ROW_1_POSITIONS[gridReference.x % 6].y + (gridReference.y / 4) * VERTICAL_REPEAT.sideA
            )

            2 -> Point(
                ROW_2_POSITIONS[gridReference.x % 6].x + (gridReference.x / 6) * HORIZONTAL_REPEAT.sideA,
                ROW_2_POSITIONS[gridReference.x % 6].y + (gridReference.y / 4) * VERTICAL_REPEAT.sideA
            )

            else -> Point(
                ROW_3_POSITIONS[gridReference.x % 6].x + (gridReference.x / 6) * HORIZONTAL_REPEAT.sideA,
                ROW_3_POSITIONS[gridReference.x % 6].y + (gridReference.y / 4) * VERTICAL_REPEAT.sideA
            )
        }
}
