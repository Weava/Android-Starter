package com.appweava.androidstarter.test.feature.presenter;

import com.appweava.androidstarter.base.BasePresenter;
import com.appweava.androidstarterdomain.feature.MvpData;

/**
 * MvpPresenter
 * <p>
 * Presenter interface for any views related to Mvp feature.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public interface MvpPresenter extends BasePresenter {

    /**
     * Get list of {@link MvpData} objects.
     */
    void getMvpList();
}
