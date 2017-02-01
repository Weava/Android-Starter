package com.appweava.androidstarterdata.feature.net;

import com.appweava.androidstarterdomain.feature.MvpData;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * MvpApi
 * <p>
 * API interface for getting {@link MvpData}
 */
public interface MvpApi {

    @GET("someEndpoint")
    Observable<List<MvpData>> getMvpEntityList();
}
