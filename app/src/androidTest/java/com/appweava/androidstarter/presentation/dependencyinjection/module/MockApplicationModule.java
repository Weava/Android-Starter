package com.appweava.androidstarter.presentation.dependencyinjection.module;

import android.content.Context;

import com.appweava.androidstarter.data.ObservableSchedulerManager;
import com.appweava.androidstarter.AppInitializer;
import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarter.presentation.base.TestObservableSchedulerManager;

import io.reactivex.Scheduler;

/**
 * MockApplicationModule
 * <p>
 * Provides mock application dependencies.
 * TODO: Properly decide what to do with dependencies
 */
public class MockApplicationModule extends ApplicationModule {

    public MockApplicationModule(StarterApp app) {
        super(app);
    }

    @Override
    Context provideApplicationContext() {
        return app;
    }

    @Override
    AppInitializer provideAppInitializer() {
        return null;
    }

    @Override
    ObservableSchedulerManager provideTransformerManager(@ExecThread Scheduler executionThread, @PostExecThread Scheduler postExecutionThread) {
        return new TestObservableSchedulerManager(executionThread, postExecutionThread);
    }
}
