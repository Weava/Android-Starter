package com.appweava.androidstarter.base.mvp;

/**
 * Presenter
 * <p>
 * Interface defining common methods for all presenters. Also defines that all presenters must
 * attach some sort of {@link BaseView}
 *
 * @see BaseView
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/19/16
 */
public interface Presenter<T extends BaseView> {

    void attachView(T view);

    void detachView();
}
