package uk.co.stevebosman.maths.trigonometry.degrees.solver

import uk.co.stevebosman.maths.geometry.Triangle
import uk.co.stevebosman.maths.trigonometry.degrees.ArcSin
import uk.co.stevebosman.maths.trigonometry.degrees.Cos
import uk.co.stevebosman.maths.trigonometry.degrees.Sin
import kotlin.math.sqrt

object SideAngleSideSolver {
    fun solve(sideB: Double, angleA: Double, sideC: Double): Triangle {
        if (sideB <= 0.0) throw IllegalArgumentException("sideB must be positive")
        if (sideC <= 0.0) throw IllegalArgumentException("sideC must be positive")
        if (angleA <= 0.0 || angleA >= 180.0) throw IllegalArgumentException("angleA must be between 0 and 180 exclusive")

        val sideA = sqrt(sideB * sideB + sideC * sideC - 2 * sideB * sideC * Cos.of(angleA))
        val (angleB, angleC) = if (angleA >= 90.0) {
            // Use the law of sines to find an angle
            val angleB = ArcSin.of((sideB * Sin.of(angleA)) / sideA)
            Pair(angleB, 180.0 - angleA - angleB)
        } else {
            // Use the law of sines to find the smallest angle
            val angleB = ArcSin.of((sideB * Sin.of(angleA)) / sideA)
            val angleC = ArcSin.of((sideC * Sin.of(angleA)) / sideA)
            if (angleB <= angleC) {
                // angle C is obtuse
                Pair(angleB, 180.0 - angleA - angleB)
            } else {
                // angle B is obtuse
                Pair(180.0 - angleA - angleC, angleC)
            }
        }
        return Triangle(sideA, sideB, sideC, angleA, angleB, angleC)
    }
}