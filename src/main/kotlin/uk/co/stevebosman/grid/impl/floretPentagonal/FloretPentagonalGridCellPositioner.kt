package uk.co.stevebosman.grid.impl.floretPentagonal

import uk.co.stevebosman.grid.CellPositioner
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.maths.geometry.*
import uk.co.stevebosman.maths.trigonometry.degrees.solver.SideAngleSideSolver
import kotlin.math.sqrt

/**
 * Works out positions for a given square/octagonal grid reference.
 */
object FloretPentagonalGridCellPositioner : CellPositioner {
    private val polygon_cache = mutableMapOf<GridReference, Polygon>()
    private val ROOT_THREE = sqrt(3.0)
    private val HALF_ROOT_THREE = sqrt(3.0) / 2
    private val horizontalAlignment = SideAngleSideSolver.solve(4.5, 90.0, HALF_ROOT_THREE)
    private val baseHexagon = RegularConvexPolygonBuilder(6).size(ROOT_THREE).centre(Point(2.0, 2.0))
        .rotationDegrees(30 + horizontalAlignment.angleC).build()
    private val xVector = Point(horizontalAlignment.sideA, 0.0)
    private val distance = sqrt(4.5 * 4.5 + 3 / 4)
    private val yVector = Point(0.0, HALF_ROOT_THREE * distance)
    private val offyVector = Point(distance / 2, 0.0)

    override fun getPolygon(gridReference: GridReference): Polygon =
        polygon_cache.getOrPut(gridReference) {
            FloretPentagonBuilder().rotationDegrees(FloretPentagonalCellType.of(gridReference).angle + horizontalAlignment.angleC)
                .centre(incentre(gridReference))
                .build()
        }

    override fun getInscribedCircle(gridReference: GridReference): Circle {
        val polygon = getPolygon(gridReference)
        return Circle(polygon.centre, polygon.apothem)
    }

    private fun incentre(gridReference: GridReference): Point {
        var result = if (gridReference.y % 2 == 0) {
            if (gridReference.x % 3 == 0) {
                baseHexagon.vertices[3]
            } else if (gridReference.x % 3 == 1) {
                baseHexagon.vertices[4]
            } else {
                baseHexagon.vertices[5]
            }
        } else {
            if (gridReference.x % 3 == 0) {
                baseHexagon.vertices[2]
            } else if (gridReference.x % 3 == 1) {
                baseHexagon.vertices[1]
            } else {
                baseHexagon.vertices[0]
            }
        }.translate(xVector.rescale((gridReference.x / 3).toDouble()))
            .translate(yVector.rescale(gridReference.y / 2))
        if (gridReference.y % 4 > 1) result = result.translate(offyVector)
        return result
    }
}