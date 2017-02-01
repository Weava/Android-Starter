package com.appweava.androidstarter;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

/**
 * DebugAppInitializer
 * <p>
 * {@link AppInitializer} extension for defining application dependencies for Debug builds.
 */
public class DebugAppInitializer extends AppInitializer {

    @Override
    protected void initAppDependencies(StarterApp app) {
        Timber.plant(new Timber.DebugTree());
        Stetho.initializeWithDefaults(app);
        LeakCanary.install(app);
    }
}
