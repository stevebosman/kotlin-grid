package uk.co.stevebosman.grid

import uk.co.stevebosman.grid.impl.regular.hex.HexGridGenerator
import uk.co.stevebosman.grid.impl.regular.hex.HexGridOption
import uk.co.stevebosman.grid.impl.regular.square.SquareGridGenerator
import uk.co.stevebosman.grid.impl.regular.triangle.TriangleGridGenerator
import uk.co.stevebosman.grid.impl.regular.triangle.TriangleGridHelper
import uk.co.stevebosman.grid.impl.regular.triangle.TriangleGridOption
import uk.co.stevebosman.grid.impl.uniform.elongatedTriangular.ElongatedTriangularCellType
import uk.co.stevebosman.grid.impl.uniform.elongatedTriangular.ElongatedTriangularGridGenerator
import uk.co.stevebosman.grid.impl.uniform.elongatedTriangular.ElongatedTriangularGridOption
import uk.co.stevebosman.grid.impl.uniform.rhombiTriHexagonal.RhombiTriHexagonalCellType
import uk.co.stevebosman.grid.impl.uniform.rhombiTriHexagonal.RhombiTriHexagonalGridGenerator
import uk.co.stevebosman.grid.impl.uniform.rhombiTriHexagonal.RhombiTriHexagonalGridOption
import uk.co.stevebosman.grid.impl.uniform.snubHexagonal.SnubHexagonalCellType
import uk.co.stevebosman.grid.impl.uniform.snubHexagonal.SnubHexagonalGridCellPositioner
import uk.co.stevebosman.grid.impl.uniform.snubHexagonal.SnubHexagonalGridGenerator
import uk.co.stevebosman.grid.impl.uniform.snubHexagonal.SnubHexagonalGridOption
import uk.co.stevebosman.grid.impl.uniform.squareOctagon2.SquareOctagon2GridGenerator
import uk.co.stevebosman.grid.impl.uniform.squareOctagon2.SquareOctagon2GridHelper
import uk.co.stevebosman.grid.impl.uniform.squareOctagon2.SquareOctagon2GridOption
import uk.co.stevebosman.grid.impl.uniform.triHexagonal.TriHexagonalCellType
import uk.co.stevebosman.grid.impl.uniform.triHexagonal.TriHexagonalGridGenerator
import uk.co.stevebosman.grid.impl.uniform.triHexagonal.TriHexagonalGridOption
import java.io.File

fun main() {
    generateSquareExamples()
    generateTriangleExamples()
    generateHexagonalExamples()
    generateTruncatedSquareExamples()
    generateTriHexagonalExamples()
    generateElongatedTriangularExamples()
    generateRhombiTriHexagonalExamples()
    generateSnubHexagonalExamples()
}

fun generateSquareExamples() {
    // Square Grid 5 x 5
    File("examples/square.svg").writeText(
        SquareGridGenerator.generate(5, 5)
            .toSvg(SvgOptions(fill = { r: GridReference -> if ((r.x + r.y) % 2 == 0) "gold" else "darkorange" }))
    )
}

fun generateTriangleExamples() {
    val triangularSvgOptions = SvgOptions(scaling = 35, fill = { r: GridReference ->
        if (TriangleGridHelper.isUp(r)) "darkorange" else "gold"
    })

    // Triangular Grid 7 x 4 - Standard
    File("examples/triangular.svg").writeText(
        TriangleGridGenerator.generate(7, 4, TriangleGridOption.STANDARD).toSvg(triangularSvgOptions)
    )
    // Triangular Grid 7 x 4 - Offset
    File("examples/triangular_offset.svg").writeText(
        TriangleGridGenerator.generate(7, 4, TriangleGridOption.OFFSET).toSvg(triangularSvgOptions)
    )
    // Triangular Grid 7 x 4 - Spiky
    File("examples/triangular_spiky.svg").writeText(
        TriangleGridGenerator.generate(7, 4, TriangleGridOption.SPIKY).toSvg(triangularSvgOptions)
    )
    // Triangular Grid 7 x 4 - Offset Spiky
    File("examples/triangular_offset_spiky.svg").writeText(
        TriangleGridGenerator.generate(
            7, 4, TriangleGridOption.OFFSET_SPIKY
        ).toSvg(triangularSvgOptions)
    )
    // Triangular Grid 4 x 5 - Triangle
    File("examples/triangular_triangle.svg").writeText(
        TriangleGridGenerator.generate(4, 5, TriangleGridOption.TRIANGLE).toSvg(triangularSvgOptions)
    )
}

private fun generateSnubHexagonalExamples() {
    val snubHexagonalSvgOptions = SvgOptions(
        fill = { r: GridReference ->
        when (SnubHexagonalCellType.of(r)) {
            SnubHexagonalCellType.Hexagon -> "greenyellow"
            SnubHexagonalCellType.TriangleLeft -> "darkorange"
            SnubHexagonalCellType.TriangleRight -> "gold"
        }
    })

    // Rhombi Tri Hexagonal Grid 3 x 3 - Singleton
    File("examples/snubHexagonal_singleton.svg").writeText(
        SnubHexagonalGridGenerator.generate(1, 1, SnubHexagonalGridOption.STANDARD)
            .toSvg(snubHexagonalSvgOptions)
    )
    // Rhombi Tri Hexagonal Grid 3 x 3 - Standard
    File("examples/snubHexagonal.svg").writeText(
        SnubHexagonalGridGenerator.generate(3, 3, SnubHexagonalGridOption.STANDARD)
            .toSvg(snubHexagonalSvgOptions)
    )
    // Rhombi Tri Hexagonal Grid 3 x 3 - Standard SKip Last
    File("examples/snubHexagonal_skip_last.svg").writeText(
        SnubHexagonalGridGenerator.generate(3, 3, SnubHexagonalGridOption.STANDARD_SKIP_LAST)
            .toSvg(snubHexagonalSvgOptions)
    )
    // Rhombi Tri Hexagonal Grid 3 x 3 - Triangle
    File("examples/snubHexagonal_triangle.svg").writeText(
        SnubHexagonalGridGenerator.generate(3, 3, SnubHexagonalGridOption.TRIANGLE)
            .toSvg(snubHexagonalSvgOptions)
    )
    // Rhombi Tri Hexagonal Grid 3 x 3 - Offset
    File("examples/snubHexagonal_offset.svg").writeText(
        SnubHexagonalGridGenerator.generate(3, 3, SnubHexagonalGridOption.OFFSET)
            .toSvg(snubHexagonalSvgOptions)
    )
    // Rhombi Tri Hexagonal Grid 3 x 3 - Offset Skip Last
    File("examples/snubHexagonal_offset_skip_last.svg").writeText(
        SnubHexagonalGridGenerator.generate(3, 3, SnubHexagonalGridOption.OFFSET_SKIP_LAST)
            .toSvg(snubHexagonalSvgOptions)
    )
}

private fun generateRhombiTriHexagonalExamples() {
    val rhombiTriHexagonalSvgOptions = SvgOptions(fill = { r: GridReference ->
        when (RhombiTriHexagonalCellType.of(r)) {
            RhombiTriHexagonalCellType.Hexagon, RhombiTriHexagonalCellType.TriangleDown, RhombiTriHexagonalCellType.TriangleUp -> "darkorange"
            RhombiTriHexagonalCellType.Square0, RhombiTriHexagonalCellType.Square30, RhombiTriHexagonalCellType.Square60 -> "gold"
        }
    })

    // Rhombi Tri Hexagonal Grid 3 x 3 - Singleton
    File("examples/rhombiTriHexagonal_singleton.svg").writeText(
        RhombiTriHexagonalGridGenerator.generate(1, 1, RhombiTriHexagonalGridOption.STANDARD)
            .toSvg(rhombiTriHexagonalSvgOptions)
    )
    // Rhombi Tri Hexagonal Grid 3 x 3 - Standard
    File("examples/rhombiTriHexagonal.svg").writeText(
        RhombiTriHexagonalGridGenerator.generate(3, 3, RhombiTriHexagonalGridOption.STANDARD)
            .toSvg(rhombiTriHexagonalSvgOptions)
    )
    // Rhombi Tri Hexagonal Grid 3 x 3 - Standard SKip Last
    File("examples/rhombiTriHexagonal_skip_last.svg").writeText(
        RhombiTriHexagonalGridGenerator.generate(3, 3, RhombiTriHexagonalGridOption.STANDARD_SKIP_LAST)
            .toSvg(rhombiTriHexagonalSvgOptions)
    )
    // Rhombi Tri Hexagonal Grid 3 x 3 - Triangle
    File("examples/rhombiTriHexagonal_triangle.svg").writeText(
        RhombiTriHexagonalGridGenerator.generate(3, 3, RhombiTriHexagonalGridOption.TRIANGLE)
            .toSvg(rhombiTriHexagonalSvgOptions)
    )
    // Rhombi Tri Hexagonal Grid 3 x 3 - Offset
    File("examples/rhombiTriHexagonal_offset.svg").writeText(
        RhombiTriHexagonalGridGenerator.generate(3, 3, RhombiTriHexagonalGridOption.OFFSET)
            .toSvg(rhombiTriHexagonalSvgOptions)
    )
    // Rhombi Tri Hexagonal Grid 3 x 3 - Offset Skip Last
    File("examples/rhombiTriHexagonal_offset_skip_last.svg").writeText(
        RhombiTriHexagonalGridGenerator.generate(3, 3, RhombiTriHexagonalGridOption.OFFSET_SKIP_LAST)
            .toSvg(rhombiTriHexagonalSvgOptions)
    )
}

private fun generateElongatedTriangularExamples() {
    val elongatedTriangularSvgOptions = SvgOptions(fill = { r: GridReference ->
        when (ElongatedTriangularCellType.of(r)) {
            ElongatedTriangularCellType.TriangleDown -> if (r.y % 4 == 2) "gold" else if (r.x % 4 == 0) "darkorange" else "greenyellow"

            ElongatedTriangularCellType.TriangleUp -> if (r.y % 4 == 0) "gold" else if (r.x % 4 == 0) "darkorange" else "greenyellow"

            ElongatedTriangularCellType.Square -> if (r.x % 4 == 0) (if (r.y % 4 == 3) "gold" else "greenyellow") else "darkorange"
        }
    })

    // Elongated Triangular Grid 12 x 9 - Start Triangles
    File("examples/elongated_triangular_start_triangles_full.svg").writeText(
        ElongatedTriangularGridGenerator.generate(12, 9, ElongatedTriangularGridOption.START_TRIANGLES_FULL)
            .toSvg(elongatedTriangularSvgOptions)
    )
    // Elongated Triangular Grid 12 x 9 - Start Triangles Spiky
    File("examples/elongated_triangular_start_triangles_spiky.svg").writeText(
        ElongatedTriangularGridGenerator.generate(12, 9, ElongatedTriangularGridOption.START_TRIANGLES_SPIKY)
            .toSvg(elongatedTriangularSvgOptions)
    )
    // Elongated Triangular Grid 12 x 9 - Start Squares
    File("examples/elongated_triangular_start_squares_full.svg").writeText(
        ElongatedTriangularGridGenerator.generate(12, 9, ElongatedTriangularGridOption.START_SQUARES_FULL)
            .toSvg(elongatedTriangularSvgOptions)
    )
    // Elongated Triangular Grid 12 x 9 - Start Squares Spiky
    File("examples/elongated_triangular_start_squares_spiky.svg").writeText(
        ElongatedTriangularGridGenerator.generate(12, 8, ElongatedTriangularGridOption.START_SQUARES_SPIKY)
            .toSvg(elongatedTriangularSvgOptions)
    )
}

private fun generateTriHexagonalExamples() {
    val triHexagonalSvgOptions = SvgOptions(fill = { r: GridReference ->
        when (TriHexagonalCellType.of(r)) {
            TriHexagonalCellType.TriangleUp, TriHexagonalCellType.TriangleDown -> "darkorange"
            TriHexagonalCellType.Hexagon -> "gold"
        }
    })

    // Tri Hexagonal Grid 7 x 5 - Start Hexagon
    File("examples/triHexagonal.svg").writeText(
        TriHexagonalGridGenerator.generate(
            7, 5, TriHexagonalGridOption.START_HEXAGON
        ).toSvg(triHexagonalSvgOptions)
    )
    // Tri Hexagonal Grid 7 x 5 - Start Triangles
    File("examples/triHexagonal_triangles.svg").writeText(
        TriHexagonalGridGenerator.generate(
            7, 5, TriHexagonalGridOption.START_TRIANGLES
        ).toSvg(triHexagonalSvgOptions)
    )
}

private fun generateTruncatedSquareExamples() {
    val truncatedSquareSvgOptions = SvgOptions(fill = { r: GridReference ->
        when {
            SquareOctagon2GridHelper.isSquareCell(r) -> "greenyellow"
            (r.y % 2 == 0) -> "darkorange"
            else -> "gold"
        }
    })

    // Truncated Square Grid 5 x 5 - Start Octagon
    File("examples/truncated_square_start_octagon.svg").writeText(
        SquareOctagon2GridGenerator.generate(
            5, 5, SquareOctagon2GridOption.START_OCTAGON
        ).toSvg(truncatedSquareSvgOptions)
    )
    // Truncated Square Grid 5 x 5 - Start Square
    File("examples/truncated_square_start_square.svg").writeText(
        SquareOctagon2GridGenerator.generate(
            5, 5, SquareOctagon2GridOption.START_SQUARE
        ).toSvg(truncatedSquareSvgOptions)
    )
}

private fun generateHexagonalExamples() {
    val hexagonalSvgOptions = SvgOptions(fill = { r: GridReference ->
        when ((3 + r.x - r.y % 2) % 3) {
            0 -> "greenyellow"
            1 -> "gold"
            else -> "darkorange"
        }
    })

    // Hex Grid 5 x 5 - Standard
    File("examples/hexagonal_standard.svg").writeText(
            HexGridGenerator.generate(5, 5, HexGridOption.STANDARD).toSvg(hexagonalSvgOptions)
        )
    // Hex Grid 5 x 5 - Standard Skip Last
    File("examples/hexagonal_standard_skip_last.svg").writeText(
        HexGridGenerator.generate(
            5, 5, HexGridOption.STANDARD_SKIP_LAST
        ).toSvg(hexagonalSvgOptions)
    )
    // Hex Grid 5 x 5 - Offset
    File("examples/hexagonal_offset.svg").writeText(
        HexGridGenerator.generate(5, 5, HexGridOption.OFFSET).toSvg(hexagonalSvgOptions)
    )
    // Hex Grid 5 x 5 - Offset Skip Last
    File("examples/hexagonal_offset_skip_last.svg").writeText(
        HexGridGenerator.generate(
            5, 5, HexGridOption.OFFSET_SKIP_LAST
        ).toSvg(hexagonalSvgOptions)
    )
    // Hex Grid 5 x 5 - Triangle
    File("examples/hexagonal_triangle.svg").writeText(
        HexGridGenerator.generate(5, 5, HexGridOption.TRIANGLE).toSvg(hexagonalSvgOptions)
    )
}
