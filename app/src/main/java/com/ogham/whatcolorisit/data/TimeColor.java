package com.ogham.whatcolorisit.data;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Timothe on 12.12.2014.
 */
public abstract class TimeColor {

    private Calendar c;
    protected int hour;
    protected int minute;
    protected int second;

    public TimeColor() {
        c = Calendar.getInstance();
        updateTime();
    }

    public void updateTime() {
        c.setTimeInMillis(System.currentTimeMillis());
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
        second = c.get(Calendar.SECOND);
    }

    public abstract int getColorCode();

    public String getTimeText() {
        return String.format(Locale.US, "%02d:%02d:%02d", hour, minute, second);
    }
}
