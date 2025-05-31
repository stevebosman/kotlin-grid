package uk.co.stevebosman.grid.impl.uniform.triHexagonal

import uk.co.stevebosman.grid.BoundingBoxFactory
import uk.co.stevebosman.grid.Cell
import uk.co.stevebosman.grid.Grid
import uk.co.stevebosman.grid.GridReference
import kotlin.math.max

object TriHexagonalGridGenerator {
    fun generate(
        width: Int,
        height: Int,
        option: TriHexagonalGridOption = TriHexagonalGridOption.START_HEXAGON
    ): Grid {
        val references = mutableListOf<GridReference>()
        val secondCount = (width / 2)
        val firstCount = width - secondCount

        val trueWidthEven = firstCount + 2 * secondCount - 1
        val trueWidthOdd = 2 * firstCount + secondCount - 1
        val xRangeEven = (0..trueWidthEven)
        val xRangeOdd = (0..trueWidthOdd)
        val yRange = when (option) {
            TriHexagonalGridOption.START_HEXAGON -> (0..height - 1)
            TriHexagonalGridOption.START_TRIANGLES -> (1..height)
        }

        yRange.forEach { y ->
            if (y % 2 == 0)
                xRangeEven.forEach { x ->
                    references.add(GridReference(x, y))
                }
            else
                xRangeOdd.forEach { x ->
                    references.add(GridReference(x, y))
                }
        }

        val cells = references.associateWith { r ->
            val neighbours = (
                    if (r.y % 2 == 0)
                        when (TriHexagonalCellType.of(r)) {
                            TriHexagonalCellType.Hexagon -> neighboursOfEvenRowHexagon(r)
                            TriHexagonalCellType.TriangleDown -> neighboursOfEvenRowTriangleDown(r)
                            TriHexagonalCellType.TriangleUp -> neighboursOfEvenRowTriangleUp(r)
                        }
                    else
                        when (TriHexagonalCellType.of(r)) {
                            TriHexagonalCellType.Hexagon -> neighboursOfOddRowHexagon(r)
                            TriHexagonalCellType.TriangleDown -> neighboursOfOddRowTriangleDown(r)
                            TriHexagonalCellType.TriangleUp -> neighboursOfOddRowTriangleUp(r)
                        }
                    ).filter { r -> references.contains(r) }
            Cell(r, neighbours, TriHexagonalGridCellPositioner)
        }

        return Grid(cells, BoundingBoxFactory.of(cells.values), (0..max(trueWidthOdd, trueWidthEven)), yRange)
    }

    private fun neighboursOfEvenRowHexagon(r: GridReference): List<GridReference> = listOf(
        // row below Down triangle
        GridReference(r.x + 1, r.y - 1),
        // same row left triangles
        GridReference(r.x - 2, r.y),
        GridReference(r.x - 1, r.y),
        // same row right triangles
        GridReference(r.x + 1, r.y),
        GridReference(r.x + 2, r.y),
        // row above up triangle
        GridReference(r.x, r.y + 1),
    )

    private fun neighboursOfEvenRowTriangleUp(r: GridReference): List<GridReference> = listOf(
        // row below hexagon
        GridReference(r.x, r.y - 1),
        // hexagon left
        GridReference(r.x - 1, r.y),
        // hexagon right
        GridReference(r.x + 2, r.y),
    )

    private fun neighboursOfEvenRowTriangleDown(r: GridReference): List<GridReference> = listOf(
        // hexagon left
        GridReference(r.x - 2, r.y),
        // hexagon right
        GridReference(r.x + 1, r.y),
        // row above hexagon
        GridReference(r.x, r.y + 1),
    )

    private fun neighboursOfOddRowHexagon(r: GridReference): List<GridReference> = listOf(
        // row below Down triangle
        GridReference(r.x, r.y - 1),
        // same row left triangles
        GridReference(r.x - 2, r.y),
        GridReference(r.x - 1, r.y),
        // same row right triangles
        GridReference(r.x + 1, r.y),
        GridReference(r.x + 2, r.y),
        // row above up triangle
        GridReference(r.x - 1, r.y + 1),
    )

    private fun neighboursOfOddRowTriangleUp(r: GridReference): List<GridReference> = listOf(
        // row below hexagon
        GridReference(r.x, r.y - 1),
        // hexagon left
        GridReference(r.x - 1, r.y),
        // hexagon right
        GridReference(r.x + 2, r.y),
    )

    private fun neighboursOfOddRowTriangleDown(r: GridReference): List<GridReference> = listOf(
        // hexagon left
        GridReference(r.x - 2, r.y),
        // hexagon right
        GridReference(r.x + 1, r.y),
        // row above hexagon
        GridReference(r.x - 1, r.y + 1),
    )
}