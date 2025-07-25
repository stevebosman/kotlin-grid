package uk.co.stevebosman.maths.trigonometry.degrees

import kotlin.math.PI
import kotlin.math.sqrt
import kotlin.math.tan

object Tan {
    private val cache = mutableMapOf(
        Pair(-180.0, 0.0),
        Pair(-90.0, Double.NaN),
        Pair(-60.0, -sqrt(3.0)),
        Pair(-45.0, -1.0),
        Pair(-30.0, -sqrt(1.0 / 3.0)),
        Pair(0.0, 0.0),
        Pair(30.0, sqrt(1.0 / 3.0)),
        Pair(45.0, 1.0),
        Pair(60.0, sqrt(3.0)),
        Pair(90.0, Double.NaN),
        Pair(180.0, 0.0),
        Pair(270.0, Double.NaN),
    )

    /**
     * Return tan of degrees value.
     */
    fun of(value: Double) = cache.getOrPut(value) {
        cache.getOrPut(value.mod(360.0)) {
            tan(PI * value / 180)
        }
    }
}