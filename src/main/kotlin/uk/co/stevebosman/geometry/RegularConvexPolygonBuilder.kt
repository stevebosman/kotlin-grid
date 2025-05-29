package uk.co.stevebosman.geometry

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tan

class RegularConvexPolygonBuilder(val n: Int) {
    var centre = Point(0.0, 0.0)
    var rotation = 0.0
    var size = 1.0

    fun centre(centre: Point): RegularConvexPolygonBuilder {
        this.centre = centre
        return this
    }

    /**
     * Clockwise rotation in radians.
     * The default assumption is that the first point is at (0, -1).
     */
    fun rotation(rotation: Double): RegularConvexPolygonBuilder {
        this.rotation = rotation
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
        val circumradius = size / (2 * sin(PI / n))
        val apothem = size / (2 * tan(PI / n))
        val vertices = (0..n - 1).map { i ->
            val theta = (2 * PI * i) / n + rotation
            Point(cos(theta), sin(theta)).rescaleAndTranslate(circumradius, centre)
        }.toList()
        return Polygon(n, size, circumradius, apothem, centre, vertices)
    }
}