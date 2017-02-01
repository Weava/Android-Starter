package com.appweava.androidstarter;

import com.appweava.androidstarterdomain.executor.PostExecutionThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * UiThread
 * <p>
 * Singleton reference to the UI thread. Implements {@link PostExecutionThread}.
 */
@Singleton
public class UiThread implements PostExecutionThread {

    @Inject
    public UiThread() {}

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
