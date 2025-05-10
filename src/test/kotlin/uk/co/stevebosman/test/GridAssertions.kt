package uk.co.stevebosman.test

import org.junit.jupiter.api.Assertions
import uk.co.stevebosman.grid.Cell
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.grid.Point

class GridAssertions {
    companion object {
        fun assertContains(
            cells: Map<GridReference, Cell>,
            expectedReference: GridReference,
            expectedNeighbours: List<GridReference>,
            expectedVertices: List<Point>?,
        ) {
            val referencedCell = cells[expectedReference]
            Assertions.assertNotNull(referencedCell)
            Assertions.assertEquals(
                expectedReference,
                referencedCell?.gridReference,
                { -> "Unexpected grid reference" })
            Assertions.assertEquals(
                expectedNeighbours,
                referencedCell?.neighbours,
                { -> "Unexpected neighbours for $expectedReference" })
            if (expectedVertices != null) {
                Assertions.assertEquals(
                    expectedVertices,
                    referencedCell?.getVertices(),
                    { -> "Unexpected vertices for $expectedReference" })
            }
        }
    }
}