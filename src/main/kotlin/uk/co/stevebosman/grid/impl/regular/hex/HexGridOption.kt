package uk.co.stevebosman.grid.impl.regular.hex

enum class HexGridOption {
    /** Each row/column is the same size, even rows are the furthest left */
    STANDARD,

    /** Odd rows have 1 less cell than the even rows */
    STANDARD_SKIP_LAST,

    /** Each row/column is the same size, odd rows are the furthest left */
    OFFSET,

    /** Even rows have 1 less cell than the odd rows */
    OFFSET_SKIP_LAST,

    /** Each row has 1 less cell than the previous row */
    TRIANGLE
}