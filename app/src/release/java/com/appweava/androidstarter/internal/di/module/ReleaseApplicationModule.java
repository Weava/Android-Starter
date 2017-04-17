package com.appweava.androidstarter.internal.di.module;

import com.appweava.androidstarter.AppInitializer;
import com.appweava.androidstarter.ReleaseAppInitializer;
import com.appweava.androidstarter.StarterApp;

import dagger.Module;

/**
 * ReleaseApplicationModule
 * <p>
 * {@link Module} that defines application level dependencies for release builds.
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
