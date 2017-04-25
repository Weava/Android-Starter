package com.appweava.androidstarter.data.feature;

import java.util.List;

import io.reactivex.Observable;

public class MvpInteractorImpl implements MvpInteractor {

    private MvpRepository repository;

    public MvpInteractorImpl(MvpRepository mvpRepository) {
        this.repository = mvpRepository;
    }

    @Override
    public Observable<List<MvpData>> getMvpList() {
        return repository.getMvpModelList();
    }
}
