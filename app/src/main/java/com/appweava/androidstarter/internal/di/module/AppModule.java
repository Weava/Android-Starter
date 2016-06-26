package com.appweava.androidstarter.internal.di.module;

import android.content.Context;

import com.appweava.androidstarter.StarterApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * AppModule
 * <p>
 * Application module to gather dependencies that are used application wide.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
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
}
