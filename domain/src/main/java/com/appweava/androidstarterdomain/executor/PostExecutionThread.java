package com.appweava.androidstarterdomain.executor;

import rx.Scheduler;

/**
 * PostExecutionThread
 * <p>
 * Thread to change execution from one thread to another upon finishing execution. Great for
 * transferring a thread's work to the UI thread.
 *
 * @author <a href="mailto:aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public interface PostExecutionThread {
    Scheduler getScheduler();
}
