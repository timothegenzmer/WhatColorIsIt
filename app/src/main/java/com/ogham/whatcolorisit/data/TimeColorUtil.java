package com.ogham.whatcolorisit.data;

import java.util.Calendar;

/**
 * Created by Timothe on 12.12.2014.
 */
public abstract class TimeColorUtil {

    protected int hour;
    protected int minute;
    protected int second;

    public TimeColorUtil() {
        updateTime();
    }

    public void updateTime() {
        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
        second = c.get(Calendar.SECOND);
    }

    public abstract int getColorCode();

    public String getTimeText() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
