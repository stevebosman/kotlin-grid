package uk.co.stevebosman.maths.trigonometry.degrees

import kotlin.math.PI
import kotlin.math.sin
import kotlin.math.sqrt

object Sin {
    private val cache = mutableMapOf(
        Pair(-180.0, 0.0),
        Pair(-150.0, -0.5),
        Pair(-135.0, -sqrt(0.5)),
        Pair(-120.0, -sqrt(0.75)),
        Pair(-90.0, -1.0),
        Pair(-60.0, -sqrt(0.75)),
        Pair(-45.0, -sqrt(0.5)),
        Pair(-30.0, -0.5),
        Pair(0.0, 0.0),
        Pair(30.0, 0.5),
        Pair(45.0, sqrt(0.5)),
        Pair(60.0, sqrt(0.75)),
        Pair(90.0, 1.0),
        Pair(120.0, sqrt(0.75)),
        Pair(135.0, sqrt(0.5)),
        Pair(150.0, 0.5),
        Pair(180.0, 0.0),
        Pair(210.0, -0.5),
        Pair(225.0, -sqrt(0.5)),
        Pair(240.0, -sqrt(0.75)),
        Pair(270.0, -1.0),
        Pair(300.0, -sqrt(0.75)),
        Pair(315.0, -sqrt(0.5)),
        Pair(330.0, -0.5),
    )

    /**
     * Return sine of degrees value.
     */
    fun of(value: Double) = cache.getOrPut(value) {
        cache.getOrPut(value.mod(360.0)) {
            sin(PI * value / 180)
        }
    }
}