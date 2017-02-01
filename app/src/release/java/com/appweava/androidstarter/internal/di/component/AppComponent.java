package com.appweava.androidstarter.internal.di.component;

import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarter.internal.di.module.ReleaseApiModule;
import com.appweava.androidstarter.internal.di.module.ReleaseApplicationModule;
import com.appweava.androidstarter.internal.di.module.ReleaseRepositoryModule;

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
                ReleaseApiModule.class,
                ReleaseApplicationModule.class,
                ReleaseRepositoryModule.class
        }
)
public interface AppComponent extends AppGraph {

    final class Initializer {

        public static AppGraph init(StarterApp app) {
            return DaggerAppComponent.builder()
                                     .releaseApplicationModule(new ReleaseApplicationModule(app))
                                     .releaseApiModule(new ReleaseApiModule())
                                     .releaseRepositoryModule(new ReleaseRepositoryModule())
                                     .build();
        }

        private Initializer() {
            throw new AssertionError();
        }
    }
}
