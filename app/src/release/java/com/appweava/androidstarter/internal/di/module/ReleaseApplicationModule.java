package com.appweava.androidstarter.internal.di.module;

import com.appweava.androidstarter.AppInitializer;
import com.appweava.androidstarter.ReleaseAppInitializer;
import com.appweava.androidstarter.StarterApp;

/**
 * ReleaseApplicationModule
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/24/16
 */
public class ReleaseApplicationModule extends ApplicationModule {

    public ReleaseApplicationModule(StarterApp app) {
        super(app);
    }

    @Override
    AppInitializer provideAppInitializer() {
        return new ReleaseAppInitializer();
    }
}
