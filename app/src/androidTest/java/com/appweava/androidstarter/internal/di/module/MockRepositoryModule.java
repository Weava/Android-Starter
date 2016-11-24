package com.appweava.androidstarter.internal.di.module;

import com.appweava.androidstarterdata.feature.repository.MvpDataStoreFactory;
import com.appweava.androidstarterdomain.feature.MvpRepository;

import org.mockito.Mockito;

/**
 * MockRepositoryModule
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/23/16
 */
public class MockRepositoryModule extends RepositoryModule {

    @Override
    MvpRepository provideMvpRepository(MvpDataStoreFactory mvpDataStoreFactory) {
        return Mockito.mock(MvpRepository.class);
    }
}
