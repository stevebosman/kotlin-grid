package uk.co.stevebosman.grid

interface CellPositioner {
    fun getVertices(gridReference: GridReference): List<Point>
}