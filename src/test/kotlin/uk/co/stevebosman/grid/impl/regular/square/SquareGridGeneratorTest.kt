package uk.co.stevebosman.grid.impl.regular.square

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.grid.svg.GridSvg.toSvg
import uk.co.stevebosman.maths.geometry.Point
import uk.co.stevebosman.test.DELTA
import uk.co.stevebosman.test.GridAssertions.assertContains

class SquareGridGeneratorTest {
    @Test
    fun testGenerated2by2grid() {
        val grid = instance.generate(2, 2)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(2.0, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(2.0, grid.boundingBox.height, DELTA) { -> "unexpected height" }
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
                        listOf(
                            Point(0.0, 0.0),
                            Point(1.0, 0.0),
                            Point(1.0, 1.0),
                            Point(0.0, 1.0)
                        )
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(0, 1),
                        listOf(GridReference(0, 0), GridReference(1, 1)),
                        listOf(
                            Point(0.0, 1.0),
                            Point(1.0, 1.0),
                            Point(1.0, 2.0),
                            Point(0.0, 2.0)
                        )
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(1, 0),
                        listOf(GridReference(0, 0), GridReference(1, 1)),
                        listOf(
                            Point(1.0, 0.0),
                            Point(2.0, 0.0),
                            Point(2.0, 1.0),
                            Point(1.0, 1.0)
                        )
                    )
                }, {
                    assertContains(
                        grid.cells,
                        GridReference(1, 1),
                        listOf(GridReference(1, 0), GridReference(0, 1)),
                        listOf(
                            Point(1.0, 1.0),
                            Point(2.0, 1.0),
                            Point(2.0, 2.0),
                            Point(1.0, 2.0)
                        )
                    )
                })
        })
    }

    @Test
    fun testGenerated3by3grid() {
        val grid = instance.generate(3, 3)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(3.0, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(3.0, grid.boundingBox.height, DELTA) { -> "unexpected height" }
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
                    listOf(
                        Point(0.0, 0.0),
                        Point(1.0, 0.0),
                        Point(1.0, 1.0),
                        Point(0.0, 1.0)
                    )
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(0, 1),
                    listOf(GridReference(0, 0), GridReference(1, 1), GridReference(0, 2)),
                    listOf(
                        Point(0.0, 1.0),
                        Point(1.0, 1.0),
                        Point(1.0, 2.0),
                        Point(0.0, 2.0)
                    )
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(0, 2),
                    listOf(GridReference(0, 1), GridReference(1, 2)),
                    listOf(
                        Point(0.0, 2.0),
                        Point(1.0, 2.0),
                        Point(1.0, 3.0),
                        Point(0.0, 3.0)
                    )
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 0),
                    listOf(GridReference(0, 0), GridReference(2, 0), GridReference(1, 1)),
                    listOf(
                        Point(1.0, 0.0),
                        Point(2.0, 0.0),
                        Point(2.0, 1.0),
                        Point(1.0, 1.0)
                    )
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 1),
                    listOf(GridReference(1, 0), GridReference(0, 1), GridReference(2, 1), GridReference(1, 2)),
                    listOf(
                        Point(1.0, 1.0),
                        Point(2.0, 1.0),
                        Point(2.0, 2.0),
                        Point(1.0, 2.0)
                    )
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 2),
                    listOf(GridReference(1, 1), GridReference(0, 2), GridReference(2, 2)),
                    listOf(
                        Point(1.0, 2.0),
                        Point(2.0, 2.0),
                        Point(2.0, 3.0),
                        Point(1.0, 3.0)
                    )
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 0),
                    listOf(GridReference(1, 0), GridReference(2, 1)),
                    listOf(
                        Point(2.0, 0.0),
                        Point(3.0, 0.0),
                        Point(3.0, 1.0),
                        Point(2.0, 1.0)
                    )
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 1),
                    listOf(GridReference(2, 0), GridReference(1, 1), GridReference(2, 2)),
                    listOf(
                        Point(2.0, 1.0),
                        Point(3.0, 1.0),
                        Point(3.0, 2.0),
                        Point(2.0, 2.0)
                    )
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 2),
                    listOf(GridReference(2, 1), GridReference(1, 2)),
                    listOf(
                        Point(2.0, 2.0),
                        Point(3.0, 2.0),
                        Point(3.0, 3.0),
                        Point(2.0, 3.0)
                    )
                )
            })
        })
    }

    companion object {
        val instance = SquareGridGenerator
    }
}