package com.appweava.androidstarterdata.executor;

import com.appweava.androidstarterdomain.executor.ExecutionThread;

import javax.inject.Inject;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * RxExecutor
 * <p>
 * {@link ExecutionThread} implementation for defining background thread executors.
 */
public class RxExecutor implements ExecutionThread {

    @Inject
    public RxExecutor() {}

    @Override
    public Scheduler getThread() {
        return Schedulers.io();
    }
}
