package uk.co.stevebosman.grid

import uk.co.stevebosman.geometry.Point
import uk.co.stevebosman.geometry.Rectangle

object BoundingBoxFactory {
    fun of(cells: Collection<Cell>): Rectangle {
        val flatMap: List<Point> = cells.flatMap { it.getPolygon().vertices }
        var lowerLeft: Point = flatMap.first()
        var upperRight: Point = flatMap.first()
        flatMap.forEach { (x, y) ->
            if (x < lowerLeft.x) lowerLeft = Point(x, lowerLeft.y)
            if (y < lowerLeft.y) lowerLeft = Point(lowerLeft.x, y)
            if (x > upperRight.x) upperRight = Point(x, upperRight.y)
            if (y > upperRight.y) upperRight = Point(upperRight.x, y)
        }
        return Rectangle(lowerLeft, upperRight.x - lowerLeft.x, upperRight.y - lowerLeft.y)
    }
}