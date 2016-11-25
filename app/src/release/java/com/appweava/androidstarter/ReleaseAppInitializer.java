package com.appweava.androidstarter;

import timber.log.Timber;

/**
 * ReleaseAppInitializer
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/24/16
 */
public class ReleaseAppInitializer extends AppInitializer {

    @Override
    protected void initAppDependencies(StarterApp app) {
        Timber.plant(new CrashlyticsTree(app));
    }
}
