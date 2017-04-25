package com.appweava.androidstarter.presentation.feature;

import com.appweava.androidstarter.data.feature.MvpInteractor;

import timber.log.Timber;

import static com.appweava.androidstarter.presentation.feature.MvpContract.View.State.LOADING;

/**
 * MvpPresenter
 * <p>
 * Implementation {@link MvpPresenter}. Used as a simple example.
 */
public class MvpPresenter extends MvpContract.Presenter {

    private MvpInteractor interactor;

    public MvpPresenter(MvpInteractor mvpInteractor) {
        this.interactor = mvpInteractor;
    }

    @Override
    protected void onViewAttached() {
        getView().setState(LOADING);
    }

    @Override
    protected void onViewDetached() {
        disposeComposites();
    }

    @Override
    public void getMvpList() {
        disposables().add(
            interactor.getMvpList()
                    .subscribe(
                            mvpList -> getView().setMvpListForView(mvpList),
                            throwable -> Timber.d(throwable, "Baed")
                    )
        );
    }
}
