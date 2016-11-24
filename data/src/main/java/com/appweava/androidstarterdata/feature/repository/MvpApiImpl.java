package com.appweava.androidstarterdata.feature.repository;

import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.appweava.androidstarterdomain.feature.MvpData;

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
    public Observable<List<MvpData>> getMvpEntityList() {

        List<MvpData> mvpDataEntities = new ArrayList<>();

        mvpDataEntities.add(new MvpData("Number One"));
        mvpDataEntities.add(new MvpData("Number Two"));
        mvpDataEntities.add(new MvpData("Number Three"));
        mvpDataEntities.add(new MvpData("Number Four"));

        return Observable.just(mvpDataEntities);
    }
}
