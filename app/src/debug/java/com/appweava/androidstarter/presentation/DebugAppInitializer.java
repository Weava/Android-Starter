package com.appweava.androidstarter.presentation;

import com.appweava.androidstarter.AppInitializer;
import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarter.presentation.debugdrawer.LumberYard;
import com.appweava.androidstarter.presentation.dependencyinjection.Injector;
import com.facebook.stetho.Stetho;
import com.jakewharton.threetenabp.AndroidThreeTen;
import com.squareup.leakcanary.LeakCanary;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * DebugAppInitializer
 * <p>
 * {@link AppInitializer} extension for defining application dependencies for Debug builds.
 */
public class DebugAppInitializer extends AppInitializer {

    @Inject LumberYard lumberYard;

    public DebugAppInitializer() {
        Injector.getInstance().getAppGraph().inject(this);
    }

    @Override
    protected void initAppDependencies(StarterApp app) {
        Timber.plant(new Timber.DebugTree());

        Stetho.initializeWithDefaults(app);

        LeakCanary.install(app);

        AndroidThreeTen.init(app);

        lumberYard.cleanUp();
        Timber.plant(lumberYard.tree());
    }
}
