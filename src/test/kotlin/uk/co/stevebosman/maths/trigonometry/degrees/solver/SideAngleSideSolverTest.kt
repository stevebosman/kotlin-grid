package uk.co.stevebosman.maths.trigonometry.degrees.solver

import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SideAngleSideSolverTest {
    @Test
    fun solveAcuteAngleA() {
        val actual = SideAngleSideSolver.solve(5.0, 49.0, 7.0)
        assertAll(
            { assertEquals(5.298666621959197, actual.sideA, 1e-14, "unexpected side A") },
            { assertEquals(5.0, actual.sideB, "unexpected side B") },
            { assertEquals(7.0, actual.sideC, "unexpected side C") },
            { assertEquals(49.0, actual.angleA, "unexpected angle A") },
            { assertEquals(45.41169386690557, actual.angleB, 1e-14, "unexpected angle B") },
            { assertEquals(85.58830613309442, actual.angleC, 1e-14, "unexpected angle C") },
        )
    }

    @Test
    fun solveObtuseAngleA() {
        val actual = SideAngleSideSolver.solve(2.6, 117.0, 6.9)
        assertAll(
            { assertEquals(8.405901446641813, actual.sideA, 1e-14, "unexpected side A") },
            { assertEquals(2.6, actual.sideB, "unexpected side B") },
            { assertEquals(6.9, actual.sideC, "unexpected side C") },
            { assertEquals(117.0, actual.angleA, "unexpected angle A") },
            { assertEquals(15.997422607629758, actual.angleB, 1e-14, "unexpected angle B") },
            { assertEquals(47.00257739237024, actual.angleC, 1e-14, "unexpected angle C") },
        )
    }

    @Test
    fun solveObtuseAngleC() {
        val actual = SideAngleSideSolver.solve(2.6, 47.00257739237024, 8.405901446641813)
        assertAll(
            { assertEquals(6.9, actual.sideA, 1e-14, "unexpected side C") },
            { assertEquals(2.6, actual.sideB, "unexpected side B") },
            { assertEquals(8.405901446641813, actual.sideC, "unexpected side A") },
            { assertEquals(47.00257739237024, actual.angleA, "unexpected angle A") },
            { assertEquals(15.997422607629758, actual.angleB, 1e-14, "unexpected angle B") },
            { assertEquals(117.0, actual.angleC, 1e-14, "unexpected angle C") },
        )
    }

    @Test
    fun solveObtuseAngleB() {
        val actual = SideAngleSideSolver.solve(8.405901446641813, 47.00257739237024, 2.6)
        assertAll(
            { assertEquals(6.9, actual.sideA, 1e-14, "unexpected side C") },
            { assertEquals(8.405901446641813, actual.sideB, "unexpected side A") },
            { assertEquals(2.6, actual.sideC, "unexpected side B") },
            { assertEquals(47.00257739237024, actual.angleA, "unexpected angle A") },
            { assertEquals(117.0, actual.angleB, 1e-14, "unexpected angle C") },
            { assertEquals(15.997422607629758, actual.angleC, 1e-14, "unexpected angle B") },
        )
    }

    @Test
    fun solvePythagorean() {
        val actual = SideAngleSideSolver.solve(3.0, 90.0, 4.0)
        assertAll(
            { assertEquals(5.0, actual.sideA, "unexpected side C") },
            { assertEquals(3.0, actual.sideB, "unexpected side B") },
            { assertEquals(4.0, actual.sideC, "unexpected side A") },
            { assertEquals(90.0, actual.angleA, "unexpected angle A") },
            { assertEquals(36.86989764584402, actual.angleB, 1e-14, "unexpected angle B") },
            { assertEquals(53.13010235415598, actual.angleC, 1e-14, "unexpected angle C") },
        )
    }

}