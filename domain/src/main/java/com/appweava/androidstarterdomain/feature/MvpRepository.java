package com.appweava.androidstarterdomain.feature;

import java.util.List;

import rx.Observable;

/**
 * MvpRepository
 * <p>
 * Interface containing methods that will declare what data to retrieve.
 */
public interface MvpRepository {

    Observable<List<MvpData>> getMvpModelList();
}
