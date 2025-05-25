package uk.co.stevebosman.grid.impl.regular.triangle

import uk.co.stevebosman.grid.GridReference

object TriangleGridHelper {
    fun isUp(gridReference: GridReference): Boolean = (gridReference.x + gridReference.y) % 2 == 0
}