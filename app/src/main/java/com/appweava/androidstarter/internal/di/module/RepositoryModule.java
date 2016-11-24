package com.appweava.androidstarter.internal.di.module;

import com.appweava.androidstarterdata.feature.repository.MvpDataRepository;
import com.appweava.androidstarterdata.feature.repository.MvpDataStoreFactory;
import com.appweava.androidstarterdomain.feature.MvpRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * RepositoryModule
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/22/16
 */
@Module
public class RepositoryModule {

    @Provides
    @Singleton
    MvpRepository provideMvpRepository(MvpDataStoreFactory mvpDataStoreFactory) {
        return new MvpDataRepository(mvpDataStoreFactory);
    }
}
