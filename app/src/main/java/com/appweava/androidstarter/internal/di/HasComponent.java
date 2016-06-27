package com.appweava.androidstarter.internal.di;

/**
 * HasComponent
 * <p>
 * Interface for clients that contain a dependency injection component that requests said
 * component.
 *
 * @author <a href="mailto:aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public interface HasComponent<C> {
    C getComponent();
}
