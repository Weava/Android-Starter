package com.appweava.androidstarter.internal.di.module;

import com.appweava.androidstarter.AppInitializer;
import com.appweava.androidstarter.DebugAppInitializer;
import com.appweava.androidstarter.StarterApp;

/**
 * DebugAppModule
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/19/16
 */
public class DebugApplicationModule extends ApplicationModule {

    public DebugApplicationModule(StarterApp app) {
        super(app);
    }

    @Override
    AppInitializer provideAppInitializer() {
        return new DebugAppInitializer();
    }
}
