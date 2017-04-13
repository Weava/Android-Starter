package com.appweava.androidstarterdata.feature.net;

import com.appweava.androidstarterdomain.feature.MvpData;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * MvpApiImpl
 * <p>
 * Mock implementation of the {@link MvpApi}. Gets data locally for debug purposes.
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
