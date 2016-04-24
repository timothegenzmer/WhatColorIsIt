package com.ogham.whatcolorisit.wallpaper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import com.ogham.whatcolorisit.data.TimeColorUtil;
import com.ogham.whatcolorisit.preference.ScreenPositions;
import com.ogham.whatcolorisit.preference.WallpaperPreferenceManager;
import com.ogham.whatcolorisit.util.LLog;

/**
 * Created by Timothe on 21.02.2015.
 */
public class WhatColorIsItWallpaper {
    private static final LLog LOG = LLog.getLogger(WhatColorIsItWallpaper.class);

    private static final float TIME_TO_SCREEN_RATIO = 0.85f;
    private static final float TIME_CODE_RATIO = 0.25f;

    private static final float MOVEMENT = 0.95f - TIME_TO_SCREEN_RATIO;

    private static final String MEASURMENT_STRING = "00:00:00";

    private Paint textPaint;
    private Paint backGroundPaint;

    private WallpaperPreferenceManager manager;

    private TimeColorUtil timeColor;
    private ScreenPositions positions;
    private boolean showClock;

    private int width;
    private int height;

    /**
     * number between 0 and 1
     */
    private float currentStep = 0.5f;

    public WhatColorIsItWallpaper(Context context) {
        backGroundPaint = new Paint();
        backGroundPaint.setStyle(Paint.Style.FILL);

        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(150);

        manager = new WallpaperPreferenceManager(context);
        loadOptions();
    }

    private void loadOptions() {
        positions = manager.getScreenPosition();
        timeColor = manager.getColor();
        showClock = manager.showClock();
    }

    public void reloadSettings() {
        loadOptions();
    }

    public void draw(SurfaceHolder holder) {
        timeColor.updateTime();
        Canvas canvas = null;
        try {
            canvas = holder.lockCanvas();
            if (canvas != null) {
                int alpha = 0xFF << 24;
                int color = alpha + timeColor.getColorCode();
                drawBackground(canvas, color);
                if (showClock) {
                    drawTime(canvas);
                    drawColorCode(canvas, color);
                }
            }
        } finally {
            if (canvas != null) {
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    private void drawBackground(Canvas canvas, int color) {
        backGroundPaint.setColor(color);
        canvas.drawPaint(backGroundPaint);
    }

    private void drawTime(Canvas canvas) {
        canvas.drawText(timeColor.getTimeText(), getTextPosition(), height * positions.screenPosition, textPaint);
    }

    private void drawColorCode(Canvas canvas, int color) {
        float currentTextSize = textPaint.getTextSize();
        textPaint.setTextSize(currentTextSize * TIME_CODE_RATIO);
        //remove alpha value
        color = color & 0xFFFFFF;
        String colorText = String.format("#%06X", color);
        canvas.drawText(colorText, getTextPosition(), height * positions.screenPosition + currentTextSize / 2, textPaint);
        textPaint.setTextSize(currentTextSize);
    }

    private float getTextPosition() {
        return width / 2 - getStepOffset();
    }

    private float getStepOffset() {
        return (currentStep - 0.5f) * width * MOVEMENT;
    }

    public void onOffsetChanged(float currentStep) {
        this.currentStep = currentStep;
    }

    public void onSizeChanged(int width, int height) {
        this.width = width;
        this.height = height;
        messureMaxTextSize();
    }

    private void messureMaxTextSize() {
        float lowerBound = 1;
        float upperBound = 1000;

        float aim = Math.min(width, height) * TIME_TO_SCREEN_RATIO;
        //Allowed diff in pixel
        float eppsilon = 2;
        float messured = textPaint.measureText(MEASURMENT_STRING);
        while (Math.abs(messured - aim) > eppsilon) {
            float average = (lowerBound + upperBound) / 2;
            textPaint.setTextSize(average);
            messured = textPaint.measureText(MEASURMENT_STRING);
            if (messured > aim) {
                upperBound = average;
            } else {
                lowerBound = average;
            }
        }
        LOG.d("Found max size: " + textPaint.getTextSize());
    }
}
