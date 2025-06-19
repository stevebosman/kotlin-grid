package uk.co.stevebosman.grid.svg

import uk.co.stevebosman.grid.Grid
import uk.co.stevebosman.grid.SvgOptions
import uk.co.stevebosman.grid.svg.PolygonSvg.toSvgPolygon
import uk.co.stevebosman.maths.geometry.Point

object GridSvg {
    fun Grid.toSvg(options: SvgOptions = SvgOptions()): String {
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
        if (options.borderColour!=null) {
            val borderVertices: List<Point> = listOf(
                boundingBox.lowerLeft,
                Point(boundingBox.lowerLeft.x, boundingBox.lowerLeft.y + boundingBox.height),
                Point(boundingBox.lowerLeft.x + boundingBox.width, boundingBox.lowerLeft.y + boundingBox.height),
                Point(boundingBox.lowerLeft.x + boundingBox.width, boundingBox.lowerLeft.y),
            )
            result.append("    <polygon")
            result.append(" points=\"${borderVertices.joinToString(" ") { v -> coordinates(v) }}\"")
            result.append(" fill=\"white\"")
            result.append(" stroke=\"${options.borderColour}\"")
            result.append(" stroke-linecap=\"${options.lineCap}\"")
            result.append(" stroke-width=\"${options.lineWidth}\"")
            result.append("/>\n")
        }

        cells.values.forEach { c ->
            val polygon = c.getPolygon()
            result.append("    ${polygon.toSvgPolygon(options, options.fill(c.gridReference), { v -> coordinates(v) })}")
            if (options.showCentre) {
                result.append(
                    "<circle r=\"${1 + options.scaling / 10.0}\" cx=\"${adjustedX(polygon.centre)}\" cy=\"${
                        adjustedY(
                            polygon.centre
                        )
                    }\" fill=\"white\" />"
                )
            }
            if (options.showXIndex || options.showYIndex) {
                result.append(
                    "   <text fill=\"black\" x=\"${adjustedX(polygon.centre) - options.scaling / 5}\" y=\"${
                        adjustedY(
                            polygon.centre
                        )
                    }\" class=\"coordinates\">"
                )
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