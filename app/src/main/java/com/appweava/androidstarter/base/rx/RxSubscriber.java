package com.appweava.androidstarter.base.rx;

import rx.Subscriber;

/**
 * RxSubscriber
 * <p>
 * Extension class for {@link Subscriber} to work with {@link RxCallback}. Makes creating
 * subscribers with callback functionality much simpler.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public class RxSubscriber<T> extends Subscriber<T> {

    private RxCallback<T> mCallback;

    public RxSubscriber(RxCallback<T> callback) {
        mCallback = callback;
    }

    @Override
    public void onCompleted() {
        if (!isUnsubscribed()) {
            this.unsubscribe();
        }
    }

    @Override
    public void onError(Throwable e) {
        mCallback.onDataError(e);
    }

    @Override
    public void onNext(T t) {
        mCallback.onDataReady(t);
    }
}
