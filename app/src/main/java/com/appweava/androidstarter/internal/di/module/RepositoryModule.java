package com.appweava.androidstarter.internal.di.module;

import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.appweava.androidstarterdata.feature.repository.MvpDataRepository;
import com.appweava.androidstarterdomain.feature.MvpRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    MvpRepository provideMvpRepository(MvpApi mvpApi) {
        return new MvpDataRepository(mvpApi);
    }
}
