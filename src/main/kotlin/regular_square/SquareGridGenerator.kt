package uk.co.stevebosman.grid.regular_square

import uk.co.stevebosman.grid.Cell
import uk.co.stevebosman.grid.Grid
import uk.co.stevebosman.grid.GridReference

class SquareGridGenerator {
    fun generate(width: Int, height: Int): Grid {
        val references = mutableListOf<GridReference>()
        (0..width - 1).forEach { x ->
            (0..height - 1).forEach { y ->
                references.add(GridReference(x, y))
            }
        }
        val positioner = SquareGridCellPositioner()
        val cells = references.associateWith { r ->
            val neighbours = listOf(
                GridReference(r.x, r.y - 1),
                GridReference(r.x - 1, r.y),
                GridReference(r.x + 1, r.y),
                GridReference(r.x, r.y + 1)
            ).filter { r -> r.x >= 0 && r.y >= 0 && r.x < width && r.y < height }
            Cell(r, neighbours, positioner)
        }

        return Grid(cells)
    }
}