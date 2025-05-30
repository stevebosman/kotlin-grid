package uk.co.stevebosman.grid.impl.uniform.squareOctagon2

import uk.co.stevebosman.grid.BoundingBoxFactory
import uk.co.stevebosman.grid.Cell
import uk.co.stevebosman.grid.Grid
import uk.co.stevebosman.grid.GridReference
import uk.co.stevebosman.grid.impl.uniform.squareOctagon2.SquareOctagon2GridHelper.isSquareCell

object SquareOctagon2GridGenerator {
    fun generate(
        width: Int,
        height: Int,
        option: SquareOctagon2GridOption = SquareOctagon2GridOption.START_SQUARE
    ): Grid {
        val references = mutableListOf<GridReference>()

        val xRange = (0..width - 1)
        val yRange = when (option) {
            SquareOctagon2GridOption.START_SQUARE -> (0..height - 1)
            SquareOctagon2GridOption.START_OCTAGON -> (1..height)
        }

        when (option) {
            SquareOctagon2GridOption.START_SQUARE -> yRange.forEach { y ->
                xRange.forEach { x ->
                    references.add(GridReference(x, y))
                }
            }

            SquareOctagon2GridOption.START_OCTAGON -> yRange.forEach { y ->
                xRange.forEach { x ->
                    references.add(GridReference(x, y))
                }
            }
        }

        val cells = references.associateWith { r ->
            val neighbours = if (isSquareCell(r)) {
                listOf(
                    GridReference(r.x, r.y - 1),
                    GridReference(r.x - 1, r.y),
                    GridReference(r.x + 1, r.y),
                    GridReference(r.x, r.y + 1),
                )
            } else {
                listOf(
                    GridReference(r.x - 1, r.y - 1),
                    GridReference(r.x, r.y - 1),
                    GridReference(r.x + 1, r.y - 1),
                    GridReference(r.x - 1, r.y),
                    GridReference(r.x + 1, r.y),
                    GridReference(r.x - 1, r.y + 1),
                    GridReference(r.x, r.y + 1),
                    GridReference(r.x + 1, r.y + 1),
                )
            }.filter { r -> references.contains(r) }
            Cell(r, neighbours, SquareOctagon2GridCellPositioner)
        }

        return Grid(cells, BoundingBoxFactory.of(cells.values), xRange, yRange)
    }
}