package com.appweava.androidstarter.feature;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.appweava.androidstarter.base.drawer.BaseDrawerActivity;

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
    MvpPresenter mvpPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getInjector().inject(this);
        attachPresenterToLifecycle(mvpPresenter, this);

        mvpPresenter.getMvpList();
    }

    @Override
    public void toggleLoadingView() {

    }

    @Override
    public void doSomeOtherViewStuff() {

    }
}
