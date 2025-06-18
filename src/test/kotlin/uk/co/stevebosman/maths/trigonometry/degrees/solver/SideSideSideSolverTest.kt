package uk.co.stevebosman.maths.trigonometry.degrees.solver

import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.sqrt

class SideSideSideSolverTest {
    @Test
    fun solveFirstPythagorean() {
        val actual = SideSideSideSolver.solve(3.0, 4.0, 5.0)
        assertAll(
            { assertEquals(3.0, actual.sideA, "unexpected side A") },
            { assertEquals(4.0, actual.sideB, "unexpected side B") },
            { assertEquals(5.0, actual.sideC, "unexpected side C") },
            { assertEquals(36.86989764584402, actual.angleA, 1e-14, "unexpected angle A") },
            { assertEquals(53.13010235415598, actual.angleB, 1e-14, "unexpected angle B") },
            { assertEquals(90.0, actual.angleC, 1e-14, "unexpected angle C") },
        )
    }

    @Test
    fun solveEquilateral() {
        val actual = SideSideSideSolver.solve(4.0, 4.0, 4.0)
        assertAll(
            { assertEquals(4.0, actual.sideA, "unexpected side A") },
            { assertEquals(4.0, actual.sideB, "unexpected side B") },
            { assertEquals(4.0, actual.sideC, "unexpected side C") },
            { assertEquals(60.0, actual.angleA, 1e-14, "unexpected angle A") },
            { assertEquals(60.0, actual.angleB, 1e-14, "unexpected angle B") },
            { assertEquals(60.0, actual.angleC, 1e-14, "unexpected angle C") },
        )
    }


    @Test
    fun solve45() {
        val actual = SideSideSideSolver.solve(1.0, sqrt(2.0), 1.0)
        assertAll(
            { assertEquals(1.0, actual.sideA, "unexpected side A") },
            { assertEquals(sqrt(2.0), actual.sideB, "unexpected side B") },
            { assertEquals(1.0, actual.sideC, "unexpected side C") },
            { assertEquals(45.0, actual.angleA, 1e-13, "unexpected angle A") },
            { assertEquals(90.0, actual.angleB, 1e-13, "unexpected angle B") },
            { assertEquals(45.0, actual.angleC, 1e-13, "unexpected angle C") },
        )
    }
}