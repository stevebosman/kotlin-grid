package uk.co.stevebosman.grid.impl.uniform.squareOctagon2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.test.DELTA
import uk.co.stevebosman.test.GridAssertions.assertContains
import kotlin.math.sqrt

class SquareOctagon2GridGeneratorTest {
    @Test
    fun testStandardGenerated2by2grid() {
        val grid = instance.generate(2, 2)
        println("$grid")
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(2 + 3 * ROOT_HALF, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(2 + 3 * ROOT_HALF, grid.boundingBox.height, DELTA) { -> "unexpected height" }
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
                        listOf(GridReference(0, 0), GridReference(0, 1), GridReference(1, 1)),
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
        println("$grid")
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(3 + 4 * ROOT_HALF, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(3 + 4 * ROOT_HALF, grid.boundingBox.height, DELTA) { -> "unexpected height" }
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
                        GridReference(0, 2),
                        GridReference(1, 2)
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
                    listOf(
                        GridReference(0, 0),
                        GridReference(2, 0),
                        GridReference(0, 1),
                        GridReference(1, 1),
                        GridReference(2, 1)
                    ),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 1),
                    listOf(GridReference(1, 0), GridReference(0, 1), GridReference(2, 1), GridReference(1, 2)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 2),
                    listOf(
                        GridReference(0, 1),
                        GridReference(1, 1),
                        GridReference(2, 1),
                        GridReference(0, 2),
                        GridReference(2, 2)
                    ),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 0),
                    listOf(GridReference(1, 0), GridReference(2, 1)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 1),
                    listOf(
                        GridReference(1, 0),
                        GridReference(2, 0),
                        GridReference(1, 1),
                        GridReference(1, 2),
                        GridReference(2, 2)
                    ),
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
        })
    }

    @Test
    fun testStandardGenerated4by4grid() {
        val grid = instance.generate(4, 4)
        println("$grid")
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(4 + 5 * ROOT_HALF, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(4 + 5 * ROOT_HALF, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..3), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((0..3), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(16, grid.cells.size)
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
                        GridReference(0, 2),
                        GridReference(1, 2)
                    ),
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
                    GridReference(1, 0),
                    listOf(
                        GridReference(0, 0),
                        GridReference(2, 0),
                        GridReference(0, 1),
                        GridReference(1, 1),
                        GridReference(2, 1)
                    ),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 1),
                    listOf(GridReference(1, 0), GridReference(0, 1), GridReference(2, 1), GridReference(1, 2)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 2),
                    listOf(
                        GridReference(0, 1),
                        GridReference(1, 1),
                        GridReference(2, 1),
                        GridReference(0, 2),
                        GridReference(2, 2),
                        GridReference(0, 3),
                        GridReference(1, 3),
                        GridReference(2, 3)
                    ),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 3),
                    listOf(GridReference(1, 2), GridReference(0, 3), GridReference(2, 3)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 0),
                    listOf(GridReference(1, 0), GridReference(3, 0), GridReference(2, 1)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 1),
                    listOf(
                        GridReference(1, 0),
                        GridReference(2, 0),
                        GridReference(3, 0),
                        GridReference(1, 1),
                        GridReference(3, 1),
                        GridReference(1, 2),
                        GridReference(2, 2),
                        GridReference(3, 2)
                    ),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 2),
                    listOf(GridReference(2, 1), GridReference(1, 2), GridReference(3, 2), GridReference(2, 3)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 3),
                    listOf(
                        GridReference(1, 2),
                        GridReference(2, 2),
                        GridReference(3, 2),
                        GridReference(1, 3),
                        GridReference(3, 3)
                    ),
                    null
                )
                assertContains(
                    grid.cells,
                    GridReference(3, 0),
                    listOf(GridReference(2, 0), GridReference(2, 1), GridReference(3, 1)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(3, 1),
                    listOf(GridReference(3, 0), GridReference(2, 1), GridReference(3, 2)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(3, 2),
                    listOf(
                        GridReference(2, 1),
                        GridReference(3, 1),
                        GridReference(2, 2),
                        GridReference(2, 3),
                        GridReference(3, 3)
                    ),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(3, 3),
                    listOf(GridReference(3, 2), GridReference(2, 3)),
                    null
                )
            })
        })
    }

    @Test
    fun testStartOctagonGenerated2by2grid() {
        val grid = instance.generate(2, 2, SquareOctagon2GridOption.START_OCTAGON)
        println("$grid")
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(1 + ROOT_HALF, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(2 + 3 * ROOT_HALF, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(2 + 3 * ROOT_HALF, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..1), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((1..2), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(4, grid.cells.size)

            assertAll(
                {
                    assertContains(
                        grid.cells,
                        GridReference(0, 1),
                        listOf(GridReference(1, 1), GridReference(0, 2), GridReference(1, 2)),
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
                        GridReference(1, 1),
                        listOf(GridReference(0, 1), GridReference(1, 2)),
                        null
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(1, 2),
                        listOf(GridReference(0, 1), GridReference(1, 1), GridReference(0, 2)),
                        null
                    )
                })
        })
    }

    companion object {
        val instance = SquareOctagon2GridGenerator
        val ROOT_HALF = sqrt(0.5)
    }
}