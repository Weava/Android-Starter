package com.appweava.androidstarter.internal.di.component;

import com.appweava.androidstarter.feature.MvpActivityTest;
import com.appweava.androidstarter.internal.di.module.ApiModule;
import com.appweava.androidstarter.internal.di.module.ApplicationModule;
import com.appweava.androidstarter.internal.di.module.RepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * TestAppComponent
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/23/16
 */
@Singleton
@Component(
        modules = {
                ApiModule.class,
                ApplicationModule.class,
                RepositoryModule.class
        }
)
public interface TestComponent extends AppComponent {
    void inject(MvpActivityTest mvpActivityTest);
}
