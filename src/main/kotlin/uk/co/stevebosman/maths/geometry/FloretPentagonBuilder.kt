package uk.co.stevebosman.maths.geometry

import uk.co.stevebosman.maths.trigonometry.degrees.Cos
import uk.co.stevebosman.maths.trigonometry.degrees.Sin
import uk.co.stevebosman.maths.trigonometry.degrees.Tan

class FloretPentagonBuilder {
    var centre = Point(0.0, 0.0)
    var rotationDegrees = 0.0
    var size = 1.0

    fun centre(centre: Point): FloretPentagonBuilder {
        this.centre = centre
        return this
    }

    /**
     * Clockwise rotation in degrees.
     * The default assumption is that the first point is at (0, -1).
     */
    fun rotationDegrees(rotationDegrees: Double): FloretPentagonBuilder {
        this.rotationDegrees = rotationDegrees
        return this
    }

    /**
     * Length of a side.
     */
    fun size(size: Double): FloretPentagonBuilder {
        this.size = size
        return this
    }

    fun build(): Polygon {
        val circumradius = size / (2 * Sin.of(180.0 / 6))
        val apothem = size / (2 * Tan.of(180.0 / 6))
        val vertices = buildVertices(circumradius, apothem)
        return Polygon(5, size, circumradius, apothem, centre, vertices)
    }

    private fun buildVertices(circumradius: Double, apothem: Double) = listOf(
        Point(Cos.of(rotationDegrees), Sin.of(rotationDegrees))
            .rescaleAndTranslate(circumradius, centre),
        Point(Cos.of(60 + rotationDegrees), Sin.of(60 + rotationDegrees))
            .rescaleAndTranslate(circumradius, centre),
        Point(Cos.of(120 + rotationDegrees), Sin.of(120 + rotationDegrees))
            .rescaleAndTranslate(circumradius, centre),
        Point(Cos.of(180 + rotationDegrees), Sin.of(180 + rotationDegrees))
            .rescaleAndTranslate(circumradius, centre),
        Point(Cos.of(270 + rotationDegrees), Sin.of(270 + rotationDegrees))
            .rescaleAndTranslate(2 * apothem, centre),
    )
}