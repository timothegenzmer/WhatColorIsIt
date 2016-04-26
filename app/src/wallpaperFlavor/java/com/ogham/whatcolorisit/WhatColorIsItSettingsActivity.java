package com.ogham.whatcolorisit;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.ogham.whatcolorisit.util.LLog;

/**
 * Created by Timothe on 17.12.2014.
 */
public class WhatColorIsItSettingsActivity extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.activity_settings);
    }
}
