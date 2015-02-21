package com.ogham.whatcolorisit.data;

import com.ogham.whatcolorisit.util.LLog;

/**
 * Created by Timothe on 21.12.2014.
 */
public class NormalColor extends TimeColorUtil {
    private static final LLog LOG = LLog.getLogger(NormalColor.class);

    @Override
    public int getColorCode() {
        int hour10 = firstDigit(hour);
        int hour0 = lastDigit(hour);
        int minute10 = firstDigit(minute);
        int minute0 = lastDigit(minute);
        int second10 = firstDigit(second);
        int second0 = lastDigit(second);

        int hourB = concatinate(hour10, hour0);
        int minuteB = concatinate(minute10, minute0);
        int secondB = concatinate(second10, second0);
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
