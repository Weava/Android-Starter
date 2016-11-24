package com.appweava.androidstarterdata.feature.repository;

import com.appweava.androidstarterdomain.feature.MvpData;
import com.appweava.androidstarterdomain.feature.MvpRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * MvpDataRepository
 * <p>
 * Implementation of {@link MvpRepository}.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/28/16
 */
@Singleton
public class MvpDataRepository implements MvpRepository {

    private final MvpDataStoreFactory mvpDataStoreFactory;

    @Inject
    public MvpDataRepository(MvpDataStoreFactory mvpDataStoreFactory) {
        this.mvpDataStoreFactory = mvpDataStoreFactory;
    }

    @Override
    public Observable<List<MvpData>> getMvpModelList() {
        final MvpDataStore dataStore = mvpDataStoreFactory.create();
        return dataStore.getMvpEntityList();
    }
}
