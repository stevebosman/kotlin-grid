package uk.co.stevebosman.grid

import uk.co.stevebosman.geometry.Rectangle

data class Grid(
    val cells: Map<GridReference, Cell>,
    val boundingBox: Rectangle,
    val xRange: IntRange,
    val yRange: IntRange
)