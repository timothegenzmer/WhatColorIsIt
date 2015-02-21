package com.ogham.whatcolorisit.util;

import android.util.Log;

import com.ogham.whatcolorisit.BuildConfig;

/**
 * Created by Timothe on 16.12.2014.
 */
public abstract class LLog {

    public static LLog getLogger(Class clazz) {
        if (BuildConfig.DEBUG) {
            return new DebugLogger(clazz);
        } else {
            return new ReleaseLogger();
        }
    }

    public abstract int d(String msg);

    public abstract int d(String msg, Throwable tr);

    public abstract int e(String msg);

    public abstract int e(String msg, Throwable tr);

    public abstract int i(String msg);

    public abstract int i(String msg, Throwable tr);

    public abstract int v(String msg, Throwable tr);

    public abstract int v(String msg);

    public abstract int w(Throwable tr);

    public abstract int w(String msg, Throwable tr);

    public abstract int w(String msg);

    public abstract int wtf(Throwable tr);

    public abstract int wtf(String msg, Throwable tr);

    public abstract int wtf(String msg);

    private static class DebugLogger extends LLog {

        private String tag;

        private DebugLogger(Class clazz) {
            tag = clazz.getName();
        }

        @Override
        public int d(String msg) {
            return Log.d(tag, msg);
        }

        @Override
        public int d(String msg, Throwable tr) {
            return Log.d(tag, msg, tr);
        }

        @Override
        public int e(String msg) {
            return Log.e(tag, msg);
        }

        @Override
        public int e(String msg, Throwable tr) {
            return Log.e(tag, msg, tr);
        }

        @Override
        public int i(String msg) {
            return Log.i(tag, msg);
        }

        @Override
        public int i(String msg, Throwable tr) {
            return Log.i(tag, msg, tr);
        }

        @Override
        public int v(String msg, Throwable tr) {
            return Log.v(tag, msg, tr);
        }

        @Override
        public int v(String msg) {
            return Log.v(tag, msg);
        }

        @Override
        public int w(Throwable tr) {
            return Log.w(tag, tr);
        }

        @Override
        public int w(String msg, Throwable tr) {
            return Log.w(tag, msg, tr);
        }

        @Override
        public int w(String msg) {
            return Log.w(tag, msg);
        }

        @Override
        public int wtf(Throwable tr) {
            return Log.wtf(tag, tr);
        }

        @Override
        public int wtf(String msg, Throwable tr) {
            return Log.wtf(tag, msg, tr);
        }

        @Override
        public int wtf(String msg) {
            return Log.wtf(tag, msg);
        }
    }

    private static class ReleaseLogger extends LLog {

        @Override
        public int d(String msg) {
            return 0;
        }

        @Override
        public int d(String msg, Throwable tr) {
            return 0;
        }

        @Override
        public int e(String msg) {
            return 0;
        }

        @Override
        public int e(String msg, Throwable tr) {
            return 0;
        }

        @Override
        public int i(String msg) {
            return 0;
        }

        @Override
        public int i(String msg, Throwable tr) {
            return 0;
        }

        @Override
        public int v(String msg, Throwable tr) {
            return 0;
        }

        @Override
        public int v(String msg) {
            return 0;
        }

        @Override
        public int w(Throwable tr) {
            return 0;
        }

        @Override
        public int w(String msg, Throwable tr) {
            return 0;
        }

        @Override
        public int w(String msg) {
            return 0;
        }

        @Override
        public int wtf(Throwable tr) {
            return 0;
        }

        @Override
        public int wtf(String msg, Throwable tr) {
            return 0;
        }

        @Override
        public int wtf(String msg) {
            return 0;
        }
    }
}