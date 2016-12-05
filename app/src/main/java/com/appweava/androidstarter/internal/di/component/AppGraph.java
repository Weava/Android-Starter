package com.appweava.androidstarter.internal.di.component;

import com.appweava.androidstarter.MainActivity;
import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarter.base.BaseActivity;
import com.appweava.androidstarter.feature.MvpActivity;

/**
 * AppComponent
 * <p>
 * Top level component for DI graph containing all application dependencies. Lifetime lasts for
 * all of application lifecycle.
 *
 * @author <a href="mailto:aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public interface AppGraph {

    /* Base */
    void inject(StarterApp starterApp);
    void inject(BaseActivity baseActivity);

    /* Mvp */
    void inject(MvpActivity mvpActivity);

    /* Main */
    void inject(MainActivity mainActivity);
}
