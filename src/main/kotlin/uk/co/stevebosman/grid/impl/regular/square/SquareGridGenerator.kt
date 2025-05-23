package uk.co.stevebosman.grid.impl.regular.square

import uk.co.stevebosman.grid.BoundingBoxFactory
import uk.co.stevebosman.grid.Cell
import uk.co.stevebosman.grid.Grid
import uk.co.stevebosman.grid.GridReference

object SquareGridGenerator {
    fun generate(width: Int, height: Int): Grid {
        val references = mutableListOf<GridReference>()
        (0..width - 1).forEach { x ->
            (0..height - 1).forEach { y ->
                references.add(GridReference(x, y))
            }
        }
        val cells = references.associateWith { r ->
            val neighbours = listOf(
                GridReference(r.x, r.y - 1),
                GridReference(r.x - 1, r.y),
                GridReference(r.x + 1, r.y),
                GridReference(r.x, r.y + 1)
            ).filter { r -> references.contains(r) }
            Cell(r, neighbours, SquareGridCellPositioner)
        }

        return Grid(cells, BoundingBoxFactory.of(cells.values))
    }

}