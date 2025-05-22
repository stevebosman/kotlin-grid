package uk.co.stevebosman.test

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertAll
import uk.co.stevebosman.geometry.Point
import uk.co.stevebosman.grid.Cell
import uk.co.stevebosman.grid.GridReference

const val DELTA = 1e-15

class GridAssertions {
    companion object {
        fun assertContains(
            cells: Map<GridReference, Cell>,
            expectedReference: GridReference,
            expectedNeighbours: List<GridReference>,
            expectedVertices: List<Point>?,
        ) {
            val referencedCell = cells[expectedReference]
            Assertions.assertNotNull(referencedCell, { -> "$expectedReference not found in ${cells.keys}" })
            Assertions.assertEquals(
                expectedReference,
                referencedCell?.gridReference,
                { -> "Unexpected grid reference" })
            assertAll(
                { ->
                    Assertions.assertEquals(
                        expectedNeighbours,
                        referencedCell?.neighbours,
                        { -> "Unexpected neighbours for $expectedReference" })
                },
                { ->
                    if (expectedVertices != null) {
                        Assertions.assertEquals(
                            expectedVertices,
                            referencedCell?.getVertices(),
                            { -> "Unexpected vertices for $expectedReference" })
                    }
                }
            )
        }
    }
}