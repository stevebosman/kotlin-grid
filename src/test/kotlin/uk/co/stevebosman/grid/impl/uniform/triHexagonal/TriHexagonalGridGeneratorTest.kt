package uk.co.stevebosman.grid.impl.uniform.triHexagonal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.test.DELTA
import uk.co.stevebosman.test.GridAssertions.assertContains
import kotlin.math.sqrt

class TriHexagonalGridGeneratorTest {
    @Test
    fun testStandardGenerated2by2grid() {
        val grid = instance.generate(2, 2)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(3.0, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(4 * HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..2), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((0..1), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(6, grid.cells.size)

            assertAll(
                {
                    assertContains(
                        grid.cells,
                        GridReference(0, 0),
                        listOf(GridReference(1, 0), GridReference(2, 0), GridReference(0, 1)),
                        null
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(1, 0),
                        listOf(GridReference(0, 0)),
                        null
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(2, 0),
                        listOf(GridReference(0, 0), GridReference(2, 1)),
                        null
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(0, 1),
                        listOf(GridReference(0, 0), GridReference(2, 1)),
                        null
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(1, 1),
                        listOf(GridReference(2, 1)),
                        null
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(2, 1),
                        listOf(GridReference(2, 0), GridReference(0, 1), GridReference(1, 1)),
                        null
                    )
                })
        })
    }

    @Test
    fun testStandardGenerated3by3grid() {
        val grid = instance.generate(3, 3)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(4.0, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(6 * HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..4), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((0..2), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(13, grid.cells.size)
            assertAll({
                assertContains(
                    grid.cells,
                    GridReference(0, 0),
                    listOf(GridReference(x = 1, y = 0), GridReference(x = 2, y = 0), GridReference(x = 0, y = 1)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(0, 1),
                    listOf(GridReference(x = 0, y = 0), GridReference(x = 2, y = 1)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(0, 2),
                    listOf(GridReference(x = 1, y = 1), GridReference(x = 1, y = 2), GridReference(x = 2, y = 2)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 0),
                    listOf(GridReference(x = 0, y = 0), GridReference(x = 3, y = 0)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 1),
                    listOf(GridReference(x = 2, y = 1), GridReference(x = 0, y = 2)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 2),
                    listOf(GridReference(x = 1, y = 1), GridReference(x = 0, y = 2), GridReference(x = 3, y = 2)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 0),
                    listOf(GridReference(x = 0, y = 0), GridReference(x = 3, y = 0), GridReference(x = 2, y = 1)),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 1),
                    listOf(
                        GridReference(x = 2, y = 0),
                        GridReference(x = 0, y = 1),
                        GridReference(x = 1, y = 1),
                        GridReference(x = 3, y = 1),
                        GridReference(x = 4, y = 1),
                        GridReference(x = 1, y = 2)
                    ),
                    null
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 2),
                    listOf(GridReference(x = 0, y = 2), GridReference(x = 3, y = 2)),
                    null
                )
            })
        })
    }

    @Test
    fun testStandardGenerated4by4grid() {
        val grid = instance.generate(4, 4)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(5.0, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(8 * HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..5), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((0..3), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(24, grid.cells.size)
            assertAll(
                (0..3).flatMap { y ->
                    (0..5).map { x ->
                        { assertContains(grid.cells, GridReference(x, y)) }
                    }
                }
            )
        })
    }

    @Test
    fun testStartTrianglesGenerated2by2grid() {
        val grid = instance.generate(2, 2, TriHexagonalGridOption.START_TRIANGLES)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(2 * HALF_ROOT_THREE, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(3.0, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(4 * HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..2), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((1..2), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(6, grid.cells.size)

            assertAll(
                {
                    assertContains(
                        grid.cells,
                        GridReference(0, 1),
                        listOf(GridReference(x = 2, y = 1)),
                        null
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(1, 1),
                        listOf(GridReference(x = 2, y = 1), GridReference(x = 0, y = 2)),
                        null
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(2, 1),
                        listOf(GridReference(x = 0, y = 1), GridReference(x = 1, y = 1), GridReference(x = 1, y = 2)),
                        null
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(0, 2),
                        listOf(GridReference(x = 1, y = 1), GridReference(x = 1, y = 2), GridReference(x = 2, y = 2)),
                        null
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(1, 2),
                        listOf(GridReference(x = 1, y = 1), GridReference(x = 0, y = 2)),
                        null
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(2, 2),
                        listOf(GridReference(x = 0, y = 2)),
                        null
                    )
                })
        })
    }


    @Test
    fun testStartTrianglesGenerated3by3grid() {
        val grid = instance.generate(3, 3, TriHexagonalGridOption.START_TRIANGLES)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(2 * HALF_ROOT_THREE, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(4.0, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(6 * HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..4), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((1..3), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(14, grid.cells.size)

            assertAll(
                {
                    assertContains(
                        grid.cells,
                        GridReference(0, 1),
                        listOf(GridReference(2, 1)),
                        null
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(1, 1),
                        listOf(GridReference(2, 1), GridReference(0, 2)),
                        null
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(2, 1),
                        listOf(
                            GridReference(0, 1),
                            GridReference(1, 1),
                            GridReference(3, 1),
                            GridReference(4, 1),
                            GridReference(1, 2)
                        ),
                        null
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(0, 2),
                        listOf(GridReference(1, 1), GridReference(1, 2), GridReference(2, 2), GridReference(0, 3)),
                        null
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(1, 2),
                        listOf(GridReference(1, 1), GridReference(0, 2), GridReference(3, 2)),
                        null
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(2, 2),
                        listOf(GridReference(0, 2), GridReference(3, 2), GridReference(2, 3)),
                        null
                    )
                })
        })
    }

    companion object {
        val instance = TriHexagonalGridGenerator
        val HALF_ROOT_THREE = sqrt(3.0) / 2
    }
}