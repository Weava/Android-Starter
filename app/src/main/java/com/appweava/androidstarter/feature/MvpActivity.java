package com.appweava.androidstarter.feature;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.appweava.androidstarter.base.drawer.BaseDrawerActivity;

/**
 * MvpActivity
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public class MvpActivity extends BaseDrawerActivity implements MvpView {

    private MvpPresenter mMvpPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
