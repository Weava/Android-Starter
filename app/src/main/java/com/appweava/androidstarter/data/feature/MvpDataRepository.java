package com.appweava.androidstarter.data.feature;

import com.appweava.androidstarter.data.ObservableSchedulerManager;

import java.util.List;

import io.reactivex.Observable;

/**
 * MvpDataRepository
 * <p>
 * Implementation of {@link MvpRepository}.
 */
public class MvpDataRepository implements MvpRepository {

    private MvpApi mvpApi;
    private ObservableSchedulerManager schedulerManager;

    public MvpDataRepository(MvpApi mvpApi, ObservableSchedulerManager schedulerManager) {
        this.mvpApi = mvpApi;
        this.schedulerManager = schedulerManager;
    }

    @Override
    public Observable<List<MvpData>> getMvpModelList() {
        return this.mvpApi.getMvpEntityList()
                .compose(schedulerManager.applyMainSchedulers());
    }
}

