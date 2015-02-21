package com.ogham.whatcolorisit.preference;

/**
 * Created by Timothe on 17.12.2014.
 */
public enum ScreenPositions {
    TOP(0.3f),
    MIDDLE(0.5f),
    BOTTOM(0.7f);

    public final float screenPosition;

    ScreenPositions(float screenPosition) {
        this.screenPosition = screenPosition;
    }
}
