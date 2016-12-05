package com.appweava.androidstarter.base.drawer;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.appweava.androidstarter.R;
import com.appweava.androidstarter.base.BaseActivity;

import butterknife.BindView;

/**
 * BaseDrawerActivity
 * <p>
 * Extension of {@link BaseActivity} containing functions relative to an activity with a
 * navigation drawer.
 *
 * @see BaseActivity
 * @see DrawerLayout
 * @see NavigationView
 *
 * @author <a href="mailto:aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/25/16
 */
public abstract class BaseDrawerActivity extends BaseActivity {

    @BindView(R.id.drawer_layout)
    protected DrawerLayout drawerLayout;

    @BindView(R.id.nav_drawer)
    protected NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            //TODO: Set icon for drawer menu
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            // Setting the status bar to transparent color for a nice looking material drawer.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(ContextCompat.getColor(this, android.R.color.transparent));
            }
        }
    }

    @Override
    protected int getLayoutRes() {
        /*
         * NOTE: base_drawer_activity.xml is only to be used as your layout if you plan on having a
         * fragment as your main view portion. Otherwise, create a custom view for your activity, and
         * make sure to both include toolbar.xml and nav_drawer.xml.
         */
        return R.layout.base_drawer_activity;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (drawerLayout != null) {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
