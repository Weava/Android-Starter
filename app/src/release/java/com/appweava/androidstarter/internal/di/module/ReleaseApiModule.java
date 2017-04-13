package com.appweava.androidstarter.internal.di.module;

import android.content.Context;

import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ReleaseApiModule
 * <p>
 * {@link Module} defining API and network dependencies for release builds.
 */
public class ReleaseApiModule extends ApiModule {

    private static final TimeUnit TIMEOUT_TIME_UNIT = TimeUnit.MINUTES;
    private static final int TIMEOUT_TIME = 1;
    private static final long CACHE_SIZE = 5 * 1024 * 1024;

    @Override
    OkHttpClient provideOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_TIME, TIMEOUT_TIME_UNIT)
                .cache(cache)
                .build();
    }

    @Override
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Override
    File provideFile(Context context) {
        return context.getFilesDir();
    }

    @Override
    Cache provideCache(File file) {
        return new Cache(file, CACHE_SIZE);
    }
    
    @Override
    Retrofit.Builder provideRetrofitBuilder(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient);
    }

    @Override
    MvpApi provideMvpApi(Retrofit.Builder retrofit) {
        return retrofit.baseUrl("http://reddit.com/r/")
                       .build()
                       .create(MvpApi.class);
    }


}
