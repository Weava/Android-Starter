package com.appweava.androidstarter.internal.di.component;

import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarter.internal.di.module.ApiModule;
import com.appweava.androidstarter.internal.di.module.ApplicationModule;
import com.appweava.androidstarter.internal.di.module.ReleaseApiModule;
import com.appweava.androidstarter.internal.di.module.ReleaseApplicationModule;
import com.appweava.androidstarter.internal.di.module.RepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * AppComponent
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/24/16
 */
@Singleton
@Component(
        modules = {
                ApiModule.class,
                ApplicationModule.class,
                RepositoryModule.class
        }
)
public interface AppComponent extends AppGraph {

    final class Initializer {
        public static AppGraph init(StarterApp app) {
            return DaggerAppComponent.builder()
                    .applicationModule(new ReleaseApplicationModule(app))
                    .apiModule(new ReleaseApiModule())
                    .build();
        }

        private Initializer() {
            throw new AssertionError();
        }
    }
}
