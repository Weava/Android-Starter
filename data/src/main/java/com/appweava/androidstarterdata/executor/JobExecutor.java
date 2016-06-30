package com.appweava.androidstarterdata.executor;

import com.appweava.androidstarterdomain.executor.ThreadExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * JobExecutor
 * <p>
 * Custom implementation of {@link ThreadExecutor}.
 *
 * @see ThreadPoolExecutor
 * @see ThreadExecutor
 * @see BlockingQueue
 * @see ThreadFactory
 *
 * @author <a href="mailto:aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
@Singleton
public class JobExecutor implements ThreadExecutor {

    private static final int INITIAL_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;

    private static final int KEEP_ALIVE_TIME = 10;

    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    private final BlockingQueue<Runnable> mWorkQueue;

    private final ThreadPoolExecutor mThreadPoolExecutor;

    private final ThreadFactory mThreadFactory;

    @Inject
    public JobExecutor() {
        this.mWorkQueue = new LinkedBlockingDeque<>();
        this.mThreadFactory = new JobThreadFactory();
        this.mThreadPoolExecutor = new ThreadPoolExecutor(INITIAL_POOL_SIZE, MAX_POOL_SIZE,
                KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, this.mWorkQueue, this.mThreadFactory);
    }

    @Override
    public void execute(Runnable command) {
        if (command == null) {
            throw new IllegalArgumentException("Runnable to execute cannot be null");
        }
        this.mThreadPoolExecutor.execute(command);
    }

    /**
     * Creates a new thread.
     */
    private static class JobThreadFactory implements ThreadFactory {
        private static final String THREAD_NAME = "android_";
        private int counter = 0;

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, THREAD_NAME + counter++);
        }
    }
}
