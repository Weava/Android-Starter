package com.appweava.androidstarter.presentation.dependencyinjection.module;

import com.appweava.androidstarter.presentation.base.ui.ViewContainer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UiModule {

    @Provides
    @Singleton
    ViewContainer provideViewContainer() {
        return ViewContainer.DEFAULT;
    }
}
