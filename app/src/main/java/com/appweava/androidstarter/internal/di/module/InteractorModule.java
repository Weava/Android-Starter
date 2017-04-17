package com.appweava.androidstarter.internal.di.module;

import com.appweava.androidstarterdomain.feature.MvpInteractor;
import com.appweava.androidstarterdomain.feature.MvpInteractorImpl;
import com.appweava.androidstarterdomain.feature.MvpRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    MvpInteractor provideMvpInteractor(MvpRepository mvpRepository) {
        return new MvpInteractorImpl(mvpRepository);
    }
}
