package com.appweava.androidstarter.base;

import com.appweava.androidstarter.rxespresso.RxEspresso;
import com.appweava.androidstarterdomain.executor.ExecutionThread;
import com.appweava.androidstarterdomain.executor.PostExecutionThread;
import com.appweava.androidstarterdomain.interactor.TransformerManager;

import rx.Observable;

/**
 * TestTransformerManager
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 2/7/17
 */
public class TestTransformerManager implements TransformerManager {

    private final ExecutionThread executionThread;
    private final PostExecutionThread postExecutionThread;

    public TestTransformerManager(ExecutionThread executionThread,
                                  PostExecutionThread postExecutionThread) {
        this.executionThread = executionThread;
        this.postExecutionThread = postExecutionThread;
    }

    @Override
    public <T> Observable.Transformer<T, T> applyMainSchedulers() {
        return observable -> observable
                .subscribeOn(executionThread.getThread())
                .observeOn(postExecutionThread.getScheduler())
                .doOnSubscribe(RxEspresso::increment)
                .doAfterTerminate(RxEspresso::decrement);
    }
}
