package com.appweava.androidstarter.internal.di.module;

import android.content.Context;

import com.appweava.androidstarter.AppInitializer;
import com.appweava.androidstarter.DebugAppInitializer;
import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarter.UiThread;
import com.appweava.androidstarterdata.executor.RxExecutor;
import com.appweava.androidstarterdomain.executor.ExecutionThread;
import com.appweava.androidstarterdomain.executor.PostExecutionThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * DebugAppModule
 * <p>
 * {@link Module} that provides application level dependencies
 */
@Module
public class DebugApplicationModule {

    private StarterApp app;

    public DebugApplicationModule(StarterApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    AppInitializer provideAppInitializer() {
        return new DebugAppInitializer();
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return app;
    }

    @Provides
    @Singleton
    ExecutionThread provideThreadExecutor(RxExecutor rxExecutor) {
        return rxExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UiThread uiThread) {
        return uiThread;
    }
}
