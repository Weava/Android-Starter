package com.appweava.androidstarter;

import com.appweava.androidstarter.internal.di.component.AppGraph;
import com.appweava.androidstarter.internal.di.component.DaggerAppComponent;
import com.appweava.androidstarter.internal.di.module.DebugApiModule;
import com.appweava.androidstarter.internal.di.module.DebugApplicationModule;
import com.appweava.androidstarter.internal.di.module.RepositoryModule;

/**
 * StarterTestApplication
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/22/16
 */
public class StarterTestApp extends StarterApp {

    @Override
    protected void initAppComponent() {

        // TODO: Figure out what to do about mock dependencies
        appComponent = DaggerAppComponent
                .builder()
                .applicationModule(new DebugApplicationModule(this))
                .apiModule(new DebugApiModule())
                .repositoryModule(new RepositoryModule())
                .build();
    }

    @Override
    public AppGraph getAppComponent() {
        return super.getAppComponent();
    }
}
