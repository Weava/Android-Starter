package com.appweava.androidstarter.internal.di.component;

import com.appweava.androidstarter.internal.di.module.DebugActionsModule;
import com.appweava.androidstarter.internal.di.module.DebugTestPrepModule;
import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarter.internal.di.module.ApplicationModule;
import com.appweava.androidstarter.internal.di.module.DebugApiModule;
import com.appweava.androidstarter.internal.di.module.DebugApplicationModule;
import com.appweava.androidstarter.internal.di.module.DebugDataModule;
import com.appweava.androidstarter.internal.di.module.DebugUiModule;
import com.appweava.androidstarter.internal.di.module.InteractorModule;
import com.appweava.androidstarter.internal.di.module.PresenterModule;
import com.appweava.androidstarter.internal.di.module.RepositoryModule;
import com.appweava.androidstarter.ui.DebugView;

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

    void inject(DebugView debugView);

    final class Initializer {

        public static AppComponent init(StarterApp app) {
            return DaggerAppComponent.builder()
                                     .applicationModule(new DebugApplicationModule(app))
                                     .build();
        }

        private Initializer() {
            throw new AssertionError();
        }
    }
}
