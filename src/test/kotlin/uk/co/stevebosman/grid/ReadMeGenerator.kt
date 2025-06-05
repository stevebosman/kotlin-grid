package uk.co.stevebosman.grid

import uk.co.stevebosman.grid.impl.regular.hex.HexGridGenerator
import uk.co.stevebosman.grid.impl.regular.hex.HexGridOption
import uk.co.stevebosman.grid.impl.regular.square.SquareGridGenerator
import uk.co.stevebosman.grid.impl.regular.triangle.TriangleGridGenerator
import uk.co.stevebosman.grid.impl.regular.triangle.TriangleGridOption
import uk.co.stevebosman.grid.impl.uniform.squareOctagon2.SquareOctagon2GridGenerator
import uk.co.stevebosman.grid.impl.uniform.squareOctagon2.SquareOctagon2GridOption
import uk.co.stevebosman.grid.impl.uniform.triHexagonal.TriHexagonalGridGenerator
import uk.co.stevebosman.grid.impl.uniform.triHexagonal.TriHexagonalGridOption

fun main() {
    println("Square Grid 5 x 5")
    println(SquareGridGenerator.generate(5,5).toSvg());

    println("\nTriangular Grid 7 x 4 - Standard")
    println(TriangleGridGenerator.generate(7,4, TriangleGridOption.STANDARD).toSvg(35));
    println("\nTriangular Grid 7 x 4 - Offset")
    println(TriangleGridGenerator.generate(7,4, TriangleGridOption.OFFSET).toSvg(35));
    println("\nTriangular Grid 7 x 4 - Spiky")
    println(TriangleGridGenerator.generate(7,4, TriangleGridOption.SPIKY).toSvg(35));
    println("\nTriangular Grid 7 x 4 - Offset Spiky")
    println(TriangleGridGenerator.generate(7,4, TriangleGridOption.OFFSET_SPIKY).toSvg(35));
    println("\nTriangular Grid 4 x 5 - Triangle")
    println(TriangleGridGenerator.generate(4,5, TriangleGridOption.TRIANGLE).toSvg(35));

    println("\nHex Grid 5 x 5 - Standard")
    println(HexGridGenerator.generate(5,5, HexGridOption.STANDARD).toSvg());
    println("\nHex Grid 5 x 5 - Standard Skip Last")
    println(HexGridGenerator.generate(5,5, HexGridOption.STANDARD_SKIP_LAST).toSvg());
    println("\nHex Grid 5 x 5 - Offset")
    println(HexGridGenerator.generate(5,5, HexGridOption.OFFSET).toSvg());
    println("\nHex Grid 5 x 5 - Offset Skip Last")
    println(HexGridGenerator.generate(5,5, HexGridOption.OFFSET_SKIP_LAST).toSvg());
    println("\nHex Grid 5 x 5 - Triangle")
    println(HexGridGenerator.generate(5,5, HexGridOption.TRIANGLE).toSvg());

    println("\nTruncated Square Grid 5 x 5 - Start Octagon")
    println(SquareOctagon2GridGenerator.generate(5,5, SquareOctagon2GridOption.START_OCTAGON).toSvg());
    println("\nTruncated Square Grid 5 x 5 - Start Square")
    println(SquareOctagon2GridGenerator.generate(5,5, SquareOctagon2GridOption.START_SQUARE).toSvg());

    println("\nTri Hexagonal Grid 7 x 5 - Start Hexagon")
    println(TriHexagonalGridGenerator.generate(7,5, TriHexagonalGridOption.START_HEXAGON).toSvg());
    println("\nTri Hexagonal Grid 7 x 5 - Start Triangles")
    println(TriHexagonalGridGenerator.generate(7,5, TriHexagonalGridOption.START_TRIANGLES).toSvg());
}
