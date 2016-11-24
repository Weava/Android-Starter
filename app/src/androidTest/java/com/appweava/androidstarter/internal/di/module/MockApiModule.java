package com.appweava.androidstarter.internal.di.module;

import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.google.gson.Gson;

import org.mockito.Mockito;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * MockApiModule
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/23/16
 */
public class MockApiModule extends ApiModule {

    @Override
    Gson provideGson() {
        return new Gson();
    }

    @Override
    Cache provideCache() {
        return new Cache(new File("app/cache"), 1);
    }

    @Override
    Retrofit.Builder provideRetrofitBuilder(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder();
    }

    @Override
    MvpApi provideMvpApi(Retrofit.Builder retrofit) {
        return Mockito.mock(MvpApi.class);
    }

    @Override
    OkHttpClient provideOkHttpClient(Cache cache) {
        return Mockito.mock(OkHttpClient.class);
    }
}
