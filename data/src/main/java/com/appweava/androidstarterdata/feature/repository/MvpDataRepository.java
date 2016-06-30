package com.appweava.androidstarterdata.feature.repository;

import com.appweava.androidstarterdata.feature.MvpDataEntity;
import com.appweava.androidstarterdata.feature.MvpDataEntityMapper;
import com.appweava.androidstarterdata.mapper.EntityMapper;
import com.appweava.androidstarterdomain.feature.MvpModel;
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

    private final MvpDataStoreFactory mMvpDataStoreFactory;
    private final EntityMapper<MvpDataEntity, MvpModel> mEntityMapper;

    @Inject
    public MvpDataRepository(MvpDataStoreFactory mvpDataStoreFactory,
                             MvpDataEntityMapper entityMapper) {
        mMvpDataStoreFactory = mvpDataStoreFactory;
        mEntityMapper = entityMapper;
    }

    @Override
    public Observable<List<MvpModel>> getMvpModelList() {
        final MvpDataStore dataStore = mMvpDataStoreFactory.create();
        return dataStore.getMvpEntityList().map(new Func1<List<MvpDataEntity>, List<MvpModel>>() {

            @Override
            public List<MvpModel> call(List<MvpDataEntity> mvpDataEntities) {
                return mEntityMapper.transform(mvpDataEntities);
            }
        });
    }
}
