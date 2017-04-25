package com.appweava.androidstarter.presentation.base.ui;

import android.app.Activity;
import android.view.ViewGroup;

import static butterknife.ButterKnife.findById;

public interface ViewContainer {

    /** The root {@link android.view.ViewGroup} into which the activity should place its contents. */
    ViewGroup forActivity(Activity activity);

    /** An {@link ViewContainer} which returns the normal activity content view. */
    ViewContainer DEFAULT = activity -> findById(activity, android.R.id.content);
}
