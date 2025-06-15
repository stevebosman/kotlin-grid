package uk.co.stevebosman.maths.trigonometry

import uk.co.stevebosman.maths.geometry.Triangle
import uk.co.stevebosman.maths.trigonometry.degrees.Sin

object AngleAngleSideSolver {
    fun solve(angleA: Double, angleC: Double, sideC: Double): Triangle {
        if (sideC <= 0.0) throw IllegalArgumentException("sideC must be positive")
        if (angleA <= 0.0 || angleA >= 180.0) throw IllegalArgumentException("angleA must be between 0 and 180 exclusive")
        if (angleC <= 0.0 || angleC >= 180.0) throw IllegalArgumentException("angleC must be between 0 and 180 exclusive")

        val angleB = 180 - angleA - angleC
        val factor = sideC / Sin.of(angleC)
        val sideA = Sin.of(angleA) * factor
        val sideB = Sin.of(angleB) * factor

        return Triangle(sideA, sideB, sideC, angleA, angleB, angleC)
    }
}