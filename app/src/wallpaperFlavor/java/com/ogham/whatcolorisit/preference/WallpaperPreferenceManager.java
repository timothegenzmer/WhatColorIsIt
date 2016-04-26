package com.ogham.whatcolorisit.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.ogham.whatcolorisit.data.FullRangeColor;
import com.ogham.whatcolorisit.data.GammaColor;
import com.ogham.whatcolorisit.data.LightColor;
import com.ogham.whatcolorisit.data.NormalColor;
import com.ogham.whatcolorisit.data.TimeColor;

/**
 * Created by Timothe on 21.12.2014.
 */
public class WallpaperPreferenceManager {
    private SharedPreferences sharedPref;

    public WallpaperPreferenceManager(Context context) {
        sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public boolean showClock() {
        return sharedPref.getBoolean("pref_show_clock", true);
    }

    public ScreenPositions getScreenPosition() {
        int preferenceValue = Integer.parseInt(sharedPref.getString("pref_screenposition", "0"));
        return ScreenPositions.values()[preferenceValue];
    }

    public TimeColor getColor() {
        int preferenceValue = Integer.parseInt(sharedPref.getString("pref_coloroptions", "0"));
        ColorPreferences color = ColorPreferences.values()[preferenceValue];
        switch (color) {
            case DEFAULT:
                return new NormalColor();
            case FULL_RANGE:
                return new FullRangeColor();
            case LIGHT:
                return new LightColor();
            case GAMMA:
                return new GammaColor();
            default:
                throw new IllegalStateException("unknown case " + color);
        }
    }
}
