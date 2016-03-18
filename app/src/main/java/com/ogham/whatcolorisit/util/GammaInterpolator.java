package com.ogham.whatcolorisit.util;

/**
 * Linear interpolation between two points <br> basically creates a linear function between two points. <br> In the form of {@code y=m*x+n}
 */
public class GammaInterpolator implements Interpolator {
    /**
     * Steep of the linear function
     */
    private double gamma;

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
    public GammaInterpolator(float x1, float y1, float x2, float y2) {
        if (x1 != 0 || y1 != 0) {
            throw new IllegalArgumentException("this interpolator currently only works if x1 and y1 are 0");
        }
        gamma = Math.log(y2) / Math.log(x2);
    }

    @Override
    public double interpolate(double value) {
        return Math.pow(value, gamma);
    }
}
