package com.ogham.whatcolorisit;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.ogham.whatcolorisit.wallpaper.WhatColorIsItWallpaperService;

/**
 * Created by Timothe on 18.03.2016.
 */
public class LauncherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(null);
        
        Intent i = new Intent();

        if (Build.VERSION.SDK_INT > 15) {
            i.setAction(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);

            String p = WhatColorIsItSettingsActivity.class.getPackage().getName();
            String c = WhatColorIsItWallpaperService.class.getCanonicalName();
            i.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT, new ComponentName(p, c));
        } else {
            i.setAction(WallpaperManager.ACTION_LIVE_WALLPAPER_CHOOSER);
        }
        startActivity(i);
    }
}
