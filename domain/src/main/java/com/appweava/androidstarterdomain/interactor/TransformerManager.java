package com.appweava.androidstarterdomain.interactor;

import rx.Observable;

/**
 * TransformerManager
 * <p>
 * Class description here
 */
public interface TransformerManager {

    <T> Observable.Transformer<T, T> applyMainSchedulers();
}
