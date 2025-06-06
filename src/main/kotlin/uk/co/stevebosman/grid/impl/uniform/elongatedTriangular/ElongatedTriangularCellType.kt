package uk.co.stevebosman.grid.impl.uniform.elongatedTriangular

import uk.co.stevebosman.grid.GridReference

enum class ElongatedTriangularCellType {
    TriangleUp, TriangleDown, Square;

    companion object {
        fun of(position: GridReference): ElongatedTriangularCellType =
            if (position.y%2 == 1) {
                Square
            } else if ((position.x%2 == 0 && position.y%4 == 0) || (position.x%2 == 1 && position.y%4 == 2)) {
                TriangleUp
            } else {
                TriangleDown
            }
    }
}