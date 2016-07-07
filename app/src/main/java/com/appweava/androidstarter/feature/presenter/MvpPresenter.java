package com.appweava.androidstarter.feature.presenter;

import com.appweava.androidstarter.base.BasePresenter;

/**
 * MvpPresenter
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public interface MvpPresenter extends BasePresenter {

    void init();

    void getMvpList();
}
