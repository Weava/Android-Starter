package com.appweava.androidstarter.navigation;

import android.content.Context;
import android.content.Intent;

import com.appweava.androidstarter.feature.MvpActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Navigator
 * <p>
 * Handles all intent based navigation throughout the application.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/29/16
 */
@Singleton
public class Navigator {

    @Inject
    public Navigator() {}

    public void navigateToMvpActivity(Context context) {
        Intent intent = MvpActivity.getCallingIntent(context);
        context.startActivity(intent);
    }
}
