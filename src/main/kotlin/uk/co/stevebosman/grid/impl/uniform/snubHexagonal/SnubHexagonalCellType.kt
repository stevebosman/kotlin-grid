package uk.co.stevebosman.grid.impl.uniform.snubHexagonal

import uk.co.stevebosman.grid.GridReference

enum class SnubHexagonalCellType {
    TriangleDown, TriangleUp, Hexagon, Square0, Square30, Square60;

    companion object {
        fun of(position: GridReference): SnubHexagonalCellType {
            return when (position.y % 4) {
                0 -> when (position.x % 4) {
                    0 -> TriangleUp
                    1 -> Square60
                    2 -> TriangleDown
                    else -> Square30
                }

                1 -> when (position.x % 4) {
                    0 -> Square0
                    1 -> Hexagon
                    else -> throw IllegalStateException("Impossible position: ${position}")
                }

                2 -> when (position.x % 4) {
                    0 -> TriangleDown
                    1 -> Square30
                    2 -> TriangleUp
                    else -> Square60
                }

                else -> when (position.x % 4) {
                    2 -> Square0
                    3 -> Hexagon
                    else -> throw IllegalStateException("Impossible position: ${position}")
                }
            }
        }
    }
}