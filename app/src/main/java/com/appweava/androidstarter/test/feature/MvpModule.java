package com.appweava.androidstarter.test.feature;

import com.appweava.androidstarter.internal.di.PerActivity;
import com.appweava.androidstarterdomain.executor.PostExecutionThread;
import com.appweava.androidstarterdomain.executor.ThreadExecutor;
import com.appweava.androidstarterdomain.feature.MvpRepository;
import com.appweava.androidstarterdomain.feature.MvpUseCase;
import com.appweava.androidstarterdomain.interactor.UseCase;

import dagger.Module;
import dagger.Provides;

/**
 * MvpModule
 * <p>
 * Module providing dependencies to Mvp featureset.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/29/16
 */
@Module
public class MvpModule {

    @Provides
    @PerActivity
    UseCase provideGetMvpModulesList(ThreadExecutor threadExecutor,
                                     PostExecutionThread postExecutionThread,
                                     MvpRepository mvpRepository) {

        return new MvpUseCase(threadExecutor, postExecutionThread, mvpRepository);
    }
}
