package com.appweava.androidstarter.base.mvp;

/**
 * Presenter
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/19/16
 */
public interface Presenter<T extends BaseView> {

    void attachView(T view);

    void detachView();

    void releaseAllSubscriptions();
}
