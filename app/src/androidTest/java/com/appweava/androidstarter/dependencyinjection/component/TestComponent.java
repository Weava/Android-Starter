package com.appweava.androidstarter.dependencyinjection.component;

import com.appweava.androidstarter.StarterTestApp;
import com.appweava.androidstarter.dependencyinjection.module.DebugTestPrepModule;
import com.appweava.androidstarter.dependencyinjection.module.MockApiModule;
import com.appweava.androidstarter.dependencyinjection.module.MockApplicationModule;

/**
 * TestAppComponent
 * <p>
 * {@link AppGraph} extension that provides dependency configuration for test cases.
 */
public interface TestComponent extends AppComponent {

    final class Initializer {

        public static AppComponent init(StarterTestApp app) {
            return DaggerAppComponent.builder()
                                      .applicationModule(new MockApplicationModule(app))
                                      .debugApiModule(new MockApiModule())
                                      .debugTestPrepModule(new DebugTestPrepModule(true))
                                      .build();
        }

        private Initializer() {
            throw new AssertionError();
        }
    }
}
