package com.appweava.androidstarterdata.base;

import com.nytimes.android.external.store.base.Parser;
import com.nytimes.android.external.store.base.Persister;

/**
 * StoreElements
 * <p>
 * Interface defining methods that will retrieve {@link com.nytimes.android.external.store.base.Store}
 * elements like {@link Parser} and {@link Persister}.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 1/7/17
 */
public interface StoreObjects {

    <T> Parser getDefaultParser(Class<T> classType);

    <T> Persister<T> getDefaultPersister();
}
