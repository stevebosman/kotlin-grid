package uk.co.stevebosman.grid.impl.uniform.snubHexagonal

import uk.co.stevebosman.grid.GridReference

enum class SnubHexagonalCellType {
    TriangleLeft, TriangleRight, Hexagon;

    companion object {
        fun of(position: GridReference): SnubHexagonalCellType {
            return when (position.y % 4) {
                0 -> if (position.x % 2 == 0) TriangleLeft else TriangleRight

                1 -> when (position.x % 6) {
                    0 -> TriangleRight
                    1 -> TriangleLeft
                    2 -> Hexagon
                    else -> throw IllegalStateException("Impossible position: ${position}")
                }

                2 -> if (position.x % 2 == 0) TriangleRight else TriangleLeft

                else -> when (position.x % 6) {
                    3 -> TriangleRight
                    4 -> TriangleLeft
                    5 -> Hexagon
                    else -> throw IllegalStateException("Impossible position: ${position}")
                }
            }
        }
    }
}