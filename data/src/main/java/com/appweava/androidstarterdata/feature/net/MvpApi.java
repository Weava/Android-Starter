package com.appweava.androidstarterdata.feature.net;

import com.appweava.androidstarterdata.feature.MvpDataEntity;

import java.util.List;

import rx.Observable;

/**
 * MvpApi
 * <p>
 * API interface for getting {@link MvpDataEntity}
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/29/16
 */
public interface MvpApi {

    Observable<List<MvpDataEntity>> getMvpEntityList();
}
