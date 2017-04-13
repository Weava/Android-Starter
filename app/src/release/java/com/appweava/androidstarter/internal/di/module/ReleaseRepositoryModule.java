package com.appweava.androidstarter.internal.di.module;

import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.appweava.androidstarterdata.feature.repository.MvpDataRepository;
import com.appweava.androidstarterdomain.feature.MvpRepository;

import dagger.Module;

/**
 * ReleaseRepositoryModule
 * <p>
 * {@link Module} that defines repository and data module dependencies for release builds.
 */
public class ReleaseRepositoryModule extends RepositoryModule {

    @Override
    MvpRepository provideMvpRepository(MvpApi mvpApi) {
        return new MvpDataRepository(mvpApi);
    }
}
