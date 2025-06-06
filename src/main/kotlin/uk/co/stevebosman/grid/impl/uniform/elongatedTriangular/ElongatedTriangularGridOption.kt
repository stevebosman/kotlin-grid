package uk.co.stevebosman.grid.impl.uniform.elongatedTriangular

enum class ElongatedTriangularGridOption {
    /** First row has up triangles, if last row has triangles it will just be down triangles. */
    START_TRIANGLES_SPIKY,

    /** First and last (if triangles) rows have up and down triangles. */
    START_TRIANGLES_FULL,

    /** First row has squares, if last row is triangles it will just have down triangles. */
    START_SQUARES_SPIKY,

    /** First row has squares, if last row is triangles it will have up and down triangles. */
    START_SQUARES_FULL

}