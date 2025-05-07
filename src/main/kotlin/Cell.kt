package uk.co.stevebosman.grid

class Cell(
    val gridReference: GridReference,
    val neighbours: List<GridReference>,
    private val cellPositioner: CellPositioner
) {
    fun getVertices(): List<Point> {
        return cellPositioner.getVertices(gridReference)
    }
}