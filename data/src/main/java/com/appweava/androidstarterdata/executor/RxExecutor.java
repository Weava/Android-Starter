package com.appweava.androidstarterdata.executor;

import com.appweava.androidstarterdomain.executor.ExecutionThread;

import javax.inject.Inject;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * RxExecutor
 * <p>
 * {@link ExecutionThread} implementation for defining background thread executors.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/23/16
 */
public class RxExecutor implements ExecutionThread {

    @Inject
    public RxExecutor() {}

    @Override
    public Scheduler getThread() {
        return Schedulers.io();
    }
}
