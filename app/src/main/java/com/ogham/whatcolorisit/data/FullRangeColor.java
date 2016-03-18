package com.ogham.whatcolorisit.data;

import com.ogham.whatcolorisit.util.LinearInterpolator;

/**
 * Created by Timothe on 21.12.2014.
 */
public class FullRangeColor extends InterpolatorColor {

    public FullRangeColor() {
        super(new LinearInterpolator(0, 0, 24, 255), new LinearInterpolator(0, 0, 60, 255));
    }
}
