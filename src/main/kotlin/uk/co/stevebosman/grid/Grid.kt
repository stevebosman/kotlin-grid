package uk.co.stevebosman.grid

import uk.co.stevebosman.maths.geometry.Point
import uk.co.stevebosman.maths.geometry.Rectangle

data class Grid(
    val cells: Map<GridReference, Cell>,
    val boundingBox: Rectangle,
    val xRange: IntRange,
    val yRange: IntRange
) {
    fun toSvg(options: SvgOptions = SvgOptions()): String {
        fun adjustedX(v: Point): Double = options.border + options.scaling * (v.x - boundingBox.lowerLeft.x)

        fun adjustedY(v: Point): Double = options.border + options.scaling * (v.y - boundingBox.lowerLeft.y)

        fun coordinates(v: Point): String =
            "${adjustedX(v)},${adjustedY(v)}"

        val result = StringBuilder()
        result.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n")
        result.append("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n")
        result.append("<svg width=\"${options.scaling * boundingBox.width + 2 * options.border}\" height=\"${options.scaling * boundingBox.height + 2 * options.border}\"")
        result.append(" viewBox=\"0 0 ${2 * options.border + options.scaling * boundingBox.width} ${2 * options.border + options.scaling * boundingBox.height}\"")
        result.append(" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n")
        if (options.showXIndex || options.showYIndex) {
            result.append("    <style>.coordinates {font: italic ${options.scaling / 5}px sans-serif;}</style>\n")
        }

        cells.values.forEach { c ->
            val polygon = c.getPolygon()
            result.append("    <polygon")
            result.append(" points=\"${polygon.vertices.joinToString(" ") { v -> coordinates(v) }}\"")
            result.append(" stroke=\"${options.lineColour}\"")
            result.append(" stroke-linecap=\"${options.lineCap}\"")
            result.append(" stroke-width=\"${options.lineWidth}\"")
            result.append(" fill=\"${options.fill(c.gridReference)}\"")
            result.append("/>\n")
            if (options.showXIndex || options.showYIndex) {
                result.append("   <text x=\"${adjustedX(polygon.centre) - options.scaling / 5}\" y=\"${adjustedY(polygon.centre)}\" class=\"coordinates\">")
                if (options.showXIndex) result.append("${c.gridReference.x}")
                if (options.showXIndex && options.showYIndex) result.append(",")
                if (options.showYIndex) result.append("${c.gridReference.y}")
                result.append("</text>\n")
            }
        }
        result.append("</svg>\n")
        return result.toString()
    }
}