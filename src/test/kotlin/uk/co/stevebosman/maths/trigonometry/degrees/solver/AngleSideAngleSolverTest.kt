package uk.co.stevebosman.maths.trigonometry.degrees.solver

import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AngleSideAngleSolverTest {
    @Test
    fun solveExample1() {
        val actual = AngleSideAngleSolver.solve(76.0, 9.0, 34.0)
        assertAll(
            { assertEquals(9.0, actual.sideA, "unexpected side A") },
            { assertEquals(9.293104301681586, actual.sideB, 1e-14, "unexpected side B") },
            { assertEquals(5.355725925598535, actual.sideC, 1e-14, "unexpected side C") },
            { assertEquals(70.0, actual.angleA, "unexpected angle A") },
            { assertEquals(76.0, actual.angleB, "unexpected angle B") },
            { assertEquals(34.0, actual.angleC, "unexpected angle C") },
        )
    }

    @Test
    fun solveExample2() {
        val actual = AngleSideAngleSolver.solve(87.0, 18.9, 42.0)
        assertAll(
            { assertEquals(18.9, actual.sideA, "unexpected side A") },
            { assertEquals(24.286426415286044, actual.sideB, 1e-14, "unexpected side B") },
            { assertEquals(16.273092941862554, actual.sideC, 1e-14, "unexpected side C") },
            { assertEquals(51.0, actual.angleA, "unexpected angle A") },
            { assertEquals(87.0, actual.angleB, "unexpected angle B") },
            { assertEquals(42.0, actual.angleC, "unexpected angle C") },
        )
    }
}