package com.appweava.androidstarter.presentation.dependencyinjection.module;

import com.appweava.androidstarter.data.feature.MvpInteractor;
import com.appweava.androidstarter.data.feature.MvpInteractorImpl;
import com.appweava.androidstarter.data.feature.MvpRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    MvpInteractor provideMvpInteractor(MvpRepository mvpRepository) {
        return new MvpInteractorImpl(mvpRepository);
    }
}
