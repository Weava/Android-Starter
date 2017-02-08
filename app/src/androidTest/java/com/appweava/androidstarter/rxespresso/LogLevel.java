package com.appweava.androidstarter.rxespresso;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;


import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * LogLevel
 * <p>
 * Class description here
 */
@Retention(SOURCE)
@IntDef({LogLevel.NONE, LogLevel.DEBUG})
public @interface LogLevel {
    int NONE = 0;
    int DEBUG = 1;
}
