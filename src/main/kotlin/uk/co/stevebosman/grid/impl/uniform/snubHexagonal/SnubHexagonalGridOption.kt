package uk.co.stevebosman.grid.impl.uniform.snubHexagonal

enum class SnubHexagonalGridOption {
    /** Each super-row/column is the same size, even rows are the furthest left */
    STANDARD,

    /** Odd super-rows have 1 less group than the even rows */
    STANDARD_SKIP_LAST,

    /** Each super-row/column is the same size, odd rows are the furthest left */
    OFFSET,

    /** Even super-rows have 1 less group than the odd rows */
    OFFSET_SKIP_LAST,

    /** Each super-row has 1 less group than the previous row */
    TRIANGLE
}