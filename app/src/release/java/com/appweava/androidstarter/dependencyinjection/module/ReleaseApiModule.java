package com.appweava.androidstarter.dependencyinjection.module;

import android.content.Context;

import com.appweava.androidstarterdata.ApiEndpoints;
import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.squareup.moshi.Moshi;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class ReleaseApiModule {

    private static final TimeUnit TIMEOUT_TIME_UNIT = TimeUnit.MINUTES;
    private static final int TIMEOUT_TIME = 1;
    private static final long CACHE_SIZE = 5 * 1024 * 1024;

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_TIME, TIMEOUT_TIME_UNIT)
                .cache(cache)
                .build();
    }

    @Singleton
    @Provides
    Moshi provideMoshi() {
        return new Moshi.Builder()
                .build();
    }

    @Singleton
    @Provides
    File provideFile(Context context) {
        return context.getFilesDir();
    }

    @Singleton
    @Provides
    Cache provideCache(File file) {
        return new Cache(file, CACHE_SIZE);
    }

    @Singleton
    @Provides
    Retrofit provideRetrofitBuilder(OkHttpClient okHttpClient, Moshi moshi) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(okHttpClient)
                .baseUrl(ApiEndpoints.PRODUCTION.url)
                .build();
    }

    @Singleton
    @Provides
    MvpApi provideMvpApi(Retrofit retrofit) {
        return retrofit.create(MvpApi.class);
    }
}
