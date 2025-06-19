package uk.co.stevebosman.grid.impl.floretPentagonal

import uk.co.stevebosman.grid.BoundingBoxFactory
import uk.co.stevebosman.grid.Cell
import uk.co.stevebosman.grid.Grid
import uk.co.stevebosman.grid.GridReference
import kotlin.math.max

object FloretPentagonalGridGenerator {
    fun generate(
        width: Int, height: Int, option: FloretPentagonalGridOption = FloretPentagonalGridOption.STANDARD
    ): Grid {
        val references = mutableListOf<GridReference>()

        val xHexRange = when (option) {
            FloretPentagonalGridOption.STANDARD -> (0..width - 1)
            FloretPentagonalGridOption.STANDARD_SKIP_LAST -> (0..max(width - 1, 1))
            FloretPentagonalGridOption.OFFSET -> (0..width - 1)
            FloretPentagonalGridOption.OFFSET_SKIP_LAST -> (0..max(width - 1, 1))
            FloretPentagonalGridOption.TRIANGLE -> (0..width - 1)
        }
        val yHexRange = when (option) {
            FloretPentagonalGridOption.STANDARD -> (0..height - 1)
            FloretPentagonalGridOption.STANDARD_SKIP_LAST -> (0..height - 1)
            FloretPentagonalGridOption.OFFSET -> (1..height)
            FloretPentagonalGridOption.OFFSET_SKIP_LAST -> (1..height)
            FloretPentagonalGridOption.TRIANGLE -> (0..height - 1)
        }

        when (option) {
            FloretPentagonalGridOption.STANDARD, FloretPentagonalGridOption.OFFSET -> {
                yHexRange.forEach { y ->
                    xHexRange.forEach { x ->
                        addReferences(references, x, y)
                    }
                }
            }

            FloretPentagonalGridOption.STANDARD_SKIP_LAST -> {
                yHexRange.forEach { y ->
                    (0..width - if (y % 2 == 0) {
                        1
                    } else {
                        2
                    }).forEach { x ->
                        addReferences(references, x, y)
                    }
                }
            }

            FloretPentagonalGridOption.OFFSET_SKIP_LAST -> {
                yHexRange.forEach { y ->
                    (0..width - 1 - if (height == 1 || y % 2 == 0) {
                        0
                    } else {
                        1
                    }).forEach { x ->
                        addReferences(references, x, y)
                    }
                }
            }

            FloretPentagonalGridOption.TRIANGLE -> {
                yHexRange.forEach { y ->
                    (y / 2..width - (y + 1) / 2 - 1).forEach { x ->
                        addReferences(references, x, y)
                    }
                }
            }
        }

        val xRange = (references.minOf { r -> r.x }..references.maxOf { r -> r.x })
        val yRange = (references.minOf { r -> r.y }..references.maxOf { r -> r.y })

        val cells = references.associateWith { r ->
            val neighbours = neighboursOf(r).filter { r -> references.contains(r) }
            Cell(r, neighbours, FloretPentagonalGridCellPositioner)
        }

        return Grid(cells, BoundingBoxFactory.of(cells.values), xRange, yRange)
    }

    private fun addReferences(
        references: MutableList<GridReference>,
        x: Int,
        y: Int
    ) {
        references.add(GridReference(x * 3, 2 * y))
        references.add(GridReference(x * 3 + 1, 2 * y))
        references.add(GridReference(x * 3 + 2, 2 * y))
        references.add(GridReference(x * 3, 2 * y + 1))
        references.add(GridReference(x * 3 + 1, 2 * y + 1))
        references.add(GridReference(x * 3 + 2, 2 * y + 1))
    }

    private fun neighboursOf(
        r: GridReference,
    ): List<GridReference> = when (r.y % 4) {
        0 -> when (r.x % 3) {
            0 -> listOf(
                GridReference(r.x - 2, r.y - 1),
                GridReference(r.x - 1, r.y - 1),
                GridReference(r.x - 1, r.y),
                GridReference(r.x + 1, r.y),
                GridReference(r.x, r.y + 1)
            )

            1 -> listOf(
                GridReference(r.x - 2, r.y - 1),
                GridReference(r.x - 1, r.y - 1),
                GridReference(r.x, r.y - 1),
                GridReference(r.x - 1, r.y),
                GridReference(r.x + 1, r.y)
            )

            else -> listOf(
                GridReference(r.x - 1, r.y - 1),
                GridReference(r.x - 1, r.y),
                GridReference(r.x + 1, r.y),
                GridReference(r.x, r.y + 1),
                GridReference(r.x + 1, r.y + 1)
            )
        }

        1 -> when (r.x % 3) {
            0 -> listOf(
                GridReference(r.x - 1, r.y - 1),
                GridReference(r.x, r.y - 1),
                GridReference(r.x - 1, r.y),
                GridReference(r.x + 1, r.y),
                GridReference(r.x - 2, r.y + 1)
            )

            1 -> listOf(
                GridReference(r.x - 1, r.y),
                GridReference(r.x + 1, r.y),
                GridReference(r.x - 3, r.y + 1),
                GridReference(r.x - 2, r.y + 1),
                GridReference(r.x - 1, r.y + 1)
            )

            else -> listOf(
                GridReference(r.x, r.y - 1),
                GridReference(r.x - 1, r.y),
                GridReference(r.x + 1, r.y),
                GridReference(r.x - 2, r.y + 1),
                GridReference(r.x - 1, r.y + 1)
            )
        }

        2 -> when (r.x % 3) {
            0 -> listOf(
                GridReference(r.x + 1, r.y - 1),
                GridReference(r.x + 2, r.y - 1),
                GridReference(r.x - 1, r.y),
                GridReference(r.x + 1, r.y),
                GridReference(r.x, r.y + 1)
            )

            1 -> listOf(
                GridReference(r.x + 1, r.y - 1),
                GridReference(r.x + 2, r.y - 1),
                GridReference(r.x + 3, r.y - 1),
                GridReference(r.x - 1, r.y),
                GridReference(r.x + 1, r.y)
            )

            else -> listOf(
                GridReference(r.x + 2, r.y - 1),
                GridReference(r.x - 1, r.y),
                GridReference(r.x + 1, r.y),
                GridReference(r.x, r.y + 1),
                GridReference(r.x + 1, r.y + 1)
            )
        }

        else -> when (r.x % 3) {
            0 -> listOf(
                GridReference(r.x - 1, r.y - 1),
                GridReference(r.x, r.y - 1),
                GridReference(r.x - 1, r.y),
                GridReference(r.x + 1, r.y),
                GridReference(r.x + 1, r.y + 1)
            )

            1 -> listOf(
                GridReference(r.x - 1, r.y),
                GridReference(r.x + 1, r.y),
                GridReference(r.x, r.y + 1),
                GridReference(r.x + 1, r.y + 1),
                GridReference(r.x + 2, r.y + 1)
            )

            else -> listOf(
                GridReference(r.x, r.y - 1),
                GridReference(r.x - 1, r.y),
                GridReference(r.x + 1, r.y),
                GridReference(r.x + 1, r.y + 1),
                GridReference(r.x + 2, r.y + 1)
            )
        }
    }
}