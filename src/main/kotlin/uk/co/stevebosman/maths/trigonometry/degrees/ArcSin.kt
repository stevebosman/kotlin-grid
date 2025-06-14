package uk.co.stevebosman.maths.trigonometry.degrees

import kotlin.math.PI
import kotlin.math.asin
import kotlin.math.sin
import kotlin.math.sqrt

object ArcSin {
    private val cache = mutableMapOf(
        Pair(-1.0, -90.0),
        Pair(-sqrt(0.75), -60.0),
        Pair(-sqrt(0.5), -45.0),
        Pair(-0.5, -30.0),
        Pair(0.0, 0.0),
        Pair(0.5, 30.0),
        Pair(sqrt(0.5), 45.0),
        Pair(sqrt(0.75), 60.0),
        Pair(1.0, 90.0),
    )

    fun of(value: Double) = cache.getOrPut(value) {
        asin(value) * 180 / PI
    }
}