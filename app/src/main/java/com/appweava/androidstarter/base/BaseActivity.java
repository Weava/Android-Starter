package com.appweava.androidstarter.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.appweava.androidstarter.R;
import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarter.base.mvp.BaseView;
import com.appweava.androidstarter.base.mvp.Presenter;
import com.appweava.androidstarter.internal.di.component.AppGraph;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * BaseActivity
 * <p>
 * Abstract base activity class containing common functionality for most
 * {@link android.app.Activity}s
 *
 * @author <a href="mailto:aaron@appweava.com">Aaron Weaver</a>
 * @date 6/25/16
 * @since 1.0.0
 */
public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    protected boolean isBackNav = false;
    private Unbinder unbinder;
    private Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());

        unbinder = ButterKnife.bind(this);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    /**
     * Get the layout resource to be used by this activity.
     *
     * @return
     *      {@link LayoutRes} identifier for layout resource
     */
    @LayoutRes
    protected int getLayoutRes() {
        /*
         * NOTE: base_activity.xml is only to be used as your layout if you plan on having a
         * fragment as your main view portion. Otherwise, create a custom view for your activity, and
         * make sure to both include toolbar.xml.
         */
        return R.layout.base_activity;
    }

    /**
     * Invoke to enable back navigation from the toolbar.
     */
    protected void enableBackNav() {
        if (getSupportActionBar() != null) {
            isBackNav = true;
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }

    /**
     * Get {@link StarterApp} reference.
     *
     * @return
     *      {@link StarterApp}
     */
    public StarterApp getStarterApp() {
        return (StarterApp) getApplication();
    }

    /**
     * Retrieves app level dependency graph ({@link AppGraph}) for injecting.
     *
     * @return
     *      {@link AppGraph}
     */
    protected AppGraph getInjector() {
        return getStarterApp().getAppComponent();
    }

    /**
     * Set the title of the toolbar.
     *
     * @param title
     *      The title to set for the toolbar
     */
    public void setActivityTitle(@NonNull String title) {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home && isBackNav) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();

        if (presenter != null) {
            presenter.detachView();
            presenter.releaseAllSubscriptions();
        }
    }

    @SuppressWarnings("unchecked")
    protected void attachPresenterToLifecycle(Presenter presenter, BaseView view) {
        this.presenter = presenter;
        this.presenter.attachView(view);
    }
}
