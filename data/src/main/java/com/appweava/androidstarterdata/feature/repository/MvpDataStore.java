package com.appweava.androidstarterdata.feature.repository;

import com.appweava.androidstarterdata.feature.MvpDataEntity;

import java.util.List;

import rx.Observable;

/**
 * MvpDataStore
 * <p>
 * Interface containing functions for retrieving items from any data store.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/29/16
 */
public interface MvpDataStore {

    Observable<List<MvpDataEntity>> getMvpEntityList();
}
