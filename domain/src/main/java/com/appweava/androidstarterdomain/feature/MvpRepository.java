package com.appweava.androidstarterdomain.feature;

import java.util.List;

import rx.Observable;

/**
 * MvpRepository
 * <p>
 * Interface containing methods that will declare what data to retrieve.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public interface MvpRepository {

    Observable<List<MvpData>> getMvpModelList();
}
