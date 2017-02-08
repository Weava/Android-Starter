package com.appweava.androidstarter.internal.di.module;

import android.content.Context;

import com.appweava.androidstarter.AppInitializer;
import com.appweava.androidstarter.StarterTestApp;
import com.appweava.androidstarter.UiThread;
import com.appweava.androidstarter.base.TestTransformerManager;
import com.appweava.androidstarterdata.executor.RxExecutor;
import com.appweava.androidstarterdomain.executor.ExecutionThread;
import com.appweava.androidstarterdomain.executor.PostExecutionThread;
import com.appweava.androidstarterdomain.interactor.TransformerManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * MockApplicationModule
 * <p>
 * Provides mock application dependencies.
 * TODO: Properly decide what to do with dependencies
 */
@Module
public class MockApplicationModule {

    private StarterTestApp starterTestApp;

    public MockApplicationModule(StarterTestApp starterTestApp) {
        this.starterTestApp = starterTestApp;
    }

    @Singleton
    @Provides
    Context provideApplicationContext() {
        return starterTestApp;
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

    @Singleton
    @Provides
    AppInitializer provideAppInitializer() {
        return null;
    }

    @Singleton
    @Provides
    TransformerManager provideTransformerManager(ExecutionThread executionThread,
                                                 PostExecutionThread postExecutionThread) {
        return new TestTransformerManager(executionThread, postExecutionThread);
    }
}
