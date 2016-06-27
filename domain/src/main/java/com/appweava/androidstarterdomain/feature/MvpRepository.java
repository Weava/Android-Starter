package com.appweava.androidstarterdomain.feature;

import java.util.List;

import rx.Observable;

/**
 * MvpRepository
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public interface MvpRepository {

    Observable<List<MvpModel>> getMvpModelList();
}
