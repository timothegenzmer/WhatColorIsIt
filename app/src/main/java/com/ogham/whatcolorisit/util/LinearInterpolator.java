package com.ogham.whatcolorisit.util;

/**
 * Linear interpolation between two points <br> basically creates a linear function between two points. <br> In the form of {@code y=m*x+n}
 */
public class LinearInterpolator {
    /**
     * Steep of the linear function
     */
    private float m;
    /**
     * Y-Coordinate for X=0
     */
    private float n;

    /**
     * Constructs a new Linear interpolator out of 2 points
     *
     * @param x1
     *         X-Coordinate of the first point
     * @param y1
     *         Y-Coordinate of the first point
     * @param x2
     *         X-Coordinate of the second point
     * @param y2
     *         Y-Coordinate of the second point
     */
    public LinearInterpolator(float x1, float y1, float x2, float y2) {
        m = (y2 - y1) / (x2 - x1);
        n = y1 - m * x1;
    }

    public float interpolate(float value) {
        return m * value + n;
    }
}
