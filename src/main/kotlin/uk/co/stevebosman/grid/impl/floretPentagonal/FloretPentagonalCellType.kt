package uk.co.stevebosman.grid.impl.floretPentagonal

import uk.co.stevebosman.grid.GridReference

enum class FloretPentagonalCellType(val angle: Double) {

    Hexagon0(120.0),
    Hexagon60(180.0),
    Hexagon120(240.0),
    Hexagon180(60.0),
    Hexagon240(0.0),
    Hexagon300(300.0);

    companion object {
        fun of(position: GridReference): FloretPentagonalCellType {
            return when (position.y % 2) {
                0 -> FloretPentagonalCellType.entries[position.x % 3]
                else -> FloretPentagonalCellType.entries[3 + position.x % 3]
            }
        }
    }
}