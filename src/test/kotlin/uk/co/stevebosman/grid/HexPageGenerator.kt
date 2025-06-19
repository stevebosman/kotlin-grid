package uk.co.stevebosman.grid

import uk.co.stevebosman.grid.impl.regular.hex.HexGridGenerator
import uk.co.stevebosman.grid.impl.regular.hex.HexGridOption
import uk.co.stevebosman.grid.svg.GridSvg.toSvg
import java.io.File

fun main() {
    val hexagonalSvgOptions = SvgOptions(borderColour = "black")

    File("examples/pages/hex_30_25.svg").writeText(
        HexGridGenerator.generate(30, 25, HexGridOption.STANDARD_SKIP_LAST).toSvg(hexagonalSvgOptions)
    )
    File("examples/pages/hex_20_17.svg").writeText(
        HexGridGenerator.generate(20, 17, HexGridOption.STANDARD_SKIP_LAST).toSvg(hexagonalSvgOptions)
    )
    File("examples/pages/hex_10_9.svg").writeText(
        HexGridGenerator.generate(10, 9, HexGridOption.STANDARD_SKIP_LAST).toSvg(hexagonalSvgOptions)
    )
}
