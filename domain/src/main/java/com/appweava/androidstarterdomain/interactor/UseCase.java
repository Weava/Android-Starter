package com.appweava.androidstarterdomain.interactor;

import com.appweava.androidstarterdomain.executor.PostExecutionThread;
import com.appweava.androidstarterdomain.executor.ThreadExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * UseCase
 * <p>
 * Abstract class for all interactor elements within the architecture. Can represent different
 * methods of thread execution for each type of interactor. Any use case within this project
 * should extend this.
 *
 * @author <a href="mailto:aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public abstract class UseCase {

    private final ThreadExecutor mThreadExecutor;
    private final PostExecutionThread mPostExecutionThread;

    private Subscription mSubscription = Subscriptions.empty();

    protected UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        mThreadExecutor = threadExecutor;
        mPostExecutionThread = postExecutionThread;
    }

    /**
     * Builds an {@link Observable} which will be used when running the {@link UseCase}.
     *
     * @return
     *      {@link Observable} to be used by the use case
     */
    protected abstract Observable buildUseCaseObservable();

    /**
     * Executes the use case.
     *
     * @param useCaseSubscriber
     *      {@link Subscriber} that the use case observable will use
     */
    @SuppressWarnings("unchecked")
    public void execute(Subscriber useCaseSubscriber) {
        this.mSubscription = this.buildUseCaseObservable()
                .subscribeOn(Schedulers.from(mThreadExecutor))
                .observeOn(mPostExecutionThread.getScheduler())
                .subscribe(useCaseSubscriber);
    }

    /**
     * Unsubscribe from {@link Subscription}
     */
    public void unsubscribe() {
        if (!mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }
}
