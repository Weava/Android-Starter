package com.appweava.androidstarter.internal.di.module;

import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.appweava.androidstarterdata.feature.repository.MvpDataRepository;
import com.appweava.androidstarterdomain.feature.MvpRepository;
import com.appweava.androidstarterdomain.interactor.ObservableSchedulerManager;

/**
 * MockRepositoryModule
 * <p>
 * Mock repository dependencies provider.
 * TODO: Properly decide what to do with dependencies
 */
public class MockRepositoryModule extends RepositoryModule {

    @Override
    MvpRepository provideMvpRepository(MvpApi mvpApi, ObservableSchedulerManager observableSchedulerManager) {
        return new MvpDataRepository(mvpApi, observableSchedulerManager);
    }
}
