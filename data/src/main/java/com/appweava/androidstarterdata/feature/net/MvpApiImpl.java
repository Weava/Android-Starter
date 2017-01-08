package com.appweava.androidstarterdata.feature.net;

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

        mvpDataEntities.add(MvpData.builder().someField("One").build());
        mvpDataEntities.add(MvpData.builder().someField("Two").build());
        mvpDataEntities.add(MvpData.builder().someField("Three").build());
        mvpDataEntities.add(MvpData.builder().someField("Four").build());

        return Observable.just(mvpDataEntities);
    }
}
