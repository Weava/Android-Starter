package com.appweava.androidstarter.internal.di.component;

import com.appweava.androidstarter.StarterTestApp;
import com.appweava.androidstarter.feature.MvpActivityTest;
import com.appweava.androidstarter.internal.di.module.MockApiModule;
import com.appweava.androidstarter.internal.di.module.MockApplicationModule;
import com.appweava.androidstarter.internal.di.module.MockRepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * TestAppComponent
 * <p>
 * {@link AppGraph} extension that provides dependency configuration for test cases.
 */
@Singleton
@Component(
        modules = {
                MockApiModule.class,
                MockApplicationModule.class,
                MockRepositoryModule.class
        }
)
public interface TestComponent extends AppGraph {

    void inject(MvpActivityTest mvpActivityTest);

    final class Initializer {

        public static TestComponent init(StarterTestApp app) {
            return DaggerTestComponent.builder()
                                      .mockApplicationModule(new MockApplicationModule(app))
                                      .mockApiModule(new MockApiModule())
                                      .mockRepositoryModule(new MockRepositoryModule())
                                      .build();
        }

        private Initializer() {
            throw new AssertionError();
        }
    }
}
