package uk.co.stevebosman.grid

class Cell(
    val gridReference: GridReference,
    val neighbours: List<GridReference>,
    private val cellPositioner: CellPositioner
) {
    fun getVertices(): List<Point> {
        return cellPositioner.getVertices(gridReference)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cell

        if (gridReference != other.gridReference) return false
        if (neighbours != other.neighbours) return false

        return true
    }

    override fun hashCode(): Int {
        var result = gridReference.hashCode()
        result = 31 * result + neighbours.hashCode()
        return result
    }

    override fun toString(): String {
        return "Cell(gridReference=$gridReference, neighbours=$neighbours"
    }
}