package uk.co.stevebosman.grid.impl.regular.triangle

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.test.DELTA
import uk.co.stevebosman.test.GridAssertions.assertContains
import kotlin.math.sqrt

class TriangleGridGeneratorTest {
    @Test
    fun testStandardGenerated2by2grid() {
        val grid = instance.generate(2, 2)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(1.5, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(2 * HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
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
                        listOf(GridReference(1, 0)),

                        )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(0, 1),
                        listOf(GridReference(1, 1)),

                        )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(1, 0),
                        listOf(GridReference(0, 0), GridReference(1, 1)),

                        )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(1, 1),
                        listOf(GridReference(1, 0), GridReference(0, 1)),

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
            assertEquals(2.0, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(3 * HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
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
                    listOf(GridReference(1, 0)),

                    )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(0, 1),
                    listOf(GridReference(1, 1), GridReference(0, 2)),

                    )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(0, 2),
                    listOf(GridReference(0, 1), GridReference(1, 2)),

                    )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 0),
                    listOf(GridReference(0, 0), GridReference(2, 0), GridReference(1, 1)),

                    )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 1),
                    listOf(GridReference(1, 0), GridReference(0, 1), GridReference(2, 1)),

                    )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 2),
                    listOf(GridReference(0, 2), GridReference(2, 2)),

                    )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 0),
                    listOf(GridReference(1, 0)),

                    )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 1),
                    listOf(GridReference(1, 1), GridReference(2, 2)),

                    )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 2),
                    listOf(GridReference(2, 1), GridReference(1, 2)),

                    )
            })
        })
    }

    @Test
    fun testOffsetGenerated2by2grid() {
        val grid = instance.generate(2, 2, TriangleGridOption.OFFSET)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.5, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(1.5, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(2 * HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((1..2), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((0..1), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(4, grid.cells.size)

            assertAll(
                {
                    assertContains(
                        grid.cells,
                        GridReference(1, 0),
                        listOf(GridReference(2, 0), GridReference(1, 1)),
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(2, 0),
                        listOf(GridReference(1, 0)),
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(1, 1),
                        listOf(GridReference(1, 0), GridReference(2, 1)),
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(2, 1),
                        listOf(GridReference(1, 1)),
                    )
                })
        })
    }

    @Test
    fun testOffsetGenerated3by3grid() {
        val grid = instance.generate(3, 3, TriangleGridOption.OFFSET)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.5, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(2.0, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(3 * HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((1..3), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((0..2), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(9, grid.cells.size)
            assertAll({
                assertContains(
                    grid.cells,
                    GridReference(1, 0),
                    listOf(GridReference(2, 0), GridReference(1, 1)),
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 0),
                    listOf(GridReference(1, 0), GridReference(3, 0)),
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(3, 0),
                    listOf(GridReference(2, 0), GridReference(3, 1)),
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 1),
                    listOf(GridReference(1, 0), GridReference(2, 1)),
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 1),
                    listOf(GridReference(1, 1), GridReference(3, 1), GridReference(2, 2)),
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(3, 1),
                    listOf(GridReference(3, 0), GridReference(2, 1)),
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 2),
                    listOf(GridReference(2, 2)),
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 2),
                    listOf(GridReference(2, 1), GridReference(1, 2), GridReference(3, 2)),
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(3, 2),
                    listOf(GridReference(2, 2)),
                )
            })
        })
    }

    @Test
    fun testTriangleGenerated2by2grid() {
        val grid = instance.generate(2, 2, TriangleGridOption.TRIANGLE)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(2.0, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(2 * HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..2), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((0..1), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(4, grid.cells.size)

            assertAll(
                {
                    assertContains(
                        grid.cells,
                        GridReference(0, 0),
                        listOf(GridReference(1, 0)),
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(1, 0),
                        listOf(GridReference(0, 0), GridReference(2, 0), GridReference(1, 1)),
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(1, 1),
                        listOf(GridReference(1, 0)),
                    )
                })
        })
    }

    @Test
    fun testTriangleGenerated3by3grid() {
        val grid = instance.generate(3, 3, TriangleGridOption.TRIANGLE)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(3.0, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(3 * HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..4), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((0..2), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(9, grid.cells.size)

            assertAll({
                assertContains(
                    grid.cells,
                    GridReference(0, 0),
                    listOf(GridReference(1, 0)),
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 0),
                    listOf(GridReference(0, 0), GridReference(2, 0), GridReference(1, 1)),
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 0),
                    listOf(GridReference(1, 0), GridReference(3, 0)),
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(3, 0),
                    listOf(GridReference(2, 0), GridReference(4, 0), GridReference(3, 1)),
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(4, 0),
                    listOf(GridReference(3, 0)),
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 1),
                    listOf(GridReference(1, 0), GridReference(2, 1)),
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 1),
                    listOf(GridReference(1, 1), GridReference(3, 1), GridReference(2, 2)),
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(3, 1),
                    listOf(GridReference(3, 0), GridReference(2, 1)),
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 2),
                    listOf(GridReference(2, 1)),
                )
            })
        })
    }

    @Test
    fun testSpikyGenerated2by2grid() {
        val grid = instance.generate(2, 2, TriangleGridOption.SPIKY)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.5, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(1.0, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(2 * HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..1), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((0..1), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(2, grid.cells.size)

            assertAll(
                {
                    assertContains(
                        grid.cells,
                        GridReference(1, 0),
                        listOf(GridReference(1, 1)),

                        )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(1, 1),
                        listOf(GridReference(1, 0)),

                        )
                })
        })
    }

    @Test
    fun testSpikyGenerated3by3grid() {
        val grid = instance.generate(3, 3, TriangleGridOption.SPIKY)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(2.0, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(3 * HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..2), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((0..2), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(6, grid.cells.size)

            assertAll({
                assertContains(
                    grid.cells,
                    GridReference(0, 1),
                    listOf(GridReference(1, 1), GridReference(0, 2)),

                    )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(0, 2),
                    listOf(GridReference(0, 1)),

                    )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 0),
                    listOf(GridReference(1, 1)),

                    )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 1),
                    listOf(GridReference(1, 0), GridReference(0, 1), GridReference(2, 1)),

                    )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 1),
                    listOf(GridReference(1, 1), GridReference(2, 2)),

                    )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 2),
                    listOf(GridReference(2, 1)),

                    )
            })
        })
    }

    @Test
    fun testOffsetSpikyGenerated2by2grid() {
        val grid = instance.generate(2, 2, TriangleGridOption.OFFSET_SPIKY)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.5, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(1.0, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(2 * HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((1..2), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((0..1), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(2, grid.cells.size)

            assertAll(
                {
                    assertContains(
                        grid.cells,
                        GridReference(1, 0),
                        listOf(GridReference(1, 1)),
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(1, 1),
                        listOf(GridReference(1, 0)),
                    )
                })
        })
    }

    @Test
    fun testOffsetSpikyGenerated3by3grid() {
        val grid = instance.generate(3, 3, TriangleGridOption.OFFSET_SPIKY)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.5, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(2.0, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(3 * HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((1..3), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((0..2), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(6, grid.cells.size)

            assertAll({
                assertContains(
                    grid.cells,
                    GridReference(1, 0),
                    listOf(GridReference(1, 1)),
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 1),
                    listOf(GridReference(1, 0), GridReference(2, 1)),
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 1),
                    listOf(GridReference(1, 1), GridReference(3, 1), GridReference(2, 2)),
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 2),
                    listOf(GridReference(2, 1)),
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(3, 0),
                    listOf(GridReference(3, 1)),
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(3, 1),
                    listOf(GridReference(3, 0), GridReference(2, 1)),
                )
            })
        })
    }

    companion object {
        val instance = TriangleGridGenerator
        val HALF_ROOT_THREE = sqrt(3.0) / 2
    }
}