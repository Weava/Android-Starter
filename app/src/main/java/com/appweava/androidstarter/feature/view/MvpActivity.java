package com.appweava.androidstarter.feature.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarter.base.drawer.BaseDrawerActivity;
import com.appweava.androidstarter.test.feature.DaggerMvpComponent;
import com.appweava.androidstarter.feature.MvpComponent;
import com.appweava.androidstarter.feature.MvpModule;
import com.appweava.androidstarter.feature.presenter.MvpPresenterImpl;
import com.appweava.androidstarter.internal.di.module.ActivityModule;

import javax.inject.Inject;

/**
 * MvpActivity
 * <p>
 * Activity pertaining to mvp feature.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public class MvpActivity extends BaseDrawerActivity implements MvpView {
    
    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, MvpActivity.class);
        return intent;    
    }

    @Inject
    MvpPresenterImpl mvpPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        injectComponent();

        mvpPresenter.getMvpList();
    }

    /**
     * Using Dagger 2, inject {@link MvpComponent} dependencies into this activity.
     */
    private void injectComponent() {
        DaggerMvpComponent.builder()
                .appComponent(StarterApp.getInstance().getAppComponent())
                .activityModule(new ActivityModule(this))
                .mvpModule(new MvpModule())
                .build().inject(this);
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
}
