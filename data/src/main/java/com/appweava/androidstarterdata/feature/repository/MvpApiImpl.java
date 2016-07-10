package com.appweava.androidstarterdata.feature.repository;

import com.appweava.androidstarterdata.feature.MvpDataEntity;
import com.appweava.androidstarterdata.feature.net.MvpApi;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * MvpApiImpl
 * <p>
 * Mock implementation of the {@link MvpApi}. Gets data locally for debug purposes.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/29/16
 */
public class MvpApiImpl implements MvpApi {

    @Override
    public Observable<List<MvpDataEntity>> getMvpEntityList() {

        List<MvpDataEntity> mvpDataEntities = new ArrayList<>();

        mvpDataEntities.add(new MvpDataEntity("Number One"));
        mvpDataEntities.add(new MvpDataEntity("Number Two"));
        mvpDataEntities.add(new MvpDataEntity("Number Three"));
        mvpDataEntities.add(new MvpDataEntity("Number Four"));

        return Observable.just(mvpDataEntities);
    }
}
