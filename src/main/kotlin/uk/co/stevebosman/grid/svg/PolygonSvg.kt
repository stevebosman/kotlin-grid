package uk.co.stevebosman.grid.svg

import uk.co.stevebosman.grid.SvgOptions
import uk.co.stevebosman.maths.geometry.Point
import uk.co.stevebosman.maths.geometry.Polygon

object PolygonSvg {
    fun Polygon.toSvgPolygon(
        options: SvgOptions,
        fillColor: String,
        coordinator: (Point) -> String
    ):String {
        val result = StringBuilder()
        result.append("<polygon")
        result.append(" points=\"${this.vertices.joinToString(" ") { v -> coordinator(v) }}\"")
        result.append(" stroke=\"${options.lineColour}\"")
        result.append(" stroke-linecap=\"${options.lineCap}\"")
        result.append(" stroke-width=\"${options.lineWidth}\"")
        result.append(" fill=\"$fillColor\"")
        result.append("/>\n")
        return result.toString()
    }
}