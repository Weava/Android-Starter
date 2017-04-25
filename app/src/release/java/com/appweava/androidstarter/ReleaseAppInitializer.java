package com.appweava.androidstarter;

import com.appweava.androidstarter.presentation.CrashlyticsTree;

import timber.log.Timber;

/**
 * ReleaseAppInitializer
 * <p>
 * {@link AppInitializer} extension for defining application dependencies initialization on release builds.
 */
public class ReleaseAppInitializer extends AppInitializer {

    @Override
    protected void initAppDependencies(StarterApp app) {
        Timber.plant(new CrashlyticsTree(app));
    }
}
