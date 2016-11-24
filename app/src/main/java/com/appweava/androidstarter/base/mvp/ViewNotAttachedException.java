package com.appweava.androidstarter.base.mvp;

/**
 * ViewNotAttachedException
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/19/16
 */
public class ViewNotAttachedException extends RuntimeException {

    public ViewNotAttachedException() {
        super("View must be attached to presenter by calling `attachView(view)` " +
                "before attempting to perform view operations");
    }
}
