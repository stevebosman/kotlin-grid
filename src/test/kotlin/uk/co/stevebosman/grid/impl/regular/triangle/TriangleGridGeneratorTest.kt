package uk.co.stevebosman.grid.impl.regular.triangle

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.test.GridAssertions.Companion.assertContains

class TriangleGridGeneratorTest {
    @Test
    fun testGenerated2by2grid() {
        val grid = instance.generate(2, 2)
        Assertions.assertEquals(4, grid.cells.size)

        assertAll(
            {
                assertContains(
                    grid.cells,
                    GridReference(0, 0),
                    listOf(GridReference(1, 0)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(0, 1),
                    listOf(GridReference(1, 1)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 0),
                    listOf(GridReference(0, 0), GridReference(1, 1)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 1),
                    listOf(GridReference(1, 0), GridReference(0, 1)),
                    null
                )
            })
    }

    @Test
    fun testGenerated3by3grid() {
        val grid = instance.generate(3, 3)
        Assertions.assertEquals(9, grid.cells.size)
        assertAll({
            assertContains(
                grid.cells,
                GridReference(0, 0),
                listOf(GridReference(1, 0)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(0, 1),
                listOf(GridReference(1, 1), GridReference(0, 2)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(0, 2),
                listOf(GridReference(0, 1), GridReference(1, 2)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(1, 0),
                listOf(GridReference(0, 0), GridReference(2, 0), GridReference(1, 1)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(1, 1),
                listOf(GridReference(1, 0), GridReference(0, 1), GridReference(2, 1)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(1, 2),
                listOf(GridReference(0, 2), GridReference(2, 2)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(2, 0),
                listOf(GridReference(1, 0)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(2, 1),
                listOf(GridReference(1, 1), GridReference(2, 2)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(2, 2),
                listOf(GridReference(2, 1), GridReference(1, 2)),
                null
            )
        })
    }

    companion object {
        val instance = TriangleGridGenerator()
    }
}