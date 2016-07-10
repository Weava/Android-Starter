package com.appweava.androidstarter.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appweava.androidstarter.internal.di.HasComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * BaseFragment
 * <p>
 * Base class containing common functionality for most {@link Fragment}s
 *
 * @author <a href="mailto:aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public abstract class BaseFragment extends Fragment {

    protected Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setHasOptionsMenu(true);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(getLayoutRes(), container, false);
        unbinder = ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

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

    @LayoutRes
    protected abstract int getLayoutRes();
}
