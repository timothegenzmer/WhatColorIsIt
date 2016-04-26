package com.ogham.whatcolorisit.data;

import com.ogham.whatcolorisit.util.GammaInterpolator;

/**
 * Created by Timothe on 17.03.2016.
 */
public class GammaColor extends InterpolatorColor {

    public GammaColor() {
        super(new GammaInterpolator(0, 0, 24, 255), new GammaInterpolator(0, 0, 60, 255));
    }
}
