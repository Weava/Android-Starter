package com.appweava.androidstarter;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

/**
 * DebugAppInitializer
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/19/16
 */
public class DebugAppInitializer extends AppInitializer {

    @Override
    protected void initAppDependencies(StarterApp app) {
        Timber.plant(new Timber.DebugTree());
        Stetho.initializeWithDefaults(app);
        LeakCanary.install(app);
    }
}
