package com.appweava.androidstarterdata.feature.repository;

import com.appweava.androidstarterdata.feature.net.MvpApi;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * MvpDataStoreFactory
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/28/16
 */
@Singleton
public class MvpDataStoreFactory {

    @Inject
    public MvpDataStoreFactory() {}

    public MvpDataStore create() {
        return getCloudStore();
    }

    private CloudMvpDataStore getCloudStore() {
        MvpApi api = new MvpApiImpl();

        return new CloudMvpDataStore(api);
    }
}
