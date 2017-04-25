package com.appweava.androidstarter.presentation.dependencyinjection.module;

import com.appweava.androidstarter.data.ObservableSchedulerManager;
import com.appweava.androidstarter.data.feature.MvpApi;
import com.appweava.androidstarter.data.feature.MvpDataRepository;
import com.appweava.androidstarter.data.feature.MvpRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    MvpRepository provideMvpRepository(MvpApi mvpApi, ObservableSchedulerManager observableSchedulerManager) {
        return new MvpDataRepository(mvpApi, observableSchedulerManager);
    }
}
