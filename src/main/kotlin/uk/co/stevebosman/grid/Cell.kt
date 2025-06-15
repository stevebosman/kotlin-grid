package uk.co.stevebosman.grid

import lombok.EqualsAndHashCode
import uk.co.stevebosman.maths.geometry.Circle
import uk.co.stevebosman.maths.geometry.Polygon

@EqualsAndHashCode
class Cell(
    val gridReference: GridReference,
    val neighbours: List<GridReference>,
    private val cellPositioner: CellPositioner
) {
    fun getPolygon(): Polygon {
        return cellPositioner.getPolygon(gridReference)
    }

    fun getInscribedCircle(): Circle {
        return cellPositioner.getInscribedCircle(gridReference)
    }

    override fun toString(): String {
        return "Cell(gridReference=$gridReference, neighbours=$neighbours)"
    }
}