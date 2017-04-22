package com.appweava.androidstarter.dependencyinjection.module;

import android.content.Context;

import com.appweava.androidstarter.AppInitializer;
import com.appweava.androidstarter.DebugAppInitializer;
import com.appweava.androidstarter.StarterApp;

import dagger.Module;

/**
 * DebugAppModule
 * <p>
 * {@link Module} that provides application level dependencies
 */
public class DebugApplicationModule extends ApplicationModule {

    public DebugApplicationModule(StarterApp app) {
        super(app);
    }

    @Override
    AppInitializer provideAppInitializer() {
        return new DebugAppInitializer();
    }

    @Override
    Context provideApplicationContext() {
        return app;
    }
}
