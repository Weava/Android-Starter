package com.appweava.androidstarter.base.mvp;

import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

import rx.subscriptions.CompositeSubscription;

/**
 * BasePresenter
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/19/16
 */
public abstract class BasePresenter<V extends BaseView> implements Presenter<V> {

    private WeakReference<V> viewRef;
    protected CompositeSubscription subscriptions;

    @Override
    public void attachView(@NonNull V view) {
        viewRef = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        viewRef.clear();
        viewRef = null;
    }

    @Override
    public void releaseAllSubscriptions() {
        if (subscriptions != null
                && subscriptions.hasSubscriptions() && !subscriptions.isUnsubscribed()) {
            subscriptions.unsubscribe();
        }
    }

    protected V getView() {
        if (isViewAttached()) {
            return viewRef.get();
        }

        throw new ViewNotAttachedException();
    }

    protected boolean isViewAttached() {
        return viewRef.get() != null;
    }
}
