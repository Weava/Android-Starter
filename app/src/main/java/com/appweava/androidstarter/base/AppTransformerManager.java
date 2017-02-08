package com.appweava.androidstarter.base;

import com.appweava.androidstarterdomain.executor.ExecutionThread;
import com.appweava.androidstarterdomain.executor.PostExecutionThread;
import com.appweava.androidstarterdomain.interactor.TransformerManager;

import rx.Observable;

/**
 * AppTransformerManager
 * <p>
 * Class description here
 */
public class AppTransformerManager implements TransformerManager {

    private final ExecutionThread executionThread;
    private final PostExecutionThread postExecutionThread;

    public AppTransformerManager(PostExecutionThread postExecutionThread,
            ExecutionThread executionThread) {
        this.postExecutionThread = postExecutionThread;
        this.executionThread = executionThread;
    }

    @Override
    public <T> Observable.Transformer<T, T> applyMainSchedulers() {
        return observable -> observable
                .subscribeOn(executionThread.getThread())
                .observeOn(postExecutionThread.getScheduler());
    }
}
