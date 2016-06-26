package com.appweava.androidstarter.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.appweava.androidstarter.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * BaseActivity
 * <p>
 * Abstract base activity class containing common functionality for most
 * {@link android.app.Activity}s
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @date 6/25/16
 * @since 1.0.0
 */
public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    protected boolean mIsBackNav = false;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());

        mUnbinder = ButterKnife.bind(this);

        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
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
            mIsBackNav = true;
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
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
        if(item.getItemId() == android.R.id.home && mIsBackNav) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
