package com.appweava.androidstarter.base;

import com.appweava.androidstarter.rxespresso.RxEspresso;
import com.appweava.androidstarterdomain.interactor.ObservableSchedulerManager;

import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;

/**
 * TestTransformerManager
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 2/7/17
 */
public class TestObservableSchedulerManager implements ObservableSchedulerManager {

    private final Scheduler executionThread;
    private final Scheduler postExecutionThread;

    public TestObservableSchedulerManager(Scheduler executionThread,
                                          Scheduler postExecutionThread) {
        this.executionThread = executionThread;
        this.postExecutionThread = postExecutionThread;
    }

    @Override
    public <T> ObservableTransformer<T, T> applyMainSchedulers() {
        return observable -> observable
                .subscribeOn(executionThread)
                .observeOn(postExecutionThread)
                .doOnSubscribe((disposable) -> RxEspresso.increment())
                .doAfterTerminate(RxEspresso::decrement);
    }
}
