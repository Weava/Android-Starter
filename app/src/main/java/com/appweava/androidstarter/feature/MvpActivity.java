package com.appweava.androidstarter.feature;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarter.base.drawer.BaseDrawerActivity;
import com.appweava.androidstarter.feature.presenter.MvpPresenterImpl;
import com.appweava.androidstarter.internal.di.module.ActivityModule;
import com.appweava.androidstarterdomain.feature.MvpModel;
import com.appweava.androidstarterdomain.interactor.rx.RxCallback;

import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * MvpActivity
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public class MvpActivity extends BaseDrawerActivity implements MvpView, RxCallback<List<MvpModel>> {
    
    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, MvpActivity.class);
        return intent;    
    }

    @Inject
    MvpPresenterImpl mMvpPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerMvpComponent.builder()
                .appComponent(StarterApp.getInstance().getAppComponent())
                .activityModule(new ActivityModule(this))
                .mvpModule(new MvpModule())
                .build().inject(this);

        mMvpPresenter.getMvpList(this);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void doSomeOtherViewStuff() {

    }

    @Override
    public void onDataReady(List<MvpModel> item) {
        for (MvpModel mvpModel : item) {
            Timber.tag("Mvp Activity").i("Model: %s", mvpModel.getSomeField());
        }
    }

    @Override
    public void onDataError(Throwable t) {
        Timber.tag("Mvp Activity Error").e("%s", t.getMessage());
    }
}
