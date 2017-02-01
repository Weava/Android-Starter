package com.appweava.androidstarter.base.mvp;

/**
 * ViewNotAttachedException
 * <p>
 * <p>
 * {@link RuntimeException} for throwing when a presenter tries to interact with a {@link BaseView}
 * that has not been attached.
 */
public class ViewNotAttachedException extends RuntimeException {

    public ViewNotAttachedException() {
        super("View must be attached to presenter by calling `attachView(view)` " +
                "before attempting to perform view operations");
    }
}
