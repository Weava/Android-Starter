package com.appweava.androidstarter.base;

import com.appweava.androidstarterdomain.interactor.ObservableSchedulerManager;

import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;

/**
 * AppTransformerManager
 * <p>
 * Class description here
 */
public class AppObservableSchedulerManager implements ObservableSchedulerManager {

    private final Scheduler executionThread;
    private final Scheduler postExecutionThread;

    public AppObservableSchedulerManager(Scheduler postExecutionThread,
                                         Scheduler executionThread) {
        this.postExecutionThread = postExecutionThread;
        this.executionThread = executionThread;
    }

    @Override
    public <T>  ObservableTransformer<T, T> applyMainSchedulers() {
        return observable -> observable
                .subscribeOn(executionThread)
                .observeOn(postExecutionThread);
    }
}
