package com.appweava.androidstarterdomain.executor;

import java.util.concurrent.Executor;

import rx.Scheduler;

/**
 * ThreadExecutor
 * <p>
 * Simple thread execution contract.
 *
 * @see Executor
 */
public interface ExecutionThread {

    Scheduler getThread();
}
