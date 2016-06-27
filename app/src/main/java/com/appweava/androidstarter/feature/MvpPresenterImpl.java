package com.appweava.androidstarter.feature;

import com.appweava.androidstarterdomain.interactor.UseCase;

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
public class MvpPresenterImpl implements MvpPresenter {

    private MvpView mMvpView;
    private UseCase mMvpUseCase;

    @Inject
    public MvpPresenterImpl(MvpView mvpView, UseCase mvpUseCase) {
        mMvpView = mvpView;
        mMvpUseCase = mvpUseCase;
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
}
