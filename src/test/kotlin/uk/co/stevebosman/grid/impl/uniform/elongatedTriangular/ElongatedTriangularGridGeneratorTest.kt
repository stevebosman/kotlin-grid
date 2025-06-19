package uk.co.stevebosman.grid.impl.uniform.elongatedTriangular

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.grid.svg.GridSvg.toSvg
import uk.co.stevebosman.test.DELTA
import uk.co.stevebosman.test.GridAssertions.assertContains
import kotlin.math.sqrt

class ElongatedTriangularGridGeneratorTest {
    @Test
    fun testStartTrianglesSpikyGenerated2by2grid() {
        val grid = instance.generate(2, 2)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(1.0, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(1 + HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..1), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((0..1), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(2, grid.cells.size)

            assertAll({
                assertContains(
                    grid.cells, GridReference(0, 0), listOf(GridReference(0, 1))
                )
            }, {
                assertContains(
                    grid.cells, GridReference(0, 1), listOf(GridReference(0, 0))
                )
            })
        })
    }

    @Test
    fun testStartTrianglesSpikyGenerated3by3grid() {
        val grid = instance.generate(3, 3)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(2.0, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(1 + 2 * HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..2), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((0..2), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(6, grid.cells.size)
            assertAll({
                assertContains(
                    grid.cells, GridReference(0, 0), listOf(GridReference(0, 1))
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(0, 1),
                    listOf(GridReference(0, 0), GridReference(2, 1), GridReference(0, 2)),

                    )
            }, {
                assertContains(
                    grid.cells, GridReference(0, 2), listOf(GridReference(0, 1))
                )
            }, {
                assertContains(
                    grid.cells, GridReference(2, 0), listOf(GridReference(2, 1))
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 1),
                    listOf(GridReference(2, 0), GridReference(0, 1), GridReference(2, 2)),

                    )
            }, {
                assertContains(
                    grid.cells, GridReference(2, 2), listOf(GridReference(2, 1))
                )
            })
        })
    }

    @Test
    fun testStartTrianglesGenerated2by2grid() {
        val grid = instance.generate(2, 2, ElongatedTriangularGridOption.START_TRIANGLES_FULL)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(1.5, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(1 + HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..1), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((0..1), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(3, grid.cells.size)

            assertAll({
                assertContains(
                    grid.cells, GridReference(0, 0), listOf(GridReference(1, 0), GridReference(0, 1))
                )
            }, {
                assertContains(
                    grid.cells, GridReference(0, 1), listOf(GridReference(0, 0))
                )
            }, {
                assertContains(
                    grid.cells, GridReference(1, 0), listOf(GridReference(0, 0))
                )
            })
        })
    }

    @Test
    fun testStartTrianglesGenerated3by3grid() {
        val grid = instance.generate(3, 3, ElongatedTriangularGridOption.START_TRIANGLES_FULL)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(0.0, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(2.0, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(1 + 2 * HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..2), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((0..2), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(8, grid.cells.size)
            assertAll({
                assertContains(
                    grid.cells, GridReference(0, 0), listOf(GridReference(1, 0), GridReference(0, 1))
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(0, 1),
                    listOf(GridReference(0, 0), GridReference(2, 1), GridReference(0, 2))
                )
            }, {
                assertContains(
                    grid.cells, GridReference(0, 2), listOf(GridReference(0, 1), GridReference(1, 2))
                )
            }, {
                assertContains(
                    grid.cells, GridReference(1, 0), listOf(GridReference(0, 0), GridReference(2, 0))
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 2),
                    listOf(GridReference(0, 2), GridReference(2, 2), GridReference(0, 1)),
                )
            }, {
                assertContains(
                    grid.cells, GridReference(2, 0), listOf(GridReference(1, 0), GridReference(2, 1))
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(2, 1),
                    listOf(GridReference(2, 0), GridReference(0, 1), GridReference(2, 2))
                )
            }, {
                assertContains(
                    grid.cells, GridReference(2, 2), listOf(GridReference(2, 1), GridReference(1, 2))
                )
            })
        })
    }

    @Test
    fun testStartSquaresSpikyGenerated2by2grid() {
        val grid = instance.generate(2, 2, ElongatedTriangularGridOption.START_SQUARES_SPIKY)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(HALF_ROOT_THREE, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(1.0, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(1 + HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..1), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((1..2), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(2, grid.cells.size)

            assertAll({
                assertContains(
                    grid.cells, GridReference(0, 1), listOf(GridReference(0, 2))
                )
            }, {
                assertContains(
                    grid.cells, GridReference(0, 2), listOf(GridReference(0, 1))
                )
            })
        })
    }

    @Test
    fun testStartSquaresSpikyGenerated3by3grid() {
        val grid = instance.generate(3, 3, ElongatedTriangularGridOption.START_SQUARES_SPIKY)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(HALF_ROOT_THREE, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(2.0, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(2 + HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..2), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((1..3), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(6, grid.cells.size)
            assertAll({
                assertContains(
                    grid.cells, GridReference(0, 1), listOf(GridReference(2, 1), GridReference(0, 2))
                )
            }, {
                assertContains(
                    grid.cells, GridReference(0, 2), listOf(GridReference(0, 1), GridReference(1, 2))
                )
            }, {
                assertContains(
                    grid.cells, GridReference(0, 3), listOf(GridReference(0, 2))
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 2),
                    listOf(GridReference(0, 2), GridReference(2, 2), GridReference(0, 1)),
                )
            }, {
                assertContains(
                    grid.cells, GridReference(2, 1), listOf(GridReference(0, 1), GridReference(2, 2))
                )
            }, {
                assertContains(
                    grid.cells, GridReference(2, 2), listOf(GridReference(2, 1), GridReference(1, 2))
                )
            })
        })
    }

    @Test
    fun testStartSquaresGenerated2by2grid() {
        val grid = instance.generate(2, 2, ElongatedTriangularGridOption.START_SQUARES_FULL)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(HALF_ROOT_THREE, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(1.5, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(1 + HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..1), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((1..2), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(3, grid.cells.size)

            assertAll({
                assertContains(
                    grid.cells, GridReference(0, 1), listOf(GridReference(0, 2))
                )
            }, {
                assertContains(
                    grid.cells, GridReference(0, 2), listOf(GridReference(0, 1), GridReference(1, 2))
                )
            }, {
                assertContains(
                    grid.cells, GridReference(1, 2), listOf(GridReference(0, 2), GridReference(0, 1))
                )
            })
        })
    }

    @Test
    fun testStartSquaresGenerated3by3grid() {
        val grid = instance.generate(3, 3, ElongatedTriangularGridOption.START_SQUARES_FULL)
        println(grid.toSvg())
        assertAll({
            assertEquals(0.0, grid.boundingBox.lowerLeft.x, DELTA) { -> "unexpected lower bound x" }
        }, {
            assertEquals(HALF_ROOT_THREE, grid.boundingBox.lowerLeft.y, DELTA) { -> "unexpected lower bound y" }
        }, {
            assertEquals(2.0, grid.boundingBox.width, DELTA) { -> "unexpected width" }
        }, {
            assertEquals(2 + HALF_ROOT_THREE, grid.boundingBox.height, DELTA) { -> "unexpected height" }
        }, {
            assertEquals((0..2), grid.xRange) { -> "unexpected x range" }
        }, {
            assertEquals((1..3), grid.yRange) { -> "unexpected y range" }
        }, {
            assertEquals(6, grid.cells.size)
            assertAll({
                assertContains(
                    grid.cells, GridReference(0, 1), listOf(GridReference(2, 1), GridReference(0, 2))
                )
            }, {
                assertContains(
                    grid.cells, GridReference(0, 2), listOf(GridReference(0, 1), GridReference(1, 2))
                )
            }, {
                assertContains(
                    grid.cells, GridReference(0, 3), listOf(GridReference(0, 2))
                )
            }, {
                assertContains(
                    grid.cells,
                    GridReference(1, 2),
                    listOf(GridReference(0, 2), GridReference(2, 2), GridReference(0, 1))
                )
            }, {
                assertContains(
                    grid.cells, GridReference(2, 1), listOf(GridReference(0, 1), GridReference(2, 2))
                )
            }, {
                assertContains(
                    grid.cells, GridReference(2, 2), listOf(GridReference(2, 1), GridReference(1, 2))
                )
            })
        })
    }

    companion object {
        val instance = ElongatedTriangularGridGenerator
        val HALF_ROOT_THREE = sqrt(3.0) / 2
    }
}