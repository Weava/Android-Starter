package com.appweava.androidstarterdata.feature.repository;

import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.appweava.androidstarterdomain.feature.MvpRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * MvpDataStoreFactory
 * <p>
 * Factory class for making the right {@link MvpDataStore} needed for any {@link MvpRepository}
 * implementation.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/28/16
 */
@Singleton
public class MvpDataStoreFactory {

    @Inject
    public MvpDataStoreFactory() {}

    /**
     * Create an instance of {@link MvpDataStore}, determining which implementation is needed.
     *
     * @return
     *      {@link MvpDataStore} implementation determined
     */
    public MvpDataStore create() {
        return createCloudStore();
    }

    /**
     * Create a {@link CloudMvpDataStore} instance.
     *
     * @return
     *      {@link CloudMvpDataStore} instance
     */
    public MvpDataStore createCloudStore() {
        MvpApi api = new MvpApiImpl();

        return new CloudMvpDataStore(api);
    }
}
