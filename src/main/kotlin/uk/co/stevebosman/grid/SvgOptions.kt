package uk.co.stevebosman.grid

data class SvgOptions(
    val scaling: Int = 25,
    val border: Int = 5,
    val showXIndex: Boolean = false,
    val showYIndex: Boolean = false,
    val lineColour: String = "black",
    val lineCap: String = "round",
    val lineWidth: Int = 1,
    val fill: (GridReference) -> String = { r -> "none" }
)
