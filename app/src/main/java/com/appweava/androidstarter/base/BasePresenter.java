package com.appweava.androidstarter.base;

/**
 * BasePresenter
 * <p>
 * Presenter class from which all presenters should inherit. This contains common interface methods
 * that will likely be used by many presenters.
 *
 * @author <a href="mailto:aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public interface BasePresenter {

    /**
     * Method to be called in the onResume of an {@link android.app.Activity}'s lifecycle.
     */
    void resume();

    /**
     * Method to be called in the onDestroy of an {@link android.app.Activity}'s lifecycle.
     */
    void destroy();

    /**
     * Method to be called in the onPause of an {@link android.app.Activity}'s lifecycle.
     */
    void pause();
}
