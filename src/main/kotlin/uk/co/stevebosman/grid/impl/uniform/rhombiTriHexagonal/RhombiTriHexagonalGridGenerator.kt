package uk.co.stevebosman.grid.impl.uniform.rhombiTriHexagonal

import uk.co.stevebosman.grid.BoundingBoxFactory
import uk.co.stevebosman.grid.Cell
import uk.co.stevebosman.grid.Grid
import uk.co.stevebosman.grid.GridReference

object RhombiTriHexagonalGridGenerator {
    fun generate(
        width: Int,
        height: Int,
        option: RhombiTriHexagonalGridOption = RhombiTriHexagonalGridOption.STANDARD
    ): Grid {
        val hexReferences = mutableListOf<GridReference>()

        val xHexRange = (0..width - 1)
        val yHexRange = when (option) {
            RhombiTriHexagonalGridOption.STANDARD -> (0..height - 1)
            RhombiTriHexagonalGridOption.STANDARD_SKIP_LAST -> (0..height - 1)
            RhombiTriHexagonalGridOption.OFFSET -> (1..height)
            RhombiTriHexagonalGridOption.OFFSET_SKIP_LAST -> (1..height)
            RhombiTriHexagonalGridOption.TRIANGLE -> (0..height - 1)
        }

        when (option) {
            RhombiTriHexagonalGridOption.STANDARD, RhombiTriHexagonalGridOption.OFFSET -> {
                yHexRange.forEach { y ->
                    xHexRange.forEach { x ->
                        hexReferences.add(getHexReference(y, x))
                    }
                }
            }

            RhombiTriHexagonalGridOption.STANDARD_SKIP_LAST -> {
                yHexRange.forEach { y ->
                    (0..width - if (y % 2 == 0) {
                        1
                    } else {
                        2
                    }).forEach { x ->
                        hexReferences.add(getHexReference(y, x))
                    }
                }
            }

            RhombiTriHexagonalGridOption.OFFSET_SKIP_LAST -> {
                yHexRange.forEach { y ->
                    (0..width - 1 - if (y % 2 == 0) {
                        0
                    } else {
                        1
                    }).forEach { x ->
                        hexReferences.add(getHexReference(y, x))
                    }
                }
            }

            RhombiTriHexagonalGridOption.TRIANGLE -> {
                yHexRange.forEach { y ->
                    (y / 2..width - (y + 1) / 2 - 1).forEach { x ->
                        hexReferences.add(getHexReference(y, x))
                    }
                }
            }
        }

        val references = hexReferences.flatMap { r ->
            setOf(
                //triangle up
                GridReference(r.x - 1, r.y - 1),
                //square slant 1
                GridReference(r.x, r.y - 1),
                //triangle down
                GridReference(r.x + 1, r.y - 1),
                //square slant 2
                GridReference(r.x + 2, r.y - 1),
                //triangle up
                GridReference(r.x + 3, r.y - 1),
                //square
                GridReference(r.x - 1, r.y),
                //hexagon
                r,
                //square
                GridReference(r.x + 3, r.y),
                //triangle down
                GridReference(r.x - 1, r.y + 1),
                // square 2
                GridReference(r.x, r.y + 1),
                // triangle up
                GridReference(r.x + 1, r.y + 1),
                //square 1
                GridReference(r.x + 2, r.y + 1),
                // triangle down
                GridReference(r.x + 3, r.y + 1),
            )
        }
        val xRange = (0..references.maxOf { r -> r.x })
        val yRange = (0..references.maxOf { r -> r.y })

        val cells = references.associateWith { r ->
            val neighbours = listOf<GridReference>().filter { r -> references.contains(r) }
            Cell(r, neighbours, RhombiTriHexagonalGridCellPositioner)
        }

        return Grid(cells, BoundingBoxFactory.of(cells.values), xRange, yRange)
    }

    private fun getHexReference(y: Int, x: Int): GridReference = GridReference(
        if (y % 2 == 0) {
            1
        } else {
            3
        } + 4 * x,
        1 + 2 * y
    )
}