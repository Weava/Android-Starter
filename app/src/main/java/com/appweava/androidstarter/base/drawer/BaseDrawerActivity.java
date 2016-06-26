package com.appweava.androidstarter.base.drawer;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.appweava.androidstarter.base.BaseActivity;

/**
 * BaseDrawerActivity
 * <p>
 * Extension of {@link BaseActivity} containing functions relative to an activity with a drawer.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/25/16
 */
public abstract class BaseDrawerActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            //TODO: Set icon for drawer menu
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
