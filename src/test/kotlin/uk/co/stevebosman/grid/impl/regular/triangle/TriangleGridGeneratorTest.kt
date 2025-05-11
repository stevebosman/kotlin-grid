package uk.co.stevebosman.grid.impl.regular.triangle

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.test.GridAssertions.Companion.assertContains

class TriangleGridGeneratorTest {
    @Test
    fun testStandardGenerated2by2grid() {
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
    fun testStandardGenerated3by3grid() {
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

    @Test
    fun testOffsetGenerated2by2grid() {
        val grid = instance.generate(2, 2, TriangleGridOption.OFFSET)
        Assertions.assertEquals(4, grid.cells.size)

        assertAll(
            {
                assertContains(
                    grid.cells,
                    GridReference(1, 0),
                    listOf(GridReference(2, 0), GridReference(1, 1)),
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
                    GridReference(1, 1),
                    listOf(GridReference(1, 0), GridReference(2, 1)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 1),
                    listOf(GridReference(1, 1)),
                    null
                )
            })
    }

    @Test
    fun testOffsetGenerated3by3grid() {
        val grid = instance.generate(3, 3, TriangleGridOption.OFFSET)
        Assertions.assertEquals(9, grid.cells.size)
        assertAll({
            assertContains(
                grid.cells,
                GridReference(1, 0),
                listOf(GridReference(2, 0), GridReference(1, 1)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(2, 0),
                listOf(GridReference(1, 0), GridReference(3, 0)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(3, 0),
                listOf(GridReference(2, 0), GridReference(3, 1)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(1, 1),
                listOf(GridReference(1, 0), GridReference(2, 1)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(2, 1),
                listOf(GridReference(1, 1), GridReference(3, 1), GridReference(2, 2)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(3, 1),
                listOf(GridReference(3, 0), GridReference(2, 1)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(1, 2),
                listOf(GridReference(2, 2)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(2, 2),
                listOf(GridReference(2, 1), GridReference(1, 2), GridReference(3, 2)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(3, 2),
                listOf(GridReference(2, 2)),
                null
            )
        })
    }

    @Test
    fun testTriangleGenerated2by2grid() {
        val grid = instance.generate(2, 2, TriangleGridOption.TRIANGLE)
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
                    GridReference(1, 0),
                    listOf(GridReference(0, 0), GridReference(2, 0), GridReference(1, 1)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 1),
                    listOf(GridReference(1, 0)),
                    null
                )
            })
    }

    @Test
    fun testTriangleGenerated3by3grid() {
        val grid = instance.generate(3, 3, TriangleGridOption.TRIANGLE)
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
                GridReference(1, 0),
                listOf(GridReference(0, 0), GridReference(2, 0), GridReference(1, 1)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(2, 0),
                listOf(GridReference(1, 0), GridReference(3, 0)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(3, 0),
                listOf(GridReference(2, 0), GridReference(4, 0), GridReference(3, 1)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(4, 0),
                listOf(GridReference(3, 0)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(1, 1),
                listOf(GridReference(1, 0), GridReference(2, 1)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(2, 1),
                listOf(GridReference(1, 1), GridReference(3, 1), GridReference(2, 2)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(3, 1),
                listOf(GridReference(3, 0), GridReference(2, 1)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(2, 2),
                listOf(GridReference(2, 1)),
                null
            )
        })
    }

    @Test
    fun testSpikyGenerated2by2grid() {
        val grid = instance.generate(2, 2, TriangleGridOption.SPIKY)
        Assertions.assertEquals(2, grid.cells.size)

        assertAll(
            {
                assertContains(
                    grid.cells,
                    GridReference(1, 0),
                    listOf(GridReference(1, 1)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 1),
                    listOf(GridReference(1, 0)),
                    null
                )
            })
    }

    @Test
    fun testSpikyGenerated3by3grid() {
        val grid = instance.generate(3, 3, TriangleGridOption.SPIKY)
        Assertions.assertEquals(6, grid.cells.size)
        assertAll({
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
                listOf(GridReference(0, 1)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(1, 0),
                listOf(GridReference(1, 1)),
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
                GridReference(2, 1),
                listOf(GridReference(1, 1), GridReference(2, 2)),
                null
            )
        }, {
            assertContains(
                grid.cells,
                GridReference(2, 2),
                listOf(GridReference(2, 1)),
                null
            )
        })
    }

    companion object {
        val instance = TriangleGridGenerator()
    }
}