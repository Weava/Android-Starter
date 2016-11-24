package com.appweava.androidstarterdomain.executor;

import java.util.concurrent.Executor;

import rx.Scheduler;

/**
 * ThreadExecutor
 * <p>
 * Simple thread execution contract.
 *
 * @see Executor
 *
 * @author <a href="mailto:aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public interface ExecutionThread {
    Scheduler getThread();
}
