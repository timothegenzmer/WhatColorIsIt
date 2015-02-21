package com.ogham.whatcolorisit.data;

import com.ogham.whatcolorisit.util.LLog;

import java.util.Arrays;

/**
 * Created by Timothe on 21.12.2014.
 */
public class LightColor extends TimeColorUtil {
    private static final LLog LOG = LLog.getLogger(LightColor.class);

    @Override
    public int getColorCode() {
        int hour10 = firstDigit(hour);
        int hour0 = lastDigit(hour);
        int minute10 = firstDigit(minute);
        int minute0 = lastDigit(minute);
        int second10 = firstDigit(second);
        int second0 = lastDigit(second);
        int hourB = 255 - concatinate(hour10, hour0);
        int minuteB = 255 - concatinate(minute10, minute0);
        int secondB = 255 - concatinate(second10, second0);
        return (hourB << 16) + (minuteB << 8) + secondB;
    }

    private int firstDigit(int value) {
        return value / 10;
    }

    private int lastDigit(int value) {
        return value % 10;
    }

    private int concatinate(int first, int last) {
        return (first << 4) + last;
    }
}
