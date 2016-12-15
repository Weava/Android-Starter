package com.appweava.androidstarter.internal.di.module;

import android.content.Context;

import com.appweava.androidstarter.AppInitializer;
import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarter.UiThread;
import com.appweava.androidstarterdata.executor.RxExecutor;
import com.appweava.androidstarterdomain.executor.ExecutionThread;
import com.appweava.androidstarterdomain.executor.PostExecutionThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * AppModule
 * <p>
 * Application module to gather dependencies that are used application wide.
 *
 * @author <a href="mailto:aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
@Module
public class ApplicationModule {
    private final StarterApp app;

    public ApplicationModule(StarterApp app) {
        this.app = app;
    }

    @Singleton
    @Provides
    Context provideApplicationContext() {
        return this.app;
    }

    @Singleton
    @Provides
    ExecutionThread provideThreadExecutor(RxExecutor rxExecutor) {
        return rxExecutor;
    }

    @Singleton
    @Provides
    PostExecutionThread providePostExecutionThread(UiThread uiThread) {
        return uiThread;
    }

    /**
     * WARNING: OVERRIDE THIS IN DIFFERENT BUILD TYPES, OR ELSE IT WON'T DO ANYTHING.
     */
    @Provides
    @Singleton
    AppInitializer provideAppInitializer() {
        return new AppInitializer() {
            @Override
            protected void initAppDependencies(StarterApp app) {}
        };
    }
}
