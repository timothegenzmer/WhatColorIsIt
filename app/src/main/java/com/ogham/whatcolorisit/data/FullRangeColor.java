package com.ogham.whatcolorisit.data;

import com.ogham.whatcolorisit.util.LLog;
import com.ogham.whatcolorisit.util.LinearInterpolator;

/**
 * Created by Timothe on 21.12.2014.
 */
public class FullRangeColor extends TimeColorUtil {
    private static final LLog LOG = LLog.getLogger(FullRangeColor.class);

    private LinearInterpolator hourInterpolator;
    private LinearInterpolator minSecInterpolator;

    public FullRangeColor() {
        super();
        hourInterpolator = new LinearInterpolator(0, 0, 24, 255);
        minSecInterpolator = new LinearInterpolator(0, 0, 60, 255);
    }

    @Override
    public int getColorCode() {
        int hourInterpolated = (int) hourInterpolator.interpolate(hour);
        int minutesInterpolated = (int) minSecInterpolator.interpolate(minute);
        int secondsInterpolated = (int) minSecInterpolator.interpolate(second);
        return (hourInterpolated << 16) + (minutesInterpolated << 8) + secondsInterpolated;
    }
}
