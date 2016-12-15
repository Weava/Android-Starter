package com.appweava.androidstarter.base.mvp;

import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

import rx.subscriptions.CompositeSubscription;

/**
 * BasePresenter
 * <p>
 * Base {@link Presenter} implementation. Contains all functions that most presenters in the
 * application may need. Uses view interfaces (interfaces extending {@link BaseView}) to interact
 * with the view.
 *
 * To actually interact with the view, you will first need to call {@code attachView(BaseView view)}
 * then use {@code getView()} to retrieve the view and all it's operations.
 *
 * Sample of extending BasePresenter
 * {@code
 *      // MyView will be the view interface implementation that you wish the presenter to
 *      // interface with.
 *      public MyPresenter extends BasePresenter<MyView>
 * }
 *
 * Attaching a view is usually performed when a view is created. This usually means attaching occurs
 * during onCreate (in Activitys), onViewCreated (in Fragments), or when inflating a view (in Custom View).
 *
 * Detaching would occur when the view is destroyed or brought out of focus. This usually means
 * means detaching occurs during onDestroy (in Activitys), onViewDestroyed (in Fragments), or
 * when destroying a custom view.
 *
 * @see Presenter
 * @see BaseView
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/19/16
 */
public abstract class BasePresenter<V extends BaseView> implements Presenter<V> {

    private WeakReference<V> viewRef;
    private CompositeSubscription subscriptions;

    @Override
    public void attachView(@NonNull V view) {
        viewRef = new WeakReference<>(view);
        onViewAttached();
    }

    @Override
    public void detachView() {
        viewRef.clear();
        viewRef = null;
        onViewDetached();
    }

    /**
     * Unsubscribe from all current {@link rx.Subscription}s contained within the
     * {@link CompositeSubscription}.
     */
    protected void unsubCompositeSubscription() {
        if (subscriptions != null
                && subscriptions.hasSubscriptions() && !subscriptions.isUnsubscribed()) {
            subscriptions.unsubscribe();
        }
    }

    /**
     * Method to be called when view is detached. Make sure to override this method in implementing
     * classes if you want to have an actual implementation.
     */
    protected void onViewAttached() {}

    /**
     * Method to be called when view is detached. Make sure to override this method in implementing
     * classes if you want more than just the default implementation.
     */
    protected void onViewDetached() {
        unsubCompositeSubscription();
    }

    /**
     * Retrieve the {@link BaseView} extended view item to perform operations on.
     *
     * @throws ViewNotAttachedException
     *
     * @return
     *      {@link BaseView} extended item
     */
    protected V getView() {
        if (isViewAttached()) {
            return viewRef.get();
        }

        throw new ViewNotAttachedException();
    }

    /**
     * Retrieve the {@link CompositeSubscription} to manage lifecycle of Rx calls within
     * presenter.
     *
     * @return
     *      {@link CompositeSubscription}
     */
    protected CompositeSubscription getSubs() {
        if (subscriptions == null) {
            subscriptions = new CompositeSubscription();
        }

        return subscriptions;
    }

    /**
     * Determines if a view has been attached to the presenter or not.
     *
     * @return
     *      {@link Boolean} view attached status
     */
    protected boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }
}