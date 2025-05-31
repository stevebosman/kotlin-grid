package uk.co.stevebosman.grid.impl.uniform.triHexagonal

import uk.co.stevebosman.grid.GridReference

enum class TriHexagonalCellType {
    TriangleUp, TriangleDown, Hexagon;

    companion object {
        fun of(position: GridReference): TriHexagonalCellType {
            return if (position.y % 2 == 0)
                when (position.x % 3) {
                    1 -> TriangleUp
                    2 -> TriangleDown
                    else -> Hexagon
                }
            else
                when (position.x % 3) {
                    0 -> TriangleUp
                    1 -> TriangleDown
                    else -> Hexagon
                }
        }
    }
}