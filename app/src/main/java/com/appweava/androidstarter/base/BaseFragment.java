package com.appweava.androidstarter.base;

import android.app.Fragment;

import com.appweava.androidstarter.internal.di.HasComponent;

/**
 * BaseFragment
 * <p>
 * Base class containing common functionality for most {@link Fragment}s
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public abstract class BaseFragment extends Fragment {

    /**
     * Gets component for dependency injection based on type.
     *
     * @param componentType
     *      The type of the component
     * @param <C>
     *      Generic type of the component
     * @return
     *      The component to be returned
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }
}
