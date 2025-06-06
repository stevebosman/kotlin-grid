package uk.co.stevebosman.test

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.assertAll
import uk.co.stevebosman.geometry.Circle
import uk.co.stevebosman.geometry.Point
import uk.co.stevebosman.grid.Cell
import uk.co.stevebosman.grid.GridReference

const val DELTA = 1e-14

object GridAssertions {
    fun assertEqualPoints(expected: List<Point>, actual: List<Point>) {
        assertEquals(expected.size, actual.size)
        assertAll(expected.zip(actual).map { (e, a) ->
            { ->
                assertAll(
                    { assertEquals(e.x, a.x, DELTA) { -> "expected $e got $a" } },
                    { assertEquals(e.y, a.y, DELTA) { -> "expected $e got $a" } },
                )
            }
        })
    }

    fun assertEqualCircles(expected: Circle, actual: Circle) {
        assertAll(
            { assertEquals(expected.radius, actual.radius, DELTA) { -> "unexpected radius" } },
            {
                assertEquals(
                    expected.centre.x,
                    actual.centre.x,
                    DELTA
                ) { -> "unexpected centre x: in ${expected.centre}" }
            },
            {
                assertEquals(
                    expected.centre.y,
                    actual.centre.y,
                    DELTA
                ) { -> "unexpected centre y: in ${expected.centre}" }
            },
        )
    }

    fun assertContains(
        cells: Map<GridReference, Cell>,
        expectedReference: GridReference,
        expectedNeighbours: List<GridReference>? = null,
        expectedVertices: List<Point>? = null,
    ) {
        val referencedCell = cells[expectedReference]
        assertNotNull(referencedCell) { -> "$expectedReference not found in ${cells.keys}" }
        assertEquals(
            expectedReference,
            referencedCell?.gridReference
        ) { -> "Unexpected grid reference" }
        if (expectedNeighbours!=null) {
            assertEquals(
                expectedNeighbours.size,
                referencedCell?.neighbours?.size
            ) { -> "Unexpected neighbourCount for $expectedReference has\nlistOf(${referencedCell?.neighbours}),\n" }
            assertAll(
                { ->
                    assertEquals(
                        expectedNeighbours,
                        referencedCell?.neighbours
                    ) { -> "Unexpected neighbours for $expectedReference" }
                },
                { ->
                    if (expectedVertices != null) {
                        assertEqualPoints(
                            expectedVertices,
                            referencedCell!!.getPolygon().vertices
                        )
                    }
                }
            )
        }
    }

    fun assertContains(
        cells: Map<GridReference, Cell>,
        expectedReference: GridReference
    ) {
        val referencedCell = cells[expectedReference]
        assertNotNull(referencedCell) { -> "$expectedReference not found in ${cells.keys}" }
        assertEquals(
            expectedReference,
            referencedCell?.gridReference
        ) { -> "Unexpected grid reference" }
    }
}