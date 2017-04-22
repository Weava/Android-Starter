package com.appweava.androidstarter.dependencyinjection.module;

import com.appweava.androidstarter.feature.MvpContract;
import com.appweava.androidstarter.feature.MvpPresenter;
import com.appweava.androidstarterdomain.feature.MvpInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    MvpContract.Presenter provideMvpContractPresenter(MvpInteractor mvpInteractor) {
        return new MvpPresenter(mvpInteractor);
    }
}
