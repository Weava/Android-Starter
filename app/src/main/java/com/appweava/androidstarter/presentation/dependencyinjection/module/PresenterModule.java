package com.appweava.androidstarter.presentation.dependencyinjection.module;

import com.appweava.androidstarter.data.feature.MvpInteractor;
import com.appweava.androidstarter.presentation.feature.MvpContract;
import com.appweava.androidstarter.presentation.feature.MvpPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    MvpContract.Presenter provideMvpContractPresenter(MvpInteractor mvpInteractor) {
        return new MvpPresenter(mvpInteractor);
    }
}
