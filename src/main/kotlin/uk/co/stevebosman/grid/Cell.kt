package uk.co.stevebosman.grid

import lombok.EqualsAndHashCode
import lombok.ToString
import uk.co.stevebosman.geometry.Circle
import uk.co.stevebosman.geometry.Point

@EqualsAndHashCode
@ToString
class Cell(
    val gridReference: GridReference,
    val neighbours: List<GridReference>,
    @ToString.Exclude
    private val cellPositioner: CellPositioner
) {
    fun getVertices(): List<Point> {
        return cellPositioner.getVertices(gridReference)
    }

    fun getInscribedCircle(): Circle {
        return cellPositioner.getInscribedCircle(gridReference)
    }
}