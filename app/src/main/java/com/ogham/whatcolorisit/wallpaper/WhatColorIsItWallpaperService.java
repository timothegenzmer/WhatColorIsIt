package com.ogham.whatcolorisit.wallpaper;

import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;

import com.ogham.whatcolorisit.util.LLog;

/**
 * Created by Timothe on 12.12.2014.
 */
public class WhatColorIsItWallpaperService extends WallpaperService {
    private static final LLog LOG = LLog.getLogger(WhatColorIsItWallpaperService.class);

    @Override
    public Engine onCreateEngine() {
        return new WhatColorIsItEngine();
    }

    private class WhatColorIsItEngine extends Engine {
        private boolean visible;
        private Handler handler;
        private WhatColorIsItWallpaper wallpaper;

        private Runnable drawRunner = new Runnable() {
            @Override
            public void run() {
                wallpaper.draw(getSurfaceHolder(), width, height);
                handler.removeCallbacks(this);
                if (visible) {
                    handler.postDelayed(this, 1000);
                }
            }
        };

        private int width;
        private int height;

        private WhatColorIsItEngine() {
            LOG.v("Engine created");
            handler = new Handler();

            handler.post(drawRunner);

            wallpaper = new WhatColorIsItWallpaper(WhatColorIsItWallpaperService.this, getSurfaceHolder());
        }

        @Override
        public void onVisibilityChanged(boolean visible) {
            this.visible = visible;
            if (visible) {
                handler.post(drawRunner);
            } else {
                handler.removeCallbacks(drawRunner);
            }
        }

        @Override
        public void onSurfaceChanged(SurfaceHolder holder, int format,
                                     int width, int height) {
            LOG.d("surface changed");
            this.width = width;
            this.height = height;
            super.onSurfaceChanged(holder, format, width, height);
        }

        @Override
        public void onSurfaceDestroyed(SurfaceHolder holder) {
            super.onSurfaceDestroyed(holder);
            this.visible = false;
            handler.removeCallbacks(drawRunner);
        }
    }
}
