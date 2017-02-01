package com.appweava.androidstarterdomain.executor;

import rx.Scheduler;

/**
 * PostExecutionThread
 * <p>
 * Thread to change execution from one thread to another upon finishing execution. Great for
 * transferring a thread's work to the UI thread.
 */
public interface PostExecutionThread {

    Scheduler getScheduler();
}
