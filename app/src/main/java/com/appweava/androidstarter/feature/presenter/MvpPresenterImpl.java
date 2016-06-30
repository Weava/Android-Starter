package com.appweava.androidstarter.feature.presenter;

import android.support.annotation.NonNull;

import com.appweava.androidstarter.feature.MvpView;
import com.appweava.androidstarter.internal.di.ActivityScope;
import com.appweava.androidstarterdomain.feature.MvpModel;
import com.appweava.androidstarterdomain.interactor.UseCase;
import com.appweava.androidstarterdomain.interactor.rx.RxCallback;
import com.appweava.androidstarterdomain.interactor.rx.RxSubscriber;

import java.util.List;

import javax.inject.Inject;

/**
 * MvpPresenter
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
@ActivityScope
public class MvpPresenterImpl implements MvpPresenter {

    private MvpView mMvpView;
    private UseCase mMvpUseCase;

    @Inject
    public MvpPresenterImpl(UseCase mvpUseCase) {
        mMvpUseCase = mvpUseCase;
    }

    public void setView(@NonNull MvpView mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void resume() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void init() {

    }

    @Override
    public void getMvpList(RxCallback<List<MvpModel>> mvpCallback) {
        mMvpUseCase.execute(new RxSubscriber<>(mvpCallback));
    }
}
