package uk.co.stevebosman.grid

import uk.co.stevebosman.grid.impl.regular.hex.HexGridGenerator
import uk.co.stevebosman.grid.impl.regular.hex.HexGridOption
import uk.co.stevebosman.grid.impl.regular.square.SquareGridGenerator
import uk.co.stevebosman.grid.impl.regular.triangle.TriangleGridGenerator
import uk.co.stevebosman.grid.impl.regular.triangle.TriangleGridOption
import uk.co.stevebosman.grid.impl.uniform.elongatedTriangular.ElongatedTriangularGridGenerator
import uk.co.stevebosman.grid.impl.uniform.elongatedTriangular.ElongatedTriangularGridOption
import uk.co.stevebosman.grid.impl.uniform.rhombiTriHexagonal.RhombiTriHexagonalGridGenerator
import uk.co.stevebosman.grid.impl.uniform.rhombiTriHexagonal.RhombiTriHexagonalGridOption
import uk.co.stevebosman.grid.impl.uniform.squareOctagon2.SquareOctagon2GridGenerator
import uk.co.stevebosman.grid.impl.uniform.squareOctagon2.SquareOctagon2GridOption
import uk.co.stevebosman.grid.impl.uniform.triHexagonal.TriHexagonalGridGenerator
import uk.co.stevebosman.grid.impl.uniform.triHexagonal.TriHexagonalGridOption
import java.io.File

fun main() {
    // Square Grid 5 x 5
    File("examples/square.svg").writeText(SquareGridGenerator.generate(5, 5).toSvg())

    // Triangular Grid 7 x 4 - Standard
    File("examples/triangular.svg").writeText(
        TriangleGridGenerator.generate(7, 4, TriangleGridOption.STANDARD).toSvg(35)
    )
    // Triangular Grid 7 x 4 - Offset
    File("examples/triangular_offset.svg").writeText(
        TriangleGridGenerator.generate(7, 4, TriangleGridOption.OFFSET).toSvg(35)
    )
    // Triangular Grid 7 x 4 - Spiky
    File("examples/triangular_spiky.svg").writeText(
        TriangleGridGenerator.generate(7, 4, TriangleGridOption.SPIKY).toSvg(35)
    )
    // Triangular Grid 7 x 4 - Offset Spiky
    File("examples/triangular_offset_spiky.svg").writeText(
        TriangleGridGenerator.generate(
            7,
            4,
            TriangleGridOption.OFFSET_SPIKY
        ).toSvg(35)
    )
    // Triangular Grid 4 x 5 - Triangle
    File("examples/triangular_triangle.svg").writeText(
        TriangleGridGenerator.generate(4, 5, TriangleGridOption.TRIANGLE).toSvg(35)
    )

    // Hex Grid 5 x 5 - Standard
    File("examples/hexagonal_standard.svg")
        .writeText(HexGridGenerator.generate(5, 5, HexGridOption.STANDARD).toSvg())
    // Hex Grid 5 x 5 - Standard Skip Last
    File("examples/hexagonal_standard_skip_last.svg").writeText(
        HexGridGenerator.generate(
            5,
            5,
            HexGridOption.STANDARD_SKIP_LAST
        ).toSvg()
    )
    // Hex Grid 5 x 5 - Offset
    File("examples/hexagonal_offset.svg").writeText(HexGridGenerator.generate(5, 5, HexGridOption.OFFSET).toSvg())
    // Hex Grid 5 x 5 - Offset Skip Last
    File("examples/hexagonal_offset_skip_last.svg").writeText(
        HexGridGenerator.generate(
            5,
            5,
            HexGridOption.OFFSET_SKIP_LAST
        ).toSvg()
    )
    // Hex Grid 5 x 5 - Triangle
    File("examples/hexagonal_triangle.svg").writeText(HexGridGenerator.generate(5, 5, HexGridOption.TRIANGLE).toSvg())

    // Truncated Square Grid 5 x 5 - Start Octagon
    File("examples/truncated_square_start_octagon.svg").writeText(
        SquareOctagon2GridGenerator.generate(
            5,
            5,
            SquareOctagon2GridOption.START_OCTAGON
        ).toSvg()
    )
    // Truncated Square Grid 5 x 5 - Start Square
    File("examples/truncated_square_start_square.svg").writeText(
        SquareOctagon2GridGenerator.generate(
            5,
            5,
            SquareOctagon2GridOption.START_SQUARE
        ).toSvg()
    )

    // Tri Hexagonal Grid 7 x 5 - Start Hexagon
    File("examples/trihexagonal.svg").writeText(
        TriHexagonalGridGenerator.generate(
            7,
            5,
            TriHexagonalGridOption.START_HEXAGON
        ).toSvg()
    )
    // Tri Hexagonal Grid 7 x 5 - Start Triangles
    File("examples/trihexagonal_triangles.svg").writeText(
        TriHexagonalGridGenerator.generate(
            7,
            5,
            TriHexagonalGridOption.START_TRIANGLES
        ).toSvg()
    )
    // Tri Hexagonal Grid 7 x 5 - Start Triangles
    File("examples/elongated_triangular_start_triangles_full.svg").writeText(
        ElongatedTriangularGridGenerator.generate(12, 9, ElongatedTriangularGridOption.START_TRIANGLES_FULL).toSvg()
    )
    // Tri Hexagonal Grid 7 x 5 - Start Triangles
    File("examples/elongated_triangular_start_triangles_spiky.svg").writeText(
        ElongatedTriangularGridGenerator.generate(12, 9, ElongatedTriangularGridOption.START_TRIANGLES_SPIKY).toSvg()
    )
    // Tri Hexagonal Grid 7 x 5 - Start Triangles
    File("examples/elongated_triangular_start_squares_full.svg").writeText(
        ElongatedTriangularGridGenerator.generate(12, 9, ElongatedTriangularGridOption.START_SQUARES_FULL).toSvg()
    )
    // Tri Hexagonal Grid 7 x 5 - Start Triangles
    File("examples/elongated_triangular_start_squares_spiky.svg").writeText(
        ElongatedTriangularGridGenerator.generate(12, 8, ElongatedTriangularGridOption.START_SQUARES_SPIKY).toSvg()
    )

    // Rhombi Tri Hexagonal Grid 3 x 3 - Singleton
    File("examples/rhombiTrihexagonal_singleton.svg").writeText(
        RhombiTriHexagonalGridGenerator.generate(1, 1, RhombiTriHexagonalGridOption.STANDARD).toSvg()
    )
    // Rhombi Tri Hexagonal Grid 3 x 3 - Standard
    File("examples/rhombiTrihexagonal.svg").writeText(
        RhombiTriHexagonalGridGenerator.generate(3, 3, RhombiTriHexagonalGridOption.STANDARD).toSvg()
    )
    // Rhombi Tri Hexagonal Grid 3 x 3 - Standard SKip Last
    File("examples/rhombiTrihexagonal_skip_last.svg").writeText(
        RhombiTriHexagonalGridGenerator.generate(3, 3, RhombiTriHexagonalGridOption.STANDARD_SKIP_LAST).toSvg()
    )
    // Rhombi Tri Hexagonal Grid 3 x 3 - Triangle
    File("examples/rhombiTrihexagonal_triangle.svg").writeText(
        RhombiTriHexagonalGridGenerator.generate(3, 3, RhombiTriHexagonalGridOption.TRIANGLE).toSvg()
    )
    // Rhombi Tri Hexagonal Grid 3 x 3 - Offset
    File("examples/rhombiTrihexagonal_offset.svg").writeText(
        RhombiTriHexagonalGridGenerator.generate(3, 3, RhombiTriHexagonalGridOption.OFFSET).toSvg()
    )
    // Rhombi Tri Hexagonal Grid 3 x 3 - Offset Skip Last
    File("examples/rhombiTrihexagonal_offset_skip_last.svg").writeText(
        RhombiTriHexagonalGridGenerator.generate(3, 3, RhombiTriHexagonalGridOption.OFFSET_SKIP_LAST).toSvg()
    )
}
