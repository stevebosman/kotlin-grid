package uk.co.stevebosman.maths.trigonometry.degrees

import kotlin.math.PI
import kotlin.math.acos
import kotlin.math.sqrt

object ArcCos {
    private val cache = mutableMapOf(
        Pair(1.0, 0.0),
        Pair(sqrt(0.75), 30.0),
        Pair(sqrt(0.5), 45.0),
        Pair(0.5, 60.0),
        Pair(0.0, 90.0),
        Pair(-0.5, 120.0),
        Pair(-sqrt(0.5), 135.0),
        Pair(-sqrt(0.75), 150.0),
        Pair(-1.0, 180.0),
    )

    /**
     * Returns arc cosine value in degrees between 0° and 180°.
     */
    fun of(value: Double) = cache.getOrPut(value) {
        acos(value) * 180 / PI
    }
}