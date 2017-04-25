package com.appweava.androidstarter.data.feature;

import java.util.List;

import io.reactivex.Observable;

/**
 * MvpRepository
 * <p>
 * Interface containing methods that will declare what data to retrieve.
 */
public interface MvpRepository {

    Observable<List<MvpData>> getMvpModelList();
}
