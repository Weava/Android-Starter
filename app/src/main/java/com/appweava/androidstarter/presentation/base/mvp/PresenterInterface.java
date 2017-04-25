package com.appweava.androidstarter.presentation.base.mvp;

/**
 * Presenter
 * <p>
 * Interface defining common methods for all presenters. Also defines that all presenters must
 * attach some sort of {@link BaseView}
 *
 * @see BaseView
 */
public interface PresenterInterface<T> {

    void attachView(T view);

    void detachView();
}
