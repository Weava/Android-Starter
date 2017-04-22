package com.appweava.androidstarter.dependencyinjection.module;

import android.app.Application;
import android.content.Context;
import android.preference.PreferenceManager;

import com.appweava.androidstarter.AppInitializer;
import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarter.base.AppObservableSchedulerManager;
import com.appweava.androidstarterdomain.interactor.ObservableSchedulerManager;
import com.f2prateek.rx.preferences2.RxSharedPreferences;

import javax.inject.Qualifier;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public class ApplicationModule {

    @Qualifier
    public @interface PostExecThread {}

    @Qualifier
    public @interface ExecThread {}

    protected StarterApp app;

    public ApplicationModule(StarterApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    AppInitializer provideAppInitializer() {
        return null;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return app;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return app;
    }

    @ExecThread
    @Provides
    @Singleton
    Scheduler provideThreadExecutor() {
        return Schedulers.io();
    }

    @PostExecThread
    @Provides
    @Singleton
    Scheduler providePostExecutionThread() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    ObservableSchedulerManager provideTransformerManager(@ExecThread Scheduler executionThread,
                                                         @PostExecThread Scheduler postExecutionThread) {
        return new AppObservableSchedulerManager(postExecutionThread, executionThread);
    }

    @Provides
    @Singleton
    RxSharedPreferences provideRxSharedPreferences(Context context) {
        return RxSharedPreferences.create(PreferenceManager.getDefaultSharedPreferences(context));
    }
}
