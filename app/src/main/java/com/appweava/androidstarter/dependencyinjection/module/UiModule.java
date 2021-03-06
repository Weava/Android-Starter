package com.appweava.androidstarter.dependencyinjection.module;

import com.appweava.androidstarter.base.ui.ViewContainer;

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
