package com.appweava.androidstarter.internal.di.module;

import android.content.Context;

import com.appweava.androidstarter.AppInitializer;
import com.appweava.androidstarter.ReleaseAppInitializer;
import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarter.UiThread;
import com.appweava.androidstarterdata.executor.RxExecutor;
import com.appweava.androidstarterdomain.executor.ExecutionThread;
import com.appweava.androidstarterdomain.executor.PostExecutionThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * ReleaseApplicationModule
 * <p>
 * {@link Module} that defines application level dependencies for release builds.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/24/16
 */
@Module
public class ReleaseApplicationModule {

    private StarterApp app;

    public ReleaseApplicationModule(StarterApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    AppInitializer provideAppInitializer() {
        return new ReleaseAppInitializer();
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
