package com.appweava.androidstarter.internal.di.component;

import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarter.internal.di.module.DebugApiModule;
import com.appweava.androidstarter.internal.di.module.DebugApplicationModule;
import com.appweava.androidstarter.internal.di.module.DebugRepositoryModule;

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
                DebugApiModule.class,
                DebugApplicationModule.class,
                DebugRepositoryModule.class,
        }
)
public interface AppComponent extends AppGraph {

    final class Initializer {

        public static AppGraph init(StarterApp app) {
            return DaggerAppComponent.builder()
                                     .debugApplicationModule(new DebugApplicationModule(app))
                                     .debugApiModule(new DebugApiModule())
                                     .debugRepositoryModule(new DebugRepositoryModule())
                                     .build();
        }

        private Initializer() {
            throw new AssertionError();
        }
    }
}
