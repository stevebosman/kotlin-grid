package uk.co.stevebosman.geometry

data class Polygon(
    val sideCount: Int,
    val size: Double,
    val circumradius: Double,
    val apothem: Double,
    val centre: Point,
    val vertices: List<Point>
)