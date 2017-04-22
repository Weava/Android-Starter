package com.appweava.androidstarter.dependencyinjection.component;

import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarter.dependencyinjection.module.ApplicationModule;
import com.appweava.androidstarter.dependencyinjection.module.InteractorModule;
import com.appweava.androidstarter.dependencyinjection.module.PresenterModule;
import com.appweava.androidstarter.dependencyinjection.module.ReleaseApiModule;
import com.appweava.androidstarter.dependencyinjection.module.ReleaseApplicationModule;
import com.appweava.androidstarter.dependencyinjection.module.RepositoryModule;
import com.appweava.androidstarter.dependencyinjection.module.UiModule;

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
                ApplicationModule.class,
                RepositoryModule.class,
                PresenterModule.class,
                InteractorModule.class,
                UiModule.class
        }
)
public interface AppComponent extends AppGraph {

    final class Initializer {

        public static AppComponent init(StarterApp app) {
            return DaggerAppComponent.builder()
                                     .applicationModule(new ReleaseApplicationModule(app))
                                     .build();
        }

        private Initializer() {
            throw new AssertionError();
        }
    }
}
