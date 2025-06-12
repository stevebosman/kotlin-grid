package uk.co.stevebosman.grid.impl.uniform.snubHexagonal

import uk.co.stevebosman.grid.BoundingBoxFactory
import uk.co.stevebosman.grid.Cell
import uk.co.stevebosman.grid.Grid
import uk.co.stevebosman.grid.GridReference

object SnubHexagonalGridGenerator {
    fun generate(
        width: Int,
        height: Int,
        option: SnubHexagonalGridOption = SnubHexagonalGridOption.STANDARD
    ): Grid {
        val hexReferences = mutableListOf<GridReference>()

        val xHexRange = (0..width - 1)
        val yHexRange = when (option) {
            SnubHexagonalGridOption.STANDARD -> (0..height - 1)
            SnubHexagonalGridOption.STANDARD_SKIP_LAST -> (0..height - 1)
            SnubHexagonalGridOption.OFFSET -> (1..height)
            SnubHexagonalGridOption.OFFSET_SKIP_LAST -> (1..height)
            SnubHexagonalGridOption.TRIANGLE -> (0..height - 1)
        }

        when (option) {
            SnubHexagonalGridOption.STANDARD, SnubHexagonalGridOption.OFFSET -> {
                yHexRange.forEach { y ->
                    xHexRange.forEach { x ->
                        hexReferences.add(getHexReference(y, x))
                    }
                }
            }

            SnubHexagonalGridOption.STANDARD_SKIP_LAST -> {
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

            SnubHexagonalGridOption.OFFSET_SKIP_LAST -> {
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

            SnubHexagonalGridOption.TRIANGLE -> {
                yHexRange.forEach { y ->
                    (y / 2..width - (y + 1) / 2 - 1).forEach { x ->
                        hexReferences.add(getHexReference(y, x))
                    }
                }
            }
        }

        val references = hexReferences.flatMap { r ->
            setOf(
                GridReference(r.x - 2, r.y - 1),
                GridReference(r.x - 1, r.y - 1),
                GridReference(r.x, r.y - 1),
                GridReference(r.x + 1, r.y - 1),
                GridReference(r.x + 2, r.y - 1),
                GridReference(r.x + 3, r.y - 1),
                GridReference(r.x + 4, r.y - 1),

                GridReference(r.x - 2, r.y),
                GridReference(r.x - 1, r.y),
                r,
                GridReference(r.x + 4, r.y),
                GridReference(r.x + 5, r.y),

                GridReference(r.x - 2, r.y + 1),
                GridReference(r.x - 1, r.y + 1),
                GridReference(r.x, r.y + 1),
                GridReference(r.x + 1, r.y + 1),
                GridReference(r.x + 2, r.y + 1),
                GridReference(r.x + 3, r.y + 1),
                GridReference(r.x + 4, r.y + 1),
            )
        }
        val xRange = (0..references.maxOf { r -> r.x })
        val yRange = (0..references.maxOf { r -> r.y })

        val cells = references.associateWith { r ->
            val neighbours = listOf<GridReference>().filter { r -> references.contains(r) }
            Cell(r, neighbours, SnubHexagonalGridCellPositioner)
        }

        return Grid(cells, BoundingBoxFactory.of(cells.values), xRange, yRange)
    }

    private fun getHexReference(y: Int, x: Int): GridReference = GridReference(
        if (y % 2 == 0) {
            2
        } else {
            5
        } + 6 * x,
        1 + 2 * y
    )
}