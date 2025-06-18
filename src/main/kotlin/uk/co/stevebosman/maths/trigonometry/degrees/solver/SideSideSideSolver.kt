package uk.co.stevebosman.maths.trigonometry.degrees.solver

import uk.co.stevebosman.maths.geometry.Triangle
import uk.co.stevebosman.maths.trigonometry.degrees.ArcCos

object SideSideSideSolver {
    fun solve(sideA: Double, sideB: Double, sideC: Double): Triangle {
        if (sideA <= 0.0) throw IllegalArgumentException("Side A must be positive")
        if (sideB <= 0.0) throw IllegalArgumentException("Side B must be positive")
        if (sideC <= 0.0) throw IllegalArgumentException("Side C must be positive")

        val sides = listOf(sideA, sideB, sideC)
        val longestSide = sides.max()
        if (sides.sum() - longestSide <= longestSide) throw IllegalArgumentException("The longest side $longestSide must be smaller than the sum of the other 2 sides")

        val angleC = ArcCos.of((sideC * sideC - sideA * sideA - sideB * sideB) / (-2 * sideA * sideB))
        val angleB = ArcCos.of((sideB * sideB - sideA * sideA - sideC * sideC) / (-2 * sideA * sideC))
        val angleA = 180 - angleB - angleC
        return Triangle(sideA, sideB, sideC, angleA, angleB, angleC)
    }
}