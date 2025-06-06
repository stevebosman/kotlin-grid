package uk.co.stevebosman.grid

import uk.co.stevebosman.geometry.Point
import uk.co.stevebosman.geometry.Rectangle

data class Grid(
    val cells: Map<GridReference, Cell>,
    val boundingBox: Rectangle,
    val xRange: IntRange,
    val yRange: IntRange
) {
    fun toSvg(scaling: Int = 25, border: Int = 5, showXIndex: Boolean = false, showYIndex: Boolean = false): String {
        fun adjustedX(v: Point): Double = border + scaling * (v.x - boundingBox.lowerLeft.x)

        fun adjustedY(v: Point): Double = border + scaling * (v.y - boundingBox.lowerLeft.y)

        fun coordinates(v: Point): String =
            "${adjustedX(v)},${adjustedY(v)}"

        val result = StringBuilder()
        result.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n")
        result.append("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n")
        result.append("<svg width=\"${scaling * boundingBox.width + 2 * border}\" height=\"${scaling * boundingBox.height + 2 * border}\"")
        result.append(" viewBox=\"0 0 ${2 * border + scaling * boundingBox.width} ${2 * border + scaling * boundingBox.height}\"")
        result.append(" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n")
        if (showXIndex || showYIndex) {
            result.append("    <style>.small {font: italic ${scaling/5}px sans-serif;}</style>")
        }

        cells.values.forEach { c ->
            val polygon = c.getPolygon()
            result.append("    <polyline points=\"")
            result.append(polygon.vertices.joinToString(" ") { v -> coordinates(v) })
            result.append(" " + coordinates(polygon.vertices.first()))
            result.append("\" stroke=\"red\" stroke-linecap=\"round\" stroke-width=\"2\" fill=\"none\" />\n")
            if (showXIndex || showYIndex) {
                result.append("   <text x=\"${adjustedX(polygon.centre)-scaling/5}\" y=\"${adjustedY(polygon.centre)}\" class=\"small\">")
                if (showXIndex) result.append("${c.gridReference.x}")
                if (showXIndex&&showYIndex) result.append(",")
                if (showYIndex) result.append("${c.gridReference.y}")
                result.append("</text>")
            }
        }
        result.append("</svg>\n")
        return result.toString()
    }
}