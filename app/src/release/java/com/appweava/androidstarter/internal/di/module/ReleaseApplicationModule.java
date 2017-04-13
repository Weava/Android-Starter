package com.appweava.androidstarter.internal.di.module;

import android.content.Context;

import com.appweava.androidstarter.AppInitializer;
import com.appweava.androidstarter.ReleaseAppInitializer;
import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarterdomain.interactor.ObservableSchedulerManager;

import dagger.Module;
import io.reactivex.Scheduler;

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

    @Override
    Context provideApplicationContext() {
        return app;
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
        return super.provideTransformerManager(executionThread, postExecutionThread);
    }
}
