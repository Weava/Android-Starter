package com.appweava.androidstarterdata.feature.repository;

import com.appweava.androidstarterdata.feature.MvpDataEntity;
import com.appweava.androidstarterdata.feature.MvpDataEntityMapper;
import com.appweava.androidstarterdata.mapper.EntityMapper;
import com.appweava.androidstarterdomain.feature.MvpData;
import com.appweava.androidstarterdomain.feature.MvpRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 * MvpDataRepository
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/28/16
 */
@Singleton
public class MvpDataRepository implements MvpRepository {

    private final MvpDataStoreFactory mvpDataStoreFactory;
    private final EntityMapper<MvpDataEntity, MvpData> entityMapper;

    @Inject
    public MvpDataRepository(MvpDataStoreFactory mvpDataStoreFactory,
                             MvpDataEntityMapper entityMapper) {
        this.mvpDataStoreFactory = mvpDataStoreFactory;
        this.entityMapper = entityMapper;
    }

    @Override
    public Observable<List<MvpData>> getMvpModelList() {
        final MvpDataStore dataStore = mvpDataStoreFactory.create();
        return dataStore.getMvpEntityList().map(new Func1<List<MvpDataEntity>, List<MvpData>>() {

            @Override
            public List<MvpData> call(List<MvpDataEntity> mvpDataEntities) {
                return entityMapper.transformToDomain(mvpDataEntities);
            }
        });
    }
}
