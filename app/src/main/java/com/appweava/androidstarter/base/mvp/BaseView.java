package com.appweava.androidstarter.base.mvp;

/**
 * BaseView
 * <p>
 * <p>
 * Interface for explicitly defining what view interfaces should participate in this application's
 * MVP structure.
 * <p>
 * Sample of interface extending BaseView
 * {@code
 * public interface MyView extends BaseView {
 * <p>
 * // Sets list of things in implementing Activity, Fragment, or Custom View
 * void setListOfThings(List<Thing> things);
 * }
 * }
 * <p>
 * <p>
 * Any common methods that will be used in most, if not, all presenter implementations should be
 * put here.
 */
public interface BaseView {
}
