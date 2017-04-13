package com.appweava.androidstarter;

import com.appweava.androidstarter.internal.di.component.AppComponent;
import com.appweava.androidstarter.internal.di.component.TestComponent;
import com.appweava.androidstarter.rxespresso.LogLevel;
import com.appweava.androidstarter.rxespresso.RxEspresso;

import timber.log.Timber;

/**
 * StarterTestApplication
 * <p>
 * {@link StarterApp} extension class that sets up our dependencies for instrumentation tests.
 */
public class StarterTestApp extends StarterApp {

    private AppComponent testComponent;

    @Override
    protected void initAppComponent() {
        testComponent = TestComponent.Initializer.init(this);
    }

    @Override
    protected void initApp() {
        Timber.tag("Mock App").i("Initializing mock application for testing");
        RxEspresso.setLogLevel(LogLevel.DEBUG);
        // TODO: Init test app dependencies here.
    }

    @Override
    public AppComponent getAppComponent() {
        return testComponent;
    }
}
