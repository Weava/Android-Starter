package com.appweava.androidstarter.data;

import io.reactivex.ObservableTransformer;

/**
 * TransformerManager
 * <p>
 * Interface defining different methods that returns {@link ObservableTransformer} for an {@link Observable}
 * with schedulers already picked out
 */
public interface ObservableSchedulerManager {

    <T> ObservableTransformer<T, T> applyMainSchedulers();
}
