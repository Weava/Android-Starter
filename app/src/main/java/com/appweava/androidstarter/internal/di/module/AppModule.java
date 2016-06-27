package com.appweava.androidstarter.internal.di.module;

import android.content.Context;

import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarter.UiThread;
import com.appweava.androidstarterdata.executor.JobExecutor;
import com.appweava.androidstarterdomain.executor.PostExecutionThread;
import com.appweava.androidstarterdomain.executor.ThreadExecutor;

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
public class AppModule {
    private final StarterApp mApp;

    public AppModule(StarterApp app) {
        mApp = app;
    }

    @Singleton
    @Provides
    Context provideApplicationContext() {
        return this.mApp;
    }

    @Singleton
    @Provides
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Singleton
    @Provides
    PostExecutionThread providePostExecutionThread(UiThread uiThread) {
        return uiThread;
    }
}
