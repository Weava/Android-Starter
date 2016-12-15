package com.appweava.androidstarter.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appweava.androidstarter.base.mvp.BaseView;
import com.appweava.androidstarter.base.mvp.Presenter;

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
    private Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        if (presenter != null) {
            presenter.detachView();
            presenter = null;
        }

        unbinder.unbind();
    }

    /**
     * Abstract method for setting the layout resource that the fragment will use as it's view.
     *
     * @return
     *      {@link LayoutRes} layout resource id.
     */
    @LayoutRes
    protected abstract int getLayoutRes();

    /**
     * Attaches presenter to lifecycle of activity.
     *
     * @param presenter
     *      {@link Presenter}
     * @param view
     *      {@link BaseView}
     */
    @SuppressWarnings("unchecked")
    protected void attachPresenterToLifecycle(Presenter presenter, BaseView view) {
        this.presenter = presenter;
        this.presenter.attachView(view);
    }
}
