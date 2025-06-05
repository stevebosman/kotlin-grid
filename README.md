# Kotlin Grid

Small API for generating grids of cells. 

## Tilings
### Current Support
* Square
  ```kotlin
  val grid: Grid = SquareGridGenerator.generate(height = 5, width = 5)
  ```
  ![Square](examples/square.png)
* Triangular
  * Standard
    ```kotlin
    val grid: Grid = TriangleGridGenerator.generate(width = 7, height = 4)
    ```
    ![Triangular - standard](examples/triangular.png)
  * Offset
    ```kotlin
    val grid: Grid = TriangleGridGenerator.generate(width = 7, height = 4, option = TriangleGridOption.OFFSET)
    ```
    ![Triangular - offset](examples/triangular_offset.png)
  * Spiky
    ```kotlin
    val grid: Grid = TriangleGridGenerator.generate(width = 7, height = 4, option = TriangleGridOption.SPIKY)
    ```
    ![Triangular - spiky](examples/triangular_spiky.png)
  * Offset Spiky
    ```kotlin
    val grid: Grid = TriangleGridGenerator.generate(width = 7, height = 4, option = TriangleGridOption.OFFSET_SPIKY)
    ```
    ![Triangular - offset spiky](examples/triangular_offset_spiky.png)
  * Triangle
    ```kotlin
    val grid: Grid = TriangleGridGenerator.generate(4, 5, TriangleGridOption.TRIANGLE)
    ```
    ![Triangular - as big triangle](examples/triangular_triangle.png)
* Hexagonal  
  * Standard
    ```kotlin
    val grid: Grid = HexGridGenerator.generate(width = 5, height = 5)
    ```
    ![Hexagonal - standard](examples/hexagonal_standard.png)
  * Standard Skip Last
    ```kotlin
    val grid: Grid = HexGridGenerator.generate(width = 5, height = 5, option = HexGridOption.STANDARD_SKIP_LAST)
    ```
    ![Hexagonal - skip last on odd rows](examples/hexagonal_standard_skip_last.png)
  * Offset
    ```kotlin
    val grid: Grid = HexGridGenerator.generate(width = 5, height = 5, option = HexGridOption.OFFSET)
    ```
    ![Hexagonal - offset](examples/hexagonal_offset.png)
  * Offset Skip Last
    ```kotlin
    val grid: Grid = HexGridGenerator.generate(width = 5, height = 5, option = HexGridOption.OFFSET_SKIP_LAST)
    ```
    ![Hexagonal - offset skip last on odd rows](examples/hexagonal_offset_skip_last.png)
  * Triangular
    ```kotlin
    val grid: Grid = HexGridGenerator.generate(width = 5, height = 5, option = HexGridOption.TRIANGLE)
    ```
    ![Hexagonal - in triangle shape](examples/hexagonal_triangle.png)
* Octagonal/Square (Truncated Square)  
  * Start with octagon
    ```kotlin
    val grid: Grid = SquareOctagon2GridGenerator.generate(width = 5, height = 5, option = SquareOctagon2GridOption.START_OCTAGON)
    ```
    ![Truncated Square - start with octagons](examples/truncated_square_start_octagon.png)
  * Start with square
    ```kotlin
    val grid: Grid = SquareOctagon2GridGenerator.generate(width = 5, height = 5, option = SquareOctagon2GridOption.START_SQUARE)
    ```
    ![Truncated Square - start with squares](examples/truncated_square_start_square.png)
* Tri hexagonal
  * Start with hexagon
    ```kotlin
    val grid: Grid = TriHexagonalGridGenerator.generate(width = 7, height = 5, option = SquareOctagon2GridOption.START_HEXAGON)
    ```
    ![Tri Hexagonal](examples/trihexagonal.png)
  * Start with triangles
    ```kotlin
    val grid: Grid = TriHexagonalGridGenerator.generate(width = 7, height = 5, option = SquareOctagon2GridOption.START_TRIANGLES)
    ```
    ![Tri Hexagonal - starting with triangles](examples/trihexagonal_triangles.png)

### Planned
* Square/Triangle (Elongated Triangular)  
  ![Square/Triangle](https://upload.wikimedia.org/wikipedia/commons/thumb/c/c6/1-uniform_n8.svg/250px-1-uniform_n8.svg.png)
* Rhombi Tri hexagonal  
  ![Rhombi Tri Hexagonal](https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Tiling_small_rhombi_3-6_simple.svg/1024px-Tiling_small_rhombi_3-6_simple.svg.png)
* Snub hexagonal  
  ![Snub Hexagonal](https://upload.wikimedia.org/wikipedia/commons/thumb/5/5f/Academ_Periodic_tiling_where_eighteen_triangles_encircle_each_hexagon.svg/120px-Academ_Periodic_tiling_where_eighteen_triangles_encircle_each_hexagon.svg.png)
* Floret Pentagonal  
  ![Floret Pentagonal](https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Tiling_Dual_Semiregular_V3-3-3-3-6_Floret_Pentagonal.svg/120px-Tiling_Dual_Semiregular_V3-3-3-3-6_Floret_Pentagonal.svg.png)

## SVG Grid Generation
Generates images like those used in the supported section of this README file.
### Example
```kotlin
  val svg: String = SquareGridGenerator.generate(height = 5, width = 5).toSvg()
```