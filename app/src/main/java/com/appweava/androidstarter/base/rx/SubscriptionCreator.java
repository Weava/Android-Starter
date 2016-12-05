package com.appweava.androidstarter.base.rx;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import timber.log.Timber;

/**
 * SubscriptionCreator
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/25/16
 */
public class SubscriptionCreator {

    public static <T> Subscriber<T> create(@NonNull Action1<T> onSuccess,
                                           @Nullable Action1<Throwable> onFailed,
                                           @Nullable Action0 onComplete) {
        return new Subscriber<T>() {
            @Override
            public void onCompleted() {
                if (onComplete != null) {
                    onComplete.call();
                } else if (!isUnsubscribed()) {
                    this.unsubscribe();
                }
            }

            @Override
            public void onError(Throwable e) {
                if (onFailed != null) {
                    onFailed.call(e);
                }

                Timber.tag("Subscription Error").e(e.getMessage());
            }

            @Override
            public void onNext(T t) {
                onSuccess.call(t);
            }
        };
    }
}
