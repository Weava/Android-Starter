package com.appweava.androidstarter.feature;

import com.appweava.androidstarter.base.mvp.BasePresenter;
import com.appweava.androidstarterdomain.feature.MvpData;

import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * MvpPresenter
 * <p>
 * Implementation {@link MvpPresenter}. Used as a simple example.
 */
public class MvpPresenter extends BasePresenter<MvpView> {

    @Inject
    public MvpPresenter() {
    }

    @Override
    protected void onViewAttached() {
        // Perform any necessary calls when the view gets attached here.
    }

    @Override
    protected void onViewDetached() {
        disposeComposites();
    }

    void getMvpList() {
        getView().doSomeOtherViewStuff();
    }

    private void onDataReady(List<MvpData> data) {
        for (MvpData mvpModel : data) {
            Timber.tag("Mvp Activity").i("Model: %s", mvpModel.someField());
        }
    }
}
