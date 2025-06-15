package uk.co.stevebosman.maths.trigonometry

import uk.co.stevebosman.maths.geometry.Triangle
import uk.co.stevebosman.maths.trigonometry.degrees.Sin

object AngleSideAngleSolver {
    fun solve(angleB: Double, sideA: Double, angleC: Double): Triangle {
        if (sideA <= 0.0) throw IllegalArgumentException("sideA must be positive")
        if (angleB <= 0.0 || angleB >= 180.0) throw IllegalArgumentException("angleB must be between 0 and 180 exclusive")
        if (angleC <= 0.0 || angleC >= 180.0) throw IllegalArgumentException("angleC must be between 0 and 180 exclusive")

        val angleA = 180 - angleB - angleC
        val factor = sideA / Sin.of(angleA)
        val sideB = Sin.of(angleB) * factor
        val sideC = Sin.of(angleC) * factor

        return Triangle(sideA, sideB, sideC, angleA, angleB, angleC)
    }
}