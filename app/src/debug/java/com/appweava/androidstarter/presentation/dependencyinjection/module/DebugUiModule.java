package com.appweava.androidstarter.presentation.dependencyinjection.module;

import com.appweava.androidstarter.presentation.base.ui.ViewContainer;
import com.appweava.androidstarter.presentation.debugdrawer.ui.DebugViewContainer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DebugUiModule {

    @Provides
    @Singleton
    ViewContainer provideViewContainer(DebugViewContainer debugViewContainer) {
        return debugViewContainer;
    }
}
