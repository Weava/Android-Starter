package com.appweava.androidstarterdomain.interactor;

import org.junit.Before;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * BaseUseCaseTest
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 2/7/17
 */
public class BaseUseCaseTest {

    protected TransformerManager transformerManager;

    @Before
    public void setUp() {
        transformerManager = new TransformerManager() {
            @Override
            public <T> Observable.Transformer<T, T> applyMainSchedulers() {
                return tObservable -> tObservable
                        .observeOn(Schedulers.immediate())
                        .subscribeOn(Schedulers.immediate());
            }
        };
    }
}
