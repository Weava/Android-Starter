package com.appweava.androidstarter.internal.di.module;

import com.appweava.androidstarterdata.base.DefaultStoreObjects;
import com.appweava.androidstarterdata.base.StoreObjects;
import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.appweava.androidstarterdata.feature.repository.MvpDataRepository;
import com.appweava.androidstarterdomain.feature.MvpRepository;
import com.google.gson.Gson;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * ReleaseRepositoryModule
 * <p>
 * {@link Module} that defines repository and data module dependencies for release builds.
 */
@Module
public class ReleaseRepositoryModule {

    @Singleton
    @Provides
    StoreObjects provideStoreObjects(Gson gson, File file) {
        return new DefaultStoreObjects(gson, file);
    }

    @Singleton
    @Provides
    MvpRepository provideMvpRepository(StoreObjects storeObjects, MvpApi mvpApi) {
        return new MvpDataRepository(storeObjects, mvpApi);
    }
}
