package com.appweava.androidstarter;

import android.app.Application;

import com.appweava.androidstarter.internal.di.component.AppComponent;
import com.appweava.androidstarter.internal.di.component.DaggerAppComponent;
import com.appweava.androidstarter.internal.di.module.AppModule;
import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

/**
 * StarterApp
 * <p>
 * Application class for setting up all necessary dependencies throughout application.
 *
 * @author <a href="mailto:aaron@appweava.com">Aaron Weaver</a>
 * @date 6/25/16
 * @since 1.0.0
 */
public class StarterApp extends Application {

    private static StarterApp mInstance;
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            initDevToolsSuite();
        } else {
            initReleaseAnalyticsTools();
        }

        mAppComponent = initAppComponent();

        mInstance = this;
    }

    /**
     * Initialize application DI component.
     *
     * @return
     *      Initialized {@link AppComponent}
     */
    private AppComponent initAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    /**
     * Initialize all developer tools for the application.
     */
    private void initDevToolsSuite() {
        Timber.plant(new Timber.DebugTree());
        Stetho.initializeWithDefaults(this);
        LeakCanary.install(this);
    }

    private void initReleaseAnalyticsTools() {
        //TODO: Add release analytics tools
    }

    /**
     * Retrieve singleton instance of the application.
     *
     * @return
     *      Singleton instance for {@link StarterApp}
     */
    public static StarterApp getInstance() {
        return mInstance;
    }

    /**
     * Provide app component as a dependency to other components.
     *
     * @return
     *      {@link AppComponent} to provide for dependent components
     */
    public AppComponent getAppComponent() {
        return this.mAppComponent;
    }
}
