package com.appweava.androidstarterdomain.interactor;

import com.appweava.androidstarterdomain.executor.ExecutionThread;
import com.appweava.androidstarterdomain.executor.PostExecutionThread;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
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

    private final ExecutionThread executionThread;
    private final PostExecutionThread postExecutionThread;

    private Subscription subscription = Subscriptions.empty();

    protected UseCase(ExecutionThread executionThread, PostExecutionThread postExecutionThread) {
        this.executionThread = executionThread;
        this.postExecutionThread = postExecutionThread;
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
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(executionThread.getThread())
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(useCaseSubscriber);
    }

    /**
     * Unsubscribe from {@link Subscription}
     */
    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
