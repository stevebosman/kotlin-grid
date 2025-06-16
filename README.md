# Kotlin Grid

An API for generating grids of cells.

## Tilings

### Square

```kotlin
val grid: Grid = SquareGridGenerator.generate(height = 5, width = 5)
```

![Square](examples/square.svg.png)

### Triangular

#### Standard

```kotlin
val grid: Grid = TriangleGridGenerator.generate(width = 7, height = 4)
```

![Triangular - standard](examples/triangular.svg.png)

#### Offset

```kotlin
val grid: Grid = TriangleGridGenerator.generate(width = 7, height = 4, option = TriangleGridOption.OFFSET)
```

![Triangular - offset](examples/triangular_offset.svg.png)

#### Spiky

```kotlin
val grid: Grid = TriangleGridGenerator.generate(width = 7, height = 4, option = TriangleGridOption.SPIKY)
```

![Triangular - spiky](examples/triangular_spiky.svg.png)

#### Offset Spiky

```kotlin
val grid: Grid = TriangleGridGenerator.generate(width = 7, height = 4, option = TriangleGridOption.OFFSET_SPIKY)
```

![Triangular - offset spiky](examples/triangular_offset_spiky.svg.png)

#### Triangle

```kotlin
val grid: Grid = TriangleGridGenerator.generate(4, 5, TriangleGridOption.TRIANGLE)
```

![Triangular - as big triangle](examples/triangular_triangle.svg.png)

### Hexagonal

#### Standard

```kotlin
val grid: Grid = HexGridGenerator.generate(width = 5, height = 5)
```

![Hexagonal - standard](examples/hexagonal_standard.svg.png)

#### Standard Skip Last

```kotlin
val grid: Grid = HexGridGenerator.generate(width = 5, height = 5, option = HexGridOption.STANDARD_SKIP_LAST)
```

![Hexagonal - skip last on odd rows](examples/hexagonal_standard_skip_last.svg.png)

#### Offset

```kotlin
val grid: Grid = HexGridGenerator.generate(width = 5, height = 5, option = HexGridOption.OFFSET)
```

![Hexagonal - offset](examples/hexagonal_offset.svg.png)

#### Offset Skip Last

```kotlin
val grid: Grid = HexGridGenerator.generate(width = 5, height = 5, option = HexGridOption.OFFSET_SKIP_LAST)
```

![Hexagonal - offset skip last on odd rows](examples/hexagonal_offset_skip_last.svg.png)

#### Triangular

```kotlin
val grid: Grid = HexGridGenerator.generate(width = 5, height = 5, option = HexGridOption.TRIANGLE)
```

![Hexagonal - in triangle shape](examples/hexagonal_triangle.svg.png)

### Octagonal/Square (Truncated Square)

#### Start with octagon

```kotlin
val grid: Grid =
SquareOctagon2GridGenerator.generate(width = 5, height = 5, option = SquareOctagon2GridOption.START_OCTAGON)
```

![Truncated Square - start with octagons](examples/truncated_square_start_octagon.svg.png)

#### Start with square

```kotlin
val grid: Grid =
SquareOctagon2GridGenerator.generate(width = 5, height = 5, option = SquareOctagon2GridOption.START_SQUARE)
```

![Truncated Square - start with squares](examples/truncated_square_start_square.svg.png)

### Tri Hexagonal

#### Start with hexagon

```kotlin
val grid: Grid =
TriHexagonalGridGenerator.generate(width = 7, height = 5, option = SquareOctagon2GridOption.START_HEXAGON)
```

![Tri Hexagonal](examples/triHexagonal.svg.png)

#### Start with triangles

```kotlin
val grid: Grid =
TriHexagonalGridGenerator.generate(width = 7, height = 5, option = SquareOctagon2GridOption.START_TRIANGLES)
```

![Tri Hexagonal - starting with triangles](examples/triHexagonal_triangles.svg.png)

### Elongated Triangular

#### Start with full row of triangles

```kotlin
val grid: Grid = ElongatedTriangularGridGenerator.generate(12, 9, ElongatedTriangularGridOption.START_TRIANGLES_FULL)
```

![Elongated Triangular](examples/elongated_triangular_start_triangles_full.svg.png)

#### Start with row of triangles - spiky

```kotlin
val grid: Grid = ElongatedTriangularGridGenerator.generate(12, 9, ElongatedTriangularGridOption.START_TRIANGLES_SPIKY)
```

![Elongated Triangular - spiky](examples/elongated_triangular_start_triangles_spiky.svg.png)

#### Start with row of squares

```kotlin
val grid: Grid = ElongatedTriangularGridGenerator.generate(12, 9, ElongatedTriangularGridOption.START_TRIANGLES_FULL)
```

![Elongated Triangular - Squares](examples/elongated_triangular_start_squares_full.svg.png)

#### Start with row of squares - spiky finish

```kotlin
val grid: Grid = ElongatedTriangularGridGenerator.generate(12, 8, ElongatedTriangularGridOption.START_TRIANGLES_SPIKY)
```

![Elongated Triangular - Spiky Squares](examples/elongated_triangular_start_squares_spiky.svg.png)

### Rhombi Tri Hexagonal

These grids are generated in overlapping repetitions of the singleton pattern.

#### Singleton

```kotlin
val grid: Grid = RhombiTriHexagonalGridGenerator.generate(width = 1, height = 1)
```

![Rhombi Tri Hexagonal - singleton](examples/rhombiTriHexagonal_singleton.svg.png)

#### Standard

```kotlin
val grid: Grid = RhombiTriHexagonalGridGenerator.generate(width = 3, height = 3)
```

![Rhombi Tri Hexagonal - standard](examples/rhombiTriHexagonal.svg.png)

#### Standard Skip Last

Skip last is disabled when width is 1.

```kotlin
val grid: Grid =
RhombiTriHexagonalGridGenerator.generate(width = 3, height = 3, RhombiTriHexagonalGridOption.STANDARD_SKIP_LAST)
```

![Rhombi Tri Hexagonal - standard skip last](examples/rhombiTriHexagonal_skip_last.svg.png)

#### Offset

```kotlin
val grid: Grid = RhombiTriHexagonalGridGenerator.generate(width = 3, height = 3, RhombiTriHexagonalGridOption.OFFSET)
```

![Rhombi Tri Hexagonal - offset](examples/rhombiTriHexagonal_offset.svg.png)

#### Offset Skip Last

Skip last is disabled when width is 1.

```kotlin
val grid: Grid =
RhombiTriHexagonalGridGenerator.generate(width = 3, height = 3, RhombiTriHexagonalGridOption.OFFSET_SKIP_LAST)
```

![Rhombi Tri Hexagonal - offset skip last](examples/rhombiTriHexagonal_offset_skip_last.svg.png)

#### Triangular

```kotlin
val grid: Grid =
RhombiTriHexagonalGridGenerator.generate(width = 3, height = 3, RhombiTriHexagonalGridOption.TRIANGLE)
```

![Rhombi Tri Hexagonal - triangular](examples/rhombiTriHexagonal_triangle.svg.png)

### Snub Hexagonal

These grids are generated in overlapping repetitions of the singleton pattern.

#### Singleton

```kotlin
val grid: Grid = SnubHexagonalGridGenerator.generate(width = 1, height = 1)
```

![Snub Hexagonal - singleton](examples/snubHexagonal_singleton.svg.png)

#### Standard

```kotlin
val grid: Grid = SnubHexagonalGridGenerator.generate(width = 3, height = 3)
```

![Snub Hexagonal - standard](examples/snubHexagonal.svg.png)

#### Standard Skip Last

Skip last is disabled when width is 1.

```kotlin
val grid: Grid =
SnubHexagonalGridGenerator.generate(width = 3, height = 3, SnubHexagonalGridOption.STANDARD_SKIP_LAST)
```

![Snub Hexagonal - standard skip last](examples/snubHexagonal_skip_last.svg.png)

#### Offset

```kotlin
val grid: Grid = SnubHexagonalGridGenerator.generate(width = 3, height = 3, SnubHexagonalGridOption.OFFSET)
```

![Snub Hexagonal - offset](examples/snubHexagonal_offset.svg.png)

#### Offset Skip Last

Skip last is disabled when width is 1.

```kotlin
val grid: Grid = SnubHexagonalGridGenerator.generate(width = 3, height = 3, SnubHexagonalGridOption.OFFSET_SKIP_LAST)
```

![Snub Hexagonal - offset skip last](examples/snubHexagonal_offset_skip_last.svg.png)

#### Triangular

```kotlin
val grid: Grid = SnubHexagonalGridGenerator.generate(width = 3, height = 3, SnubHexagonalGridOption.TRIANGLE)
```

![Snub Hexagonal - triangular](examples/snubHexagonal_triangle.svg.png)

### Planned

#### Floret Pentagonal

![Floret Pentagonal](https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Tiling_Dual_Semiregular_V3-3-3-3-6_Floret_Pentagonal.svg/120px-Tiling_Dual_Semiregular_V3-3-3-3-6_Floret_Pentagonal.svg.svg.png)

## SVG Grid Generation

Generates images like those used in the supported section of this README file.

### Example

```kotlin
  val svg: String = SquareGridGenerator.generate(height = 5, width = 5).toSvg()
```