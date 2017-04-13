package com.appweava.androidstarterdata.feature.repository;

import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.appweava.androidstarterdomain.feature.MvpData;
import com.appweava.androidstarterdomain.feature.MvpRepository;

import java.util.List;

import io.reactivex.Observable;

/**
 * MvpDataRepository
 * <p>
 * Implementation of {@link MvpRepository}.
 */
public class MvpDataRepository implements MvpRepository {

    private MvpApi mvpApi;

    public MvpDataRepository(MvpApi mvpApi) {
        this.mvpApi = mvpApi;
    }

    @Override
    public Observable<List<MvpData>> getMvpModelList() {
        return this.mvpApi.getMvpEntityList();
    }
}
