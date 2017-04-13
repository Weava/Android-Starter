package com.appweava.androidstarter.internal.di.module;

import android.content.Context;

import com.appweava.androidstarter.AppInitializer;
import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarter.base.TestObservableSchedulerManager;
import com.appweava.androidstarterdomain.interactor.ObservableSchedulerManager;

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
    Scheduler provideThreadExecutor() {
        return super.provideThreadExecutor();
    }

    @Override
    Scheduler providePostExecutionThread() {
        return super.providePostExecutionThread();
    }

    @Override
    ObservableSchedulerManager provideTransformerManager(@ExecThread Scheduler executionThread, @PostExecThread Scheduler postExecutionThread) {
        return new TestObservableSchedulerManager(executionThread, postExecutionThread);
    }
}
