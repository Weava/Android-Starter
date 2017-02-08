package com.appweava.androidstarterdomain.interactor;

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
 */
public abstract class UseCase {

    private final TransformerManager transformerManager;

    protected UseCase(TransformerManager transformerManager) {
        this.transformerManager = transformerManager;
    }

    /**
     * Builds an {@link Observable} which will be used when running the {@link UseCase}.
     *
     * @return {@link Observable} to be used by the use case
     */
    protected abstract Observable buildUseCaseObservable();

    /**
     * Subscribes to the executing use case using only an {@link rx.Subscriber#onNext(Object)}
     * function.
     *
     * @param onNext
     *         {@link rx.Subscriber#onNext(Object)}
     * @param <T>
     *         Type of the observable returned
     *
     * @return {@link Subscription} of the observable
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
     *         {@link rx.Subscriber#onNext(Object)}
     * @param onError
     *         {@link rx.Subscriber#onError(Throwable)}
     * @param <T>
     *         Type of the observable returned
     *
     * @return {@link Subscription} of the observable
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
     *         {@link rx.Subscriber#onNext(Object)}
     * @param onError
     *         {@link rx.Subscriber#onError(Throwable)}
     * @param onComplete
     *         {@link Subscriber#onCompleted()}
     * @param <T>
     *         Type of the observable returned
     *
     * @return {@link Subscription} of the observable
     */
    @SuppressWarnings("unchecked")
    public <T> Subscription execute(Action1<T> onNext, Action1<? extends Throwable> onError,
            Action0 onComplete) {
        return this.buildUseCaseObservable()
                   .compose(transformerManager.applyMainSchedulers())
                   .subscribe(onNext, onError, onComplete);
    }

    /**
     * Subscribes to the executing use case using only an {@link Subscriber}.
     *
     * @param subscriber
     *      {@link Subscriber}
     * @param <T>
     *      Type observable should return
     * @return
     *      {@link Subscription} of the observable
     */
    @SuppressWarnings("unchecked")
    public <T> Subscription execute(Subscriber<T> subscriber) {
        return this.buildUseCaseObservable()
                   .compose(transformerManager.applyMainSchedulers())
                   .subscribe(subscriber);
    }
}
