package com.appweava.androidstarter.feature;

import com.appweava.androidstarter.base.mvp.BaseView;

/**
 * MvpView
 * <p>
 * Class containing special view instructions for {@link MvpActivity}
 */
public interface MvpView extends BaseView {

    /**
     * Show or hide loading view based on current state.
     */
    void toggleLoadingView();

    /**
     * In here for no reason honestly.
     */
    void doSomeOtherViewStuff();


}
