package uk.co.stevebosman.grid

import lombok.EqualsAndHashCode
import uk.co.stevebosman.geometry.Circle
import uk.co.stevebosman.geometry.Point

@EqualsAndHashCode
class Cell(
    val gridReference: GridReference,
    val neighbours: List<GridReference>,
    private val cellPositioner: CellPositioner
) {
    fun getVertices(): List<Point> {
        return cellPositioner.getVertices(gridReference)
    }

    fun getInscribedCircle(): Circle {
        return cellPositioner.getInscribedCircle(gridReference)
    }

    override fun toString(): String {
        return "Cell(gridReference=$gridReference, neighbours=$neighbours)"
    }
}