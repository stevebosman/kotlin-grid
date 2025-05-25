package uk.co.stevebosman.grid.impl.uniform.squareOctagon2

import uk.co.stevebosman.grid.GridReference

object SquareOctagon2GridHelper {
    fun isSquareCell(r: GridReference): Boolean = (r.x + r.y) % 2 == 0
}