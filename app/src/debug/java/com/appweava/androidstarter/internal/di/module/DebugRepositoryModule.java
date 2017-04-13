package com.appweava.androidstarter.internal.di.module;

import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.appweava.androidstarterdata.feature.repository.MvpDataRepository;
import com.appweava.androidstarterdomain.feature.MvpRepository;

import dagger.Module;

/**
 * DebugRepositoryModule
 * <p>
 * {@link Module} for providing repository pattern and data module dependencies
 */
public class DebugRepositoryModule extends RepositoryModule {

    @Override
    MvpRepository provideMvpRepository(MvpApi mvpApi) {
        return new MvpDataRepository(mvpApi);
    }
}
