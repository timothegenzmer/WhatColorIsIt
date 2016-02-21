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

    /**
     * Send a {@link Log#VERBOSE} log message.
     *
     * @param msg
     *         The message you would like logged.
     */
    public abstract int v(String msg);

    /**
     * Send a {@link Log#VERBOSE} log message and log the exception.
     *
     * @param msg
     *         The message you would like logged.
     * @param tr
     *         An exception to log
     */
    public abstract int v(String msg, Throwable tr);

    /**
     * Send a {@link Log#DEBUG} log message.
     *
     * @param msg
     *         The message you would like logged.
     */
    public abstract int d(String msg);

    /**
     * Send a {@link Log#DEBUG} log message and log the exception.
     *
     * @param msg
     *         The message you would like logged.
     * @param tr
     *         An exception to log
     */
    public abstract int d(String msg, Throwable tr);

    /**
     * Send an {@link Log#INFO} log message.
     *
     * @param msg
     *         The message you would like logged.
     */
    public abstract int i(String msg);

    /**
     * Send a {@link Log#INFO} log message and log the exception.
     *
     * @param msg
     *         The message you would like logged.
     * @param tr
     *         An exception to log
     */
    public abstract int i(String msg, Throwable tr);

    /**
     * Send a {@link Log#WARN} log message.
     *
     * @param msg
     *         The message you would like logged.
     */
    public abstract int w(String msg);

    /**
     * Send a {@link Log#WARN} log message and log the exception.
     *
     * @param msg
     *         The message you would like logged.
     * @param tr
     *         An exception to log
     */
    public abstract int w(String msg, Throwable tr);

    public abstract int w(Throwable tr);

    public abstract int e(String msg, Throwable tr);

    public abstract int e(String msg);

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

    /**
     * Logger that will be used during release <br/> This logger wont log anything
     */
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