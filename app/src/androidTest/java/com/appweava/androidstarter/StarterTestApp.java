package com.appweava.androidstarter;

import com.appweava.androidstarter.internal.di.Injector;
import com.appweava.androidstarter.internal.di.component.AppComponent;
import com.appweava.androidstarter.internal.di.component.TestComponent;
import com.appweava.androidstarter.rxespresso.LogLevel;
import com.appweava.androidstarter.rxespresso.RxEspresso;
import com.jakewharton.threetenabp.AndroidThreeTen;

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
        Injector.init(testComponent);
        testComponent.inject(this);
    }

    @Override
    protected void initApp() {
        Timber.tag("Mock App").i("Initializing mock application for testing");
        RxEspresso.setLogLevel(LogLevel.DEBUG);
        AndroidThreeTen.init(this);
    }
}
