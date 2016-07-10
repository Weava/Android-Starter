package com.appweava.androidstarterdomain.feature;

import com.appweava.androidstarterdomain.executor.PostExecutionThread;
import com.appweava.androidstarterdomain.executor.ThreadExecutor;
import com.appweava.androidstarterdomain.interactor.UseCase;

import javax.inject.Inject;

import rx.Observable;

/**
 * MvpUseCase
 * <p>
 * {@link UseCase} implementation for getting MvpItems.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public class MvpUseCase extends UseCase {

    private final MvpRepository mvpRepository;

    @Inject
    public MvpUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                      MvpRepository mvpRepository) {
        super(threadExecutor, postExecutionThread);
        this.mvpRepository = mvpRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.mvpRepository.getMvpModelList();
    }
}
