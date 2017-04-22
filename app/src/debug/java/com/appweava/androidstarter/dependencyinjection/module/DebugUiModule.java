package com.appweava.androidstarter.dependencyinjection.module;

import com.appweava.androidstarter.base.ui.ViewContainer;
import com.appweava.androidstarter.debugdrawer.ui.DebugViewContainer;

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
