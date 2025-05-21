package uk.co.stevebosman.grid.impl.regular.triangle

import uk.co.stevebosman.grid.Cell
import uk.co.stevebosman.grid.Grid
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.grid.BoundingBoxFactory

object TriangleGridGenerator {
    fun generate(width: Int, height: Int, option: TriangleGridOption = TriangleGridOption.STANDARD): Grid {
        val references = mutableListOf<GridReference>()

        when (option) {
            TriangleGridOption.STANDARD -> {
                (0..width - 1).forEach { x ->
                    (0..height - 1).forEach { y ->
                        references.add(GridReference(x, y))
                    }
                }
            }

            TriangleGridOption.OFFSET -> {
                (1..width).forEach { x ->
                    (0..height - 1).forEach { y ->
                        references.add(GridReference(x, y))
                    }
                }
            }

            TriangleGridOption.TRIANGLE -> {
                (0..height - 1).forEach { y ->
                    val w = width * 2 - 1 - y
                    (y..w - 1).forEach { x ->
                        references.add(GridReference(x, y))
                    }
                }
            }

            TriangleGridOption.SPIKY -> {
                (0..width - 1).forEach { x ->
                    (0..height - 1).forEach { y ->
                        val innerRows = y != 0 && y != height - 1
                        val firstRowDown = y == 0 && x % 2 == 1
                        val lastRowUp = y == height - 1 && y % 2 == x % 2
                        if (innerRows || firstRowDown || lastRowUp)
                            references.add(GridReference(x, y))
                    }
                }
            }
        }

        val cells = references.associateWith { r ->
            val neighbours = if ((r.x + r.y) % 2 == 0) {
                listOf(
                    GridReference(r.x, r.y - 1), GridReference(r.x - 1, r.y), GridReference(r.x + 1, r.y)
                )
            } else {
                listOf(
                    GridReference(r.x - 1, r.y), GridReference(r.x + 1, r.y), GridReference(r.x, r.y + 1)
                )
            }.filter { r -> references.contains(r) }
            Cell(r, neighbours, TriangleGridCellPositioner)
        }

        return Grid(cells, BoundingBoxFactory.of(cells.values))
    }
}