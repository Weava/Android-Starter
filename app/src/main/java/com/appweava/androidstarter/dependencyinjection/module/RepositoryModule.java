package com.appweava.androidstarter.dependencyinjection.module;

import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.appweava.androidstarterdata.feature.repository.MvpDataRepository;
import com.appweava.androidstarterdomain.feature.MvpRepository;
import com.appweava.androidstarterdomain.interactor.ObservableSchedulerManager;

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
