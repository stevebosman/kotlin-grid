package uk.co.stevebosman.maths.trigonometry.degrees

import kotlin.math.PI
import kotlin.math.atan
import kotlin.math.sqrt

object ArcTan {
    private val cache = mutableMapOf(
        Pair(Double.NaN, Double.NaN),
        Pair(-sqrt(3.0), -60.0),
        Pair(-1.0, -45.0),
        Pair(-sqrt(1.0 / 3.0), -30.0),
        Pair(0.0, 0.0),
        Pair(sqrt(1.0 / 3.0), 30.0),
        Pair(1.0, 45.0),
        Pair(sqrt(3.0), 60.0),
    )

    /**
     * Returns arc tan value in degrees between -90° and 90° exclusive.
     * Note: of(Double.NaN) is Double.NaN.
     */
    fun of(value: Double) = cache.getOrPut(value) {
        atan(value) * 180 / PI
    }
}