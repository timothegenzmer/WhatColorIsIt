package com.ogham.whatcolorisit.wallpaper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import com.ogham.whatcolorisit.data.TimeColorUtil;
import com.ogham.whatcolorisit.preference.WallpaperPreferenceManager;
import com.ogham.whatcolorisit.preference.ScreenPositions;
import com.ogham.whatcolorisit.util.LLog;

/**
 * Created by Timothe on 21.02.2015.
 */
public class WhatColorIsItWallpaper {
    private static final LLog LOG = LLog.getLogger(WhatColorIsItWallpaper.class);

    private static final float TIME_CODE_RATIO = 0.25f;

    private SurfaceHolder surfaceHolder;

    private Paint textPaint;
    private Paint backGroundPaint;
    private TimeColorUtil timeColor;

    private WallpaperPreferenceManager manager;

    private ScreenPositions positions;

    private int width;
    private int height;

    public WhatColorIsItWallpaper(Context context, SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;

        backGroundPaint = new Paint();

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
    }

    public void draw(SurfaceHolder holder, int width, int height) {

        if (this.width != width || this.height != height) {
            this.width = width;
            this.height = height;
            messureMaxTextSize();
        }

        timeColor.updateTime();
        Canvas canvas = null;
        try {
            canvas = holder.lockCanvas();
            if (canvas != null) {
                int alpha = 0xFF << 24;
                int color = alpha + timeColor.getColorCode();
                drawBackground(canvas, color);
                drawTime(canvas);
                drawColorCode(canvas, color);
            }
        } finally {
            if (canvas != null) {
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    private void drawBackground(Canvas canvas, int color) {
        backGroundPaint.setColor(color);
        canvas.drawRect(0, 0, width, height, backGroundPaint);
    }

    private void messureMaxTextSize() {
        float lowerBound = 1;
        float upperBound = 1000;

        //90% of width
        float aim = width * 0.9f;
        //Allowed diff in pixel
        float eppsilon = 2;
        float messured = textPaint.measureText("00:00:00");
        while (Math.abs(messured - aim) > eppsilon) {
            float average = (lowerBound + upperBound) / 2;
            textPaint.setTextSize(average);
            messured = textPaint.measureText("00:00:00");
            if (messured > aim) {
                upperBound = average;
            } else {
                lowerBound = average;
            }
        }
        LOG.d("Found max size: " + textPaint.getTextSize());
    }

    private void drawTime(Canvas canvas) {
        canvas.drawText(timeColor.getTimeText(), width / 2, height * positions.screenPosition, textPaint);
    }

    private void drawColorCode(Canvas canvas, int color) {
        float currentTextSize = textPaint.getTextSize();
        textPaint.setTextSize(currentTextSize * TIME_CODE_RATIO);
        //remove alpha value
        color = color & 0xFFFFFF;
        String colorText = String.format("#%06X", color);
        canvas.drawText(colorText, width / 2, height * positions.screenPosition + currentTextSize / 2, textPaint);
        textPaint.setTextSize(currentTextSize);
    }
}
