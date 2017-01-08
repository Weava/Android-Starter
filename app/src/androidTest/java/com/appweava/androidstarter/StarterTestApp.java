package com.appweava.androidstarter;

import com.appweava.androidstarter.internal.di.component.TestComponent;

import timber.log.Timber;

/**
 * StarterTestApplication
 * <p>
 * {@link StarterApp} extension class that sets up our dependencies for instrumentation tests.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/22/16
 */
public class StarterTestApp extends StarterApp {

    private TestComponent testComponent;

    @Override
    protected void initAppComponent() {
        testComponent = TestComponent.Initializer.init(this);
    }

    @Override
    protected void initApp() {
        Timber.tag("Mock App").i("Initializing mock application for testing");
        // TODO: Init test app dependencies here.
    }

    @Override
    public TestComponent getAppComponent() {
        return testComponent;
    }
}
