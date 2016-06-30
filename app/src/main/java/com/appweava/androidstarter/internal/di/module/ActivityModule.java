package com.appweava.androidstarter.internal.di.module;

import android.app.Activity;

import com.appweava.androidstarter.internal.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * ActivityModule
 * <p>
 * Module containing dependencies that are core to every activity within this application.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/29/16
 */
@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity() {
        return this.mActivity;
    }
}
