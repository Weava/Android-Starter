package com.appweava.androidstarter.internal.di.component;

import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarter.internal.di.module.ApiModule;
import com.appweava.androidstarter.internal.di.module.ApplicationModule;
import com.appweava.androidstarter.internal.di.module.ReleaseApiModule;
import com.appweava.androidstarter.internal.di.module.ReleaseApplicationModule;
import com.appweava.androidstarter.internal.di.module.ReleaseRepositoryModule;
import com.appweava.androidstarter.internal.di.module.RepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * AppComponent
 * <p>
 * {@link AppGraph} extension for defining release build dependency injection strategy.
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
                                     .repositoryModule(new ReleaseRepositoryModule())
                                     .build();
        }

        private Initializer() {
            throw new AssertionError();
        }
    }
}
