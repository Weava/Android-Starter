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
 * {@link AppComponent} extension that provides inject targets for test classes.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/23/16
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
