package uk.co.stevebosman.grid.impl.regular.hex

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.test.DELTA
import uk.co.stevebosman.test.GridAssertions.assertContains
import kotlin.math.sqrt

class HexGridGeneratorTest {
    @Test
    fun testStandardGenerated2by2grid() {
        val grid = instance.generate(2, 2)
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(HALF_ROOT_THREE * 5, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(3.5, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..1), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((0..1), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(4, grid.cells.size)

            assertAll(
                {
                    assertContains(
                        grid.cells,
                        GridReference(0, 0),
                        listOf(GridReference(1, 0), GridReference(0, 1)),
                        null
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(0, 1),
                        listOf(GridReference(0, 0), GridReference(1, 0), GridReference(1, 1)),
                        null
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(1, 0),
                        listOf(GridReference(1, 1), GridReference(0, 1), GridReference(0, 0)),
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
        })
    }

    @Test
    fun testStandardGenerated3by3grid() {
        val grid = instance.generate(3, 3)
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(7 * HALF_ROOT_THREE, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(5.0, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..2), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((0..2), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(9, grid.cells.size)
            assertAll({
                assertContains(
                    grid.cells,
                    GridReference(0, 0),
                    listOf(GridReference(1, 0), GridReference(0, 1)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(0, 1),
                    listOf(
                        GridReference(0, 0),
                        GridReference(1, 0),
                        GridReference(1, 1),
                        GridReference(1, 2),
                        GridReference(0, 2)
                    ),
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
                    listOf(GridReference(2, 0), GridReference(1, 1), GridReference(0, 1), GridReference(0, 0)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 1),
                    listOf(
                        GridReference(1, 0),
                        GridReference(2, 0),
                        GridReference(2, 1),
                        GridReference(2, 2),
                        GridReference(1, 2),
                        GridReference(0, 1)
                    ),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 2),
                    listOf(GridReference(0, 1), GridReference(1, 1), GridReference(2, 2), GridReference(0, 2)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 0),
                    listOf(GridReference(2, 1), GridReference(1, 1), GridReference(1, 0)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 1),
                    listOf(GridReference(2, 0), GridReference(2, 2), GridReference(1, 1)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 2),
                    listOf(GridReference(1, 1), GridReference(2, 1), GridReference(1, 2)),
                    null
                )
            })
        })
    }

    @Test
    fun testStandardSkipLastGenerated3by3grid() {
        val grid = instance.generate(3, 3, HexGridOption.STANDARD_SKIP_LAST)
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(6 * HALF_ROOT_THREE, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(5.0, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..2), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((0..2), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(8, grid.cells.size)
            assertAll({
                assertContains(
                    grid.cells,
                    GridReference(0, 0),
                    listOf(GridReference(1, 0), GridReference(0, 1)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(0, 1),
                    listOf(
                        GridReference(0, 0),
                        GridReference(1, 0),
                        GridReference(1, 1),
                        GridReference(1, 2),
                        GridReference(0, 2)
                    ),
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
                    listOf(GridReference(2, 0), GridReference(1, 1), GridReference(0, 1), GridReference(0, 0)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 1),
                    listOf(
                        GridReference(1, 0),
                        GridReference(2, 0),
                        GridReference(2, 2),
                        GridReference(1, 2),
                        GridReference(0, 1)
                    ),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 2),
                    listOf(GridReference(0, 1), GridReference(1, 1), GridReference(2, 2), GridReference(0, 2)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 0),
                    listOf(GridReference(1, 1), GridReference(1, 0)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 2),
                    listOf(GridReference(1, 1), GridReference(1, 2)),
                    null
                )
            })
        })

    }

    @Test
    fun testOffsetSkipLastGenerated3by3grid() {
        val grid = instance.generate(3, 3, HexGridOption.OFFSET_SKIP_LAST)
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(1.5, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(6 * HALF_ROOT_THREE, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(5.0, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..2), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((1..3), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(7, grid.cells.size)
            assertAll({
                assertContains(
                    grid.cells,
                    GridReference(0, 1),
                    listOf(GridReference(1, 1), GridReference(1, 2), GridReference(0, 2)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 1),
                    listOf(GridReference(2, 2), GridReference(1, 2), GridReference(0, 1)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(0, 2),
                    listOf(GridReference(0, 1), GridReference(1, 2), GridReference(0, 3)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 2),
                    listOf(
                        GridReference(0, 1),
                        GridReference(1, 1),
                        GridReference(2, 2),
                        GridReference(1, 3),
                        GridReference(0, 3),
                        GridReference(0, 2)
                    ),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 2),
                    listOf(GridReference(1, 1), GridReference(1, 3), GridReference(1, 2)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(0, 3),
                    listOf(GridReference(0, 2), GridReference(1, 2), GridReference(1, 3)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 3),
                    listOf(GridReference(1, 2), GridReference(2, 2), GridReference(0, 3)),
                    null
                )
            })
        })

    }

    @Test
    fun testOffsetGenerated3by3grid() {
        val grid = instance.generate(3, 3, HexGridOption.OFFSET)
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(1.5, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(7 * HALF_ROOT_THREE, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(5.0, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..2), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((1..3), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(9, grid.cells.size)
            assertAll({
                assertContains(
                    grid.cells,
                    GridReference(0, 1),
                    listOf(GridReference(1, 1), GridReference(1, 2), GridReference(0, 2)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(0, 2),
                    listOf(GridReference(0, 1), GridReference(1, 2), GridReference(0, 3)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(0, 3),
                    listOf(GridReference(0, 2), GridReference(1, 2), GridReference(1, 3)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 1),
                    listOf(GridReference(2, 1), GridReference(2, 2), GridReference(1, 2), GridReference(0, 1)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 2),
                    listOf(
                        GridReference(0, 1),
                        GridReference(1, 1),
                        GridReference(2, 2),
                        GridReference(1, 3),
                        GridReference(0, 3),
                        GridReference(0, 2)
                    ),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 3),
                    listOf(GridReference(1, 2), GridReference(2, 2), GridReference(2, 3), GridReference(0, 3)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 1),
                    listOf(GridReference(2, 2), GridReference(1, 1)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 2),
                    listOf(
                        GridReference(1, 1),
                        GridReference(2, 1),
                        GridReference(2, 3),
                        GridReference(1, 3),
                        GridReference(1, 2)
                    ),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 3),
                    listOf(GridReference(2, 2), GridReference(1, 3)),
                    null
                )
            })
        })
    }

    @Test
    fun testTriangleGenerated3by3grid() {
        val grid = instance.generate(3, 3, HexGridOption.TRIANGLE)
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(6 * HALF_ROOT_THREE, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(5.0, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..2), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((0..2), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(6, grid.cells.size, "Unexpected grid: ${grid.cells.keys}")
            assertAll({
                assertContains(
                    grid.cells,
                    GridReference(0, 0),
                    listOf(GridReference(1, 0), GridReference(0, 1)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 0),
                    listOf(
                        GridReference(2, 0),
                        GridReference(1, 1),
                        GridReference(0, 1),
                        GridReference(0, 0)
                    ),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 0),
                    listOf(
                        GridReference(1, 1),
                        GridReference(1, 0)
                    ),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(0, 1),
                    listOf(
                        GridReference(0, 0),
                        GridReference(1, 0),
                        GridReference(1, 1),
                        GridReference(1, 2),
                    ),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 1),
                    listOf(
                        GridReference(1, 0),
                        GridReference(2, 0),
                        GridReference(1, 2),
                        GridReference(0, 1)
                    ),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 2),
                    listOf(
                        GridReference(0, 1),
                        GridReference(1, 1),
                    ),
                    null
                )
            })
        })
    }

    companion object {
        val instance = HexGridGenerator
        val HALF_ROOT_THREE = sqrt(3.0) / 2
    }
}