package com.appweava.androidstarter.base.rx;

/**
 * RxCallback
 * <p>
 * Simple callback interface to handle {@link RxSubscriber} states.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public interface RxCallback<T> {

    void onDataReady(T item);

    void onDataError(Throwable t);
}
