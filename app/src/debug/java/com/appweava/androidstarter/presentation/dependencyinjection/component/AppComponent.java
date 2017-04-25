package com.appweava.androidstarter.presentation.dependencyinjection.component;

import com.appweava.androidstarter.presentation.DebugAppInitializer;
import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarter.presentation.debugdrawer.ui.DebugView;
import com.appweava.androidstarter.presentation.dependencyinjection.module.ApplicationModule;
import com.appweava.androidstarter.presentation.dependencyinjection.module.DebugActionsModule;
import com.appweava.androidstarter.presentation.dependencyinjection.module.DebugApiModule;
import com.appweava.androidstarter.presentation.dependencyinjection.module.DebugApplicationModule;
import com.appweava.androidstarter.presentation.dependencyinjection.module.DebugDataModule;
import com.appweava.androidstarter.presentation.dependencyinjection.module.DebugTestPrepModule;
import com.appweava.androidstarter.presentation.dependencyinjection.module.DebugUiModule;
import com.appweava.androidstarter.presentation.dependencyinjection.module.InteractorModule;
import com.appweava.androidstarter.presentation.dependencyinjection.module.PresenterModule;
import com.appweava.androidstarter.presentation.dependencyinjection.module.RepositoryModule;

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
                ApplicationModule.class,
                RepositoryModule.class,
                PresenterModule.class,
                InteractorModule.class,
                DebugUiModule.class,
                DebugDataModule.class,
                DebugApiModule.class,
                DebugTestPrepModule.class,
                DebugActionsModule.class
        }
)
public interface AppComponent extends AppGraph {

    /* Debug specific injection targets */
    void inject(DebugView debugView);
    void inject(DebugAppInitializer debugAppInitializer);

    final class Initializer {

        public static AppComponent init(StarterApp app) {
            return DaggerAppComponent.builder()
                                     .applicationModule(new DebugApplicationModule(app))
                                     .debugTestPrepModule(new DebugTestPrepModule(false))
                                     .build();
        }

        private Initializer() {
            throw new AssertionError();
        }
    }
}
