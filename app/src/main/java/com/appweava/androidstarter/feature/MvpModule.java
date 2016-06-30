package com.appweava.androidstarter.feature;

import com.appweava.androidstarter.internal.di.ActivityScope;
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
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/29/16
 */
@Module
public class MvpModule {

    @Provides
    @ActivityScope
    UseCase provideGetMvpModulesList(ThreadExecutor threadExecutor,
                                     PostExecutionThread postExecutionThread,
                                     MvpRepository mvpRepository) {

        return new MvpUseCase(threadExecutor, postExecutionThread, mvpRepository);
    }
}
