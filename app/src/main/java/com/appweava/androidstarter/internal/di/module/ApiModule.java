package com.appweava.androidstarter.internal.di.module;

import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ApiModule
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/19/16
 */
@Module
public class ApiModule {

    private static final String CACHE_DIR = "app/cache";
    private static final long CACHE_SIZE = 5 * 1024 * 1024;

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    Cache provideCache() {
        return new Cache(new File(CACHE_DIR), CACHE_SIZE);
    }

    @Provides
    @Singleton
    Retrofit.Builder provideRetrofitBuilder(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient);
    }

    @Provides
    @Singleton
    MvpApi provideMvpApi(Retrofit.Builder retrofit) {
        return retrofit.baseUrl("http://reddit.com/r/")
                .build()
                .create(MvpApi.class);
    }

    /**
     * WARNING: OVERRIDE THIS IN BUILD TYPE OR ELSE YOU'LL GET A DEFAULT OKHTTPCLIENT, WHICH IS BAD.
     */
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .cache(cache)
                .build();
    }
}
