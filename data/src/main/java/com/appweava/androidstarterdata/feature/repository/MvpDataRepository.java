package com.appweava.androidstarterdata.feature.repository;

import com.appweava.androidstarterdata.base.StoreObjects;
import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.appweava.androidstarterdomain.feature.MvpData;
import com.appweava.androidstarterdomain.feature.MvpRepository;
import com.nytimes.android.external.store.base.Store;
import com.nytimes.android.external.store.base.impl.BarCode;
import com.nytimes.android.external.store.base.impl.StoreBuilder;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * MvpDataRepository
 * <p>
 * Implementation of {@link MvpRepository}.
 */
@Singleton
public class MvpDataRepository implements MvpRepository {

    private final StoreObjects storeObjects;
    private final MvpApi mvpApi;

    @Inject
    public MvpDataRepository(StoreObjects storeObjects, MvpApi mvpApi) {
        this.storeObjects = storeObjects;
        this.mvpApi = mvpApi;
    }

    @Override
    public Observable<List<MvpData>> getMvpModelList() {
        Store<List<MvpData>> store = StoreBuilder.<List<MvpData>>builder()
                .fetcher((barCode) -> mvpApi.getMvpEntityList())
                .persister(storeObjects.getDefaultPersister())
                .open();

        return store.get(new BarCode("Mvp Data List", "list"));
    }
}
