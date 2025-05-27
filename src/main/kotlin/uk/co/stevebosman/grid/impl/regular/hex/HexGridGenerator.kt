package uk.co.stevebosman.grid.impl.regular.hex

import uk.co.stevebosman.grid.BoundingBoxFactory
import uk.co.stevebosman.grid.Cell
import uk.co.stevebosman.grid.Grid
import uk.co.stevebosman.grid.GridReference

object HexGridGenerator {
    fun generate(width: Int, height: Int, option: HexGridOption = HexGridOption.STANDARD): Grid {
        val references = mutableListOf<GridReference>()
        val xRange = (0..width - 1)
        val yRange =         when (option) {
            HexGridOption.STANDARD -> (0..height - 1)
            HexGridOption.STANDARD_SKIP_LAST -> (0..height - 1)
            HexGridOption.OFFSET -> (1..height )
            HexGridOption.OFFSET_SKIP_LAST -> (1..height)
            HexGridOption.TRIANGLE -> (0..height - 1)
        }

        when (option) {
            HexGridOption.STANDARD -> {
                yRange.forEach { y ->
                    (0..width - 1).forEach { x ->
                        references.add(GridReference(x, y))
                    }
                }
            }

            HexGridOption.STANDARD_SKIP_LAST -> {
                yRange.forEach { y ->
                    (0..width - 1 - if (y % 2 == 0) {
                        0
                    } else {
                        1
                    }).forEach { x ->
                        references.add(GridReference(x, y))
                    }
                }
            }

            HexGridOption.OFFSET -> {
                yRange.forEach { y ->
                    (0..width - 1).forEach { x ->
                        references.add(GridReference(x, y))
                    }
                }
            }

            HexGridOption.OFFSET_SKIP_LAST -> {
                yRange.forEach { y ->
                    (0..width - 1 - if (y % 2 == 0) {
                        0
                    } else {
                        1
                    }).forEach { x ->
                        references.add(GridReference(x, y))
                    }
                }
            }

            HexGridOption.TRIANGLE -> {
                yRange.forEach { y ->
                    (y / 2..width - (y + 1) / 2 - 1).forEach { x ->
                        references.add(GridReference(x, y))
                    }
                }
            }
        }
        val cells = references.associateWith { r ->
            val neighbours = if (r.y % 2 == 0) {
                listOf(
                    GridReference(r.x - 1, r.y - 1),
                    GridReference(r.x, r.y - 1),
                    GridReference(r.x + 1, r.y),
                    GridReference(r.x, r.y + 1),
                    GridReference(r.x - 1, r.y + 1),
                    GridReference(r.x - 1, r.y),
                )
            } else {
                listOf(
                    GridReference(r.x, r.y - 1),
                    GridReference(r.x + 1, r.y - 1),
                    GridReference(r.x + 1, r.y),
                    GridReference(r.x + 1, r.y + 1),
                    GridReference(r.x, r.y + 1),
                    GridReference(r.x - 1, r.y),
                )
            }.filter { r -> references.contains(r) }
            Cell(r, neighbours, HexGridCellPositioner)
        }

        return Grid(cells, BoundingBoxFactory.of(cells.values), xRange, yRange)
    }
}