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
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/24/16
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
