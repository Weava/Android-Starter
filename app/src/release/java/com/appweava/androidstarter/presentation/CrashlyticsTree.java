package com.appweava.androidstarter.presentation;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

/**
 * CrashlyticsTree
 * <p>
 * {@link timber.log.Timber.Tree} for sending error and crash reports to crashlytics on release
 * builds.
 */
public class CrashlyticsTree extends Timber.Tree {

    private static final String CRASHLYTICS_KEY_PRIORITY = "priority";
    private static final String CRASHLYTICS_KEY_TAG = "tag";
    private static final String CRASHLYTICS_KEY_MESSAGE = "message";

    public CrashlyticsTree(Context context) {
        Fabric.with(context, new Crashlytics());
    }

    @Override
    protected void log(int priority, @Nullable String tag, @Nullable String message,
            @Nullable Throwable t) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
            return;
        }

        Crashlytics.setInt(CRASHLYTICS_KEY_PRIORITY, priority);
        Crashlytics.setString(CRASHLYTICS_KEY_TAG, tag);
        Crashlytics.setString(CRASHLYTICS_KEY_MESSAGE, message);

        if (t == null) {
            Crashlytics.logException(new Exception(message));
        } else {
            Crashlytics.logException(t);
        }
    }
}
