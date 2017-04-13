package com.appweava.androidstarterdata.feature.net;

import com.appweava.androidstarterdomain.feature.MvpData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * MvpApi
 * <p>
 * API interface for getting {@link MvpData}
 */
public interface MvpApi {

    @GET("someEndpoint")
    Observable<List<MvpData>> getMvpEntityList();
}
