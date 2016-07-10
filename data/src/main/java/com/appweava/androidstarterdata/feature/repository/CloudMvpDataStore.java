package com.appweava.androidstarterdata.feature.repository;

import com.appweava.androidstarterdata.feature.MvpDataEntity;
import com.appweava.androidstarterdata.feature.net.MvpApi;

import java.util.List;

import rx.Observable;

/**
 * CloudMvpDataRepository
 * <p>
 * {@link MvpDataStore} containing information on how to get {@link MvpDataEntity} from
 * ~*~THE CLOUD~*~
 *
 * <p>
 * There might be other implementations for other datasources (Sqlite, cache, etc.). For this
 * starter app, I only have Cloud Data Store implemented.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/29/16
 */
public class CloudMvpDataStore implements MvpDataStore {

    private final MvpApi mvpApi;

    public CloudMvpDataStore(MvpApi mvpApi) {
        this.mvpApi = mvpApi;
    }

    @Override
    public Observable<List<MvpDataEntity>> getMvpEntityList() {
        return this.mvpApi.getMvpEntityList();
    }
}
