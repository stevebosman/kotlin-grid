package uk.co.stevebosman.maths.geometry

data class Point(val x: Double, val y: Double) {
    fun translate(offset: Point) = Point(x + offset.x, y + offset.y)
    fun rescale(scale: Double) = Point(x * scale, y * scale)
    fun rescaleAndTranslate(scale: Double, offset: Point): Point {
        return Point(scale * x + offset.x, scale * y + offset.y)
    }
}