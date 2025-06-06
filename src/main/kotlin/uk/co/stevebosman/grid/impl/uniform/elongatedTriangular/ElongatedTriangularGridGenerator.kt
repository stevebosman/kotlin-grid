package uk.co.stevebosman.grid.impl.uniform.elongatedTriangular

import uk.co.stevebosman.grid.BoundingBoxFactory
import uk.co.stevebosman.grid.Cell
import uk.co.stevebosman.grid.Grid
import uk.co.stevebosman.grid.GridReference

object ElongatedTriangularGridGenerator {
    fun generate(
        width: Int,
        height: Int,
        option: ElongatedTriangularGridOption = ElongatedTriangularGridOption.START_TRIANGLES_SPIKY
    ): Grid {
        val references = mutableListOf<GridReference>()
        val xRange = (0..width - 1)
        val yRange = when (option) {
            ElongatedTriangularGridOption.START_TRIANGLES_FULL, ElongatedTriangularGridOption.START_TRIANGLES_SPIKY -> (0..height - 1)
            ElongatedTriangularGridOption.START_SQUARES_FULL, ElongatedTriangularGridOption.START_SQUARES_SPIKY -> (1..height)
        }

        when (option) {
            ElongatedTriangularGridOption.START_TRIANGLES_FULL, ElongatedTriangularGridOption.START_SQUARES_FULL -> {
                xRange.forEach { x ->
                    yRange.forEach { y ->
                        if (isTriangleRow(y) || isSquare(width, x, y)) {
                            references.add(GridReference(x, y))
                        }
                    }
                }
            }

            ElongatedTriangularGridOption.START_TRIANGLES_SPIKY, ElongatedTriangularGridOption.START_SQUARES_SPIKY -> {
                xRange.forEach { x ->
                    yRange.forEach { y ->
                        if (isTriangleRow(y) || isSquare(width, x, y)) {
                            val element = GridReference(x, y)
                            val type = ElongatedTriangularCellType.of(element)
                            if (!(y == 0 && type == ElongatedTriangularCellType.TriangleDown) && !(y == yRange.last && type == ElongatedTriangularCellType.TriangleUp)) {
                                references.add(element)
                            }
                        }
                    }
                }
            }
        }

        val cells = references.associateWith { r ->
            val type = ElongatedTriangularCellType.of(r)
            val neighbours = when {
                r.y % 4 == 1 ->
                    // squares
                    listOf(
                        GridReference(r.x, r.y - 1),
                        GridReference(r.x - 2, r.y),
                        GridReference(r.x + 2, r.y),
                        GridReference(r.x, r.y + 1)
                    )

                r.y % 4 == 3 ->
                    // offset squares
                    listOf(
                        GridReference(r.x, r.y - 1),
                        GridReference(r.x - 2, r.y),
                        GridReference(r.x + 2, r.y),
                        GridReference(r.x, r.y + 1)
                    )

                r.x % 2 == 1 && type == ElongatedTriangularCellType.TriangleDown ->
                    // down triangle first type
                    listOf(
                        GridReference(r.x - 1, r.y - 1),
                        GridReference(r.x - 1, r.y),
                        GridReference(r.x + 1, r.y)
                    )

                r.x % 2 == 0 && type == ElongatedTriangularCellType.TriangleDown ->
                    // down triangle second type
                    listOf(
                        GridReference(r.x, r.y - 1),
                        GridReference(r.x - 1, r.y),
                        GridReference(r.x + 1, r.y)
                    )

                r.x % 2 == 0 ->
                    // up triangle first type
                    listOf(
                        GridReference(r.x - 1, r.y),
                        GridReference(r.x + 1, r.y),
                        GridReference(r.x, r.y + 1)
                    )

                else ->
                    // up triangle second type
                    listOf(
                        GridReference(r.x - 1, r.y),
                        GridReference(r.x + 1, r.y),
                        GridReference(r.x - 1, r.y - 1)
                    )
            }.filter { r -> references.contains(r) }
            Cell(r, neighbours, ElongatedTriangularGridCellPositioner)
        }

        return Grid(cells, BoundingBoxFactory.of(cells.values), xRange, yRange)
    }

    private fun isSquare(width: Int, x: Int, y: Int): Boolean =
        (y % 2 == 1 && x % 2 == 0 && !(y % 4 == 3 && width % 2 == 1 && x == width - 1))

    private fun isTriangleRow(y: Int): Boolean = y % 2 == 0
}