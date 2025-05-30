package uk.co.stevebosman.trigonometry.degrees

import kotlin.math.PI
import kotlin.math.sqrt
import kotlin.math.tan

object Tan {
    private val cache = mutableMapOf(
        Pair(-180.0, 0.0),
        Pair(-90.0, Double.NaN),
        Pair(0.0, 0.0),
        Pair(30.0, sqrt(1.0 / 3.0)),
        Pair(45.0, 1.0),
        Pair(60.0, sqrt(3.0)),
        Pair(90.0, Double.NaN),
        Pair(180.0, 0.0),
    )

    fun of(value: Double) = cache.getOrPut(value) {
        tan(PI * value / 180)
    }
}