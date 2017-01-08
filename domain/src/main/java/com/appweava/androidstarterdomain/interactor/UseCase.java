package com.appweava.androidstarterdomain.interactor;

import com.appweava.androidstarterdomain.executor.ExecutionThread;
import com.appweava.androidstarterdomain.executor.PostExecutionThread;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;

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
     * Subscribes to the executing use case using only an {@link rx.Subscriber#onNext(Object)}
     * function.
     *
     * @param onNext
     *      {@link rx.Subscriber#onNext(Object)}
     * @param <T>
     *      Type of the observable returned
     * @return
     *      {@link Subscription} of the observable
     */
    @SuppressWarnings("unchecked")
    public <T> Subscription execute(Action1<T> onNext) {
        return execute(onNext, (throwable) -> {}, () -> {});
    }

    /**
     * Subscribes to the executing use case using only an {@link rx.Subscriber#onNext(Object)}
     * and {@link rx.Subscriber#onError(Throwable)} functions.
     *
     * @param onNext
     *      {@link rx.Subscriber#onNext(Object)}
     * @param onError
     *      {@link rx.Subscriber#onError(Throwable)}
     * @param <T>
     *      Type of the observable returned
     * @return
     *      {@link Subscription} of the observable
     */
    @SuppressWarnings("unchecked")
    public <T> Subscription execute(Action1<T> onNext, Action1<? extends Throwable> onError) {
        return execute(onNext, onError, () -> {});
    }

    /**
     * Subscribes to the executing use case using only an {@link rx.Subscriber#onNext(Object)},
     * {@link rx.Subscriber#onError(Throwable)}, and {@link Subscriber#onCompleted()} functions.
     *
     * @param onNext
     *      {@link rx.Subscriber#onNext(Object)}
     * @param onError
     *      {@link rx.Subscriber#onError(Throwable)}
     * @param onComplete
     *      {@link Subscriber#onCompleted()}
     * @param <T>
     *      Type of the observable returned
     * @return
     *      {@link Subscription} of the observable
     */
    @SuppressWarnings("unchecked")
    public <T> Subscription execute(Action1<T> onNext, Action1<? extends Throwable> onError, Action0 onComplete) {
        return this.buildUseCaseObservable()
                .compose(applySchedulers())
                .subscribe(onNext, onError, onComplete);
    }

    /**
     * A {@link rx.Observable.Transformer} for applying subscribeOn and observeOn threads for
     * Rx {@link Observable} when executing use case.
     *
     * @param <T>
     *     Generic type of observable
     * @return
     *      {@link rx.Observable.Transformer}
     */
    protected  <T> Observable.Transformer<T, T> applySchedulers() {
        return observable -> observable
                .subscribeOn(executionThread.getThread())
                .observeOn(postExecutionThread.getScheduler());
    }
}
