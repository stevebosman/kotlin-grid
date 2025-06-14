package uk.co.stevebosman.maths.geometry

import uk.co.stevebosman.maths.trigonometry.degrees.Cos
import uk.co.stevebosman.maths.trigonometry.degrees.Sin
import uk.co.stevebosman.maths.trigonometry.degrees.Tan

class RegularConvexPolygonBuilder(val n: Int) {
    var centre = Point(0.0, 0.0)
    var rotationDegrees = 0.0
    var size = 1.0

    fun centre(centre: Point): RegularConvexPolygonBuilder {
        this.centre = centre
        return this
    }

    /**
     * Clockwise rotation in degrees.
     * The default assumption is that the first point is at (0, -1).
     */
    fun rotationDegrees(rotationDegrees: Double): RegularConvexPolygonBuilder {
        this.rotationDegrees = rotationDegrees
        return this
    }

    /**
     * Length of a side.
     */
    fun size(size: Double): RegularConvexPolygonBuilder {
        this.size = size
        return this
    }

    fun build(): Polygon {
        val circumradius = size / (2 * Sin.of(180.0 / n))
        val apothem = size / (2 * Tan.of(180.0 / n))
        val vertices = buildVertices(circumradius)
        return Polygon(n, size, circumradius, apothem, centre, vertices)
    }

    private fun buildVertices(circumradius: Double): List<Point> {
        val vertices = (0..n - 1).map { i ->
            val theta = (360.0 * i) / n + rotationDegrees
            Point(Cos.of(theta), Sin.of(theta)).rescaleAndTranslate(circumradius, centre)
        }.toList()
        return vertices
    }
}