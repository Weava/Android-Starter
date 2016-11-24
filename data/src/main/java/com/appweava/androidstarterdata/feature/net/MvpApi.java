package com.appweava.androidstarterdata.feature.net;

import com.appweava.androidstarterdomain.feature.MvpData;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * MvpApi
 * <p>
 * API interface for getting {@link MvpData}
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/29/16
 */
public interface MvpApi {

    @GET("someEndpoint")
    Observable<List<MvpData>> getMvpEntityList();
}
