package com.appweava.androidstarter.internal.di.component;

import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarter.internal.di.module.ApiModule;
import com.appweava.androidstarter.internal.di.module.ApplicationModule;
import com.appweava.androidstarter.internal.di.module.DebugApiModule;
import com.appweava.androidstarter.internal.di.module.DebugApplicationModule;
import com.appweava.androidstarter.internal.di.module.DebugRepositoryModule;
import com.appweava.androidstarter.internal.di.module.RepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * AppComponent
 * <p>
 * {@link AppGraph} extension defining dependency injection setup for Debug build type.
 */
@Singleton
@Component(
        modules = {
                ApiModule.class,
                ApplicationModule.class,
                RepositoryModule.class,
        }
)
public interface AppComponent extends AppGraph {

    final class Initializer {

        public static AppGraph init(StarterApp app) {
            return DaggerAppComponent.builder()
                                     .applicationModule(new DebugApplicationModule(app))
                                     .apiModule(new DebugApiModule())
                                     .repositoryModule(new DebugRepositoryModule())
                                     .build();
        }

        private Initializer() {
            throw new AssertionError();
        }
    }
}
