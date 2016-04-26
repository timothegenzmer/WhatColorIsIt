package com.ogham.whatcolorisit.data;

import com.ogham.whatcolorisit.util.Interpolator;

/**
 * Created by Timothe on 17.03.2016.
 */
public class InterpolatorColor extends TimeColor {

    private Interpolator hourInterpolator;
    private Interpolator minSecInterpolator;

    public InterpolatorColor(Interpolator hourInterpolator, Interpolator minSecInterpolator) {
        this.hourInterpolator = hourInterpolator;
        this.minSecInterpolator = minSecInterpolator;
    }

    @Override
    public int getColorCode() {
        int hourInterpolated = (int) hourInterpolator.interpolate(hour);
        int minutesInterpolated = (int) minSecInterpolator.interpolate(minute);
        int secondsInterpolated = (int) minSecInterpolator.interpolate(second);
        return (hourInterpolated << 16) + (minutesInterpolated << 8) + secondsInterpolated;
    }

}
