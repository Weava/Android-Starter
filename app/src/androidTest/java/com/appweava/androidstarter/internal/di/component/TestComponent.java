package com.appweava.androidstarter.internal.di.component;

import com.appweava.androidstarter.StarterTestApp;
import com.appweava.androidstarter.internal.di.module.MockApiModule;
import com.appweava.androidstarter.internal.di.module.MockApplicationModule;
import com.appweava.androidstarter.internal.di.module.MockRepositoryModule;

/**
 * TestAppComponent
 * <p>
 * {@link AppGraph} extension that provides dependency configuration for test cases.
 */
public interface TestComponent extends AppGraph {

    final class Initializer {

        public static AppComponent init(StarterTestApp app) {
            return DaggerAppComponent.builder()
                                      .applicationModule(new MockApplicationModule(app))
                                      .apiModule(new MockApiModule())
                                      .repositoryModule(new MockRepositoryModule())
                                      .build();
        }

        private Initializer() {
            throw new AssertionError();
        }
    }
}
