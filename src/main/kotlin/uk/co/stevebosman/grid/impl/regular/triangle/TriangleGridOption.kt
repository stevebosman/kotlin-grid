package uk.co.stevebosman.grid.impl.regular.triangle

enum class TriangleGridOption {
    /** Each row/column is the same size, even rows start with an up triangle 🔺. */
    STANDARD,

    /** Each row/column is the same size, even rows start with a down triangle 🔻. */
    OFFSET,

    /** Each row has 1 less cell than the previous row */
    TRIANGLE,

    /** Skip up triangles of first row, skip down triangles of last row */
    SPIKY
}